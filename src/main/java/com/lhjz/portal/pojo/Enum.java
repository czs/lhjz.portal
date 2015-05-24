
package com.lhjz.portal.pojo;

/**
 * 
 * @author xi
 * 
 * @date 2015年4月25日 上午11:25:00
 * 
 */
public class Enum {

	public static enum Status {

		Normal, Deleted, Bultin, New, Opening, Analyzing, Accepted, Processing, Resolved, Closed;

	}

	public static enum Action {
		Create, Read, Update, Delete, Upload;
	}

	public static enum Target {
		Article, File, Feedback;
	}
}
