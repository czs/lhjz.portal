package com.lhjz.portal.util;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class FileUtilTest {

	@Test
	public void test(){
		System.out.println(FileUtil.getName("C:\\ddfd\\dfdfdff\\etetr.txt"));

		System.out.println(FileUtils.getFile("C:\\ddfd\\dfdfdff\\etetr.txt")
				.getName());
	}
}
