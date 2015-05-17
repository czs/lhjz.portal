/**
 * 立衡脊柱版权所有 (lhjz)
 */
package com.lhjz.portal.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lhjz.portal.base.BaseController;
import com.lhjz.portal.entity.Article;
import com.lhjz.portal.model.RespBody;
import com.lhjz.portal.pojo.ArticleForm;
import com.lhjz.portal.repository.ArticleRepository;
import com.lhjz.portal.repository.FileRepository;
import com.lhjz.portal.util.ImageUtil;
import com.lhjz.portal.util.JsonUtil;
import com.lhjz.portal.util.StringUtil;
import com.lhjz.portal.util.WebUtil;

/**
 * 
 * @author xi
 * 
 * @date 2015年3月28日 下午1:19:05
 * 
 */
@Controller
@RequestMapping("admin/article")
public class ArticleController extends BaseController {

	static Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	Environment env;

	@Autowired
	FileRepository fileRepository;
	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public RespBody save(HttpServletRequest request,
			HttpServletResponse response, Model model, Locale locale,
			@Valid ArticleForm articleForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return RespBody.failed(bindingResult.getAllErrors().stream()
					.map(err -> err.getDefaultMessage())
					.collect(Collectors.joining("<br/>")));
		}

		// check the save content of the article is exists or not.
		List<Article> articles = articleRepository.findByContent(articleForm
				.getContent());

		if (articles.size() > 0) {
			return RespBody.failed("该文章已经存在！");
		}

		Article article = new Article();
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		article.setCreateDate(new Date());
		article.setUsername(WebUtil.getUsername());

		articleRepository.save(article);

		return RespBody.succeed();
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request,
			HttpServletResponse response, Model model, Locale locale,
			@RequestParam("file") MultipartFile[] files) {

		logger.debug("upload file start...");

		String realPath = WebUtil.getRealPath(request);

		String storePath = env.getProperty("lhjz.upload.img.store.path");
		int sizeOriginal = env.getProperty(
				"lhjz.upload.img.scale.size.original", Integer.class);
		int sizeLarge = env.getProperty("lhjz.upload.img.scale.size.large",
				Integer.class);
		int sizeHuge = env.getProperty("lhjz.upload.img.scale.size.huge",
				Integer.class);

		try {
			// make upload dir if not exists
			FileUtils.forceMkdir(new File(realPath + storePath + sizeOriginal));
			FileUtils.forceMkdir(new File(realPath + storePath + sizeLarge));
			FileUtils.forceMkdir(new File(realPath + storePath + sizeHuge));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return StringUtil.wrapByTextarea(JsonUtil.toJson(RespBody.failed(e
					.getMessage())));
		}

		List<com.lhjz.portal.entity.File> saveFiles = new ArrayList<com.lhjz.portal.entity.File>();

		RespBody respBody = RespBody.succeed();

		for (MultipartFile file : files) {

			String originalFileName = file.getOriginalFilename();

			if (!ImageUtil.isImage(originalFileName)) {
				logger.error("上传文件不是图片！ 文件名: {}", originalFileName);
				respBody.status(false).addMsg(
						String.format("上传文件不是图片！ 文件名: %s", originalFileName));
				continue;
			}

			String type = originalFileName.substring(originalFileName
					.lastIndexOf("."));

			String uuid = UUID.randomUUID().toString();

			String uuidName = StringUtil.replace("{?1}{?2}", uuid, type);

			// relative file path
			String path = storePath + sizeOriginal + "/" + uuidName;// 原始图片存放
			String pathLarge = storePath + sizeLarge + "/" + uuidName;// 缩放图片存放
			String pathHuge = storePath + sizeHuge + "/" + uuidName;// 缩放图片存放

			// absolute file path
			String filePath = realPath + path;

			try {

				// store into webapp dir
				file.transferTo(new File(filePath));

				// scale image size as thumbnail
				// 图片缩放处理.120*120
				ImageUtil.scale2(filePath, realPath + pathLarge, sizeLarge,
						sizeLarge, true);
				// 图片缩放处理.640*640
				ImageUtil.scale2(filePath, realPath + pathHuge, sizeHuge,
						sizeHuge, true);

				// 保存记录到数据库
				com.lhjz.portal.entity.File file2 = new com.lhjz.portal.entity.File();
				file2.setCreateDate(new Date());
				file2.setName(originalFileName);
				file2.setUsername(WebUtil.getUsername());
				file2.setUuidName(uuidName);
				file2.setPath(storePath + sizeOriginal + "/");
				saveFiles.add(fileRepository.save(file2));

			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
				return StringUtil.wrapByTextarea(JsonUtil.toJson(RespBody
						.failed(e.getMessage())));
			}
		}

		response.setHeader("X-Frame-Options", "SAMEORIGIN");

		// back relative file path
		return StringUtil.wrapByTextarea(JsonUtil.toJson(respBody
				.data(saveFiles)));
	}
}
