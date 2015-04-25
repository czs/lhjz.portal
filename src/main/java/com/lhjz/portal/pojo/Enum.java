
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

		NORMAL(0), DELETED(1), BULTIN(2);

		private int status;

		private Status(int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}

	}
}
