package org.zk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConvert implements Converter<String, Date> {

	private static Logger logger = LoggerFactory.getLogger(MyDateConvert.class);

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			logger.warn("时间绑定异常", e);
		}
		return null;
	}
}
