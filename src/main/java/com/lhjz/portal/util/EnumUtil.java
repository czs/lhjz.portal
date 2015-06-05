package com.lhjz.portal.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lhjz.portal.pojo.Enum.Status;

public class EnumUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(EnumUtil.class);

	public static Status status(String status) {

		for (Status sts : Status.values()) {
			if (sts.name().equalsIgnoreCase(status)) {
				logger.info("Mapped status: {} <-> {}", status, sts.name());
				return sts;
			}
		}

		logger.info("Unmapped status: {}. Return: {}", status,
				Status.Unknow.name());

		return Status.Unknow;
	}

}
