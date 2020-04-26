package org.zk.web;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * jxls excel视图，下载文件名从request的"DOWNLOAD_FILE_NAME"属性中获取
 */
public class JxlsExcelView extends AbstractTemplateView {

	public static final String DOWNLOAD_FILE_NAME = "DOWNLOAD_FILE_NAME";

	@Override
	protected void renderMergedTemplateModel(
			Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Context context = new Context(model);
		response.setContentType(this.getContentType());
		String downloadFileName = (String)request.getAttribute(DOWNLOAD_FILE_NAME);
		String encodeDownloadFileName = encodeDownloadFileName(downloadFileName, request);
		response.setHeader("content-disposition","attachment;filename=" + encodeDownloadFileName);
		ServletOutputStream os = response.getOutputStream();
		Resource resource = this.getApplicationContext().getResource(this.getUrl());
		JxlsHelper.getInstance().processTemplate(resource.getInputStream(), os, context);
	}

	private String encodeDownloadFileName(String fileName, HttpServletRequest request) throws UnsupportedEncodingException {
		String userAgent = request.getHeader("User-Agent").toUpperCase();
		if (userAgent.contains("MSIE") || userAgent.contains("TRIDENT")) {
			// ie
			return URLEncoder.encode(fileName, "UTF-8");
		} else {
			// chrome, firefox
			return new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
	}




}
