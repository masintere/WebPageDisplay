package com.eric.pojo;

import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: htmlFormater.java <p/>
 * <b>Project</b>: WebPageDisplay <p/>
 * <b>Description: </b> Takes a URL and input to display source code or html view, and weather to have a mobile (mobile/tablet) or desktop display
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jul 23, 2015<p/>
 * @updates:
 ****************************************************************************/
public class HtmlFormater {
	private String html;
	private String display;
	private String url;
	public static final String LINK = "<link";
	public static final String HREF = "href=\"";

	public HtmlFormater(String html, String display, String url){
		this.html = html;
		this.display = display;
		this.url = url;
	}
	
	public String displayFormat(){
		int linkPos = html.indexOf(LINK) + LINK.length();
		int nxtlinkPos = 0;
		while(nxtlinkPos - linkPos < 2){
		nxtlinkPos = linkPos + 1;
		int hrefPos = html.substring(linkPos).indexOf(HREF) + HREF.length();
		String before = html.substring(0, linkPos + hrefPos);
		String after = html.substring(linkPos + hrefPos, html.length() -1);
		html =before + url + after;
		linkPos = html.indexOf(LINK, nxtlinkPos) + LINK.length();
		
		}
		
		return html;
	}
	
	/**
	 * replaces all < and > in html code with &lt and &gt
	 * @return the new html cod
	 */
	public String format(){
		html = html.replaceAll("<", "&lt");
		html = html.replaceAll(">", "&gt" + "</br>");
		
		return html;
	}
	
}
