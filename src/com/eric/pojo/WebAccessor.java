package com.eric.pojo;

import java.io.IOException;

import com.baselib.pojo.html.*;

/****************************************************************************
 * <b>Title</b>: webAccessor.java <p/>
 * <b>Project</b>: WebPageDisplay <p/>
 * <b>Description: </b> Takes a URL and input to display source code or html view, and weather to have a mobile (mobile/tablet) or desktop displaye
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jul 22, 2015<p/>
 * @updates:
 ****************************************************************************/
public class WebAccessor extends HTMLSpider{

	private String html;
	/**
	 * @param url
	 * @throws IOException
	 */
	public WebAccessor(String url, String userAgent, String browser) throws IOException {
		super(url, userAgent, browser);
		html = readData();
		// TODO Auto-generated constructor stub
	}
	
	public String getHtml(){
		return html;
	}
	
	public void setHtml(String html){
		this.html = html;
	}
	
	

}
