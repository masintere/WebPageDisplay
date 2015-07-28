package com.eric.pojo;

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
public class htmlFormater {
	private String html;
	private String display;
	private String url;
	public static final String HEAD = "</head>";
	public static final String HREF = "href=\"";

	public htmlFormater(String html, String display, String url){
		this.html = html;
		this.display = display;
		this.url = url;
	}
	
	public String displayFormat(){
		int headPos = html.indexOf(HEAD);
		String before = html.substring(0, headPos);
		String after = html.substring(headPos, html.length() -1);
		if(display.equals("mobile")){
			html = before + "<style>\n.newBody{width:100%; max-width:300px;}</style>" + after;
		}
		if(display.equals("tablet")){
			html = before + "<style>\n.newBody{width:100%; max-width:700px;}</style>" + after;
		}
		
		return html;
	}
	
	public Map<Integer, String> returnLinks(){
		return null;
	}
	
	public String formattedHtml(){
		return null;
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
