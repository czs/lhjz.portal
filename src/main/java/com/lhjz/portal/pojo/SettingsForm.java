package com.lhjz.portal.pojo;

import org.hibernate.validator.constraints.NotBlank;

import com.lhjz.portal.pojo.Enum.Module;
import com.lhjz.portal.pojo.Enum.Page;

public class SettingsForm {

	@NotBlank
	private String page;
	@NotBlank
	private String module;

	private String imgUrl;
	private String title;
	private String content;
	private String detail;
	private String link;
	private String more;

	public Page page() {
		switch (page) {
		case "index":
			return Page.Index;
		default:
			return Page.Unknow;
		}
	}

	public Module module() {
		switch (module) {
		case "bigImg":
			return Module.BigImg;
		case "hotNews":
			return Module.HotNews;
		case "moreNews":
			return Module.MoreNews;
		default:
			return Module.Unknow;
		}
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	@Override
	public String toString() {
		return "SettingsForm [page=" + page + ", module=" + module
				+ ", imgUrl=" + imgUrl + ", title=" + title + ", conent="
				+ content + ", detail=" + detail + ", link=" + link + ", more="
				+ more + "]";
	}

}
