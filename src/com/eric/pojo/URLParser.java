package com.eric.pojo;

/****************************************************************************
 * <b>Title</b>: displayParser.java <p/>
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
public class URLParser {

	private String url;
	
	public URLParser(String url){
		this.url = url;
	}
	
	/**
	 * appends http:// to the beggining of the url if it isn't there
	 */
	public void parseDisplay(){
		if((url.indexOf("http://") + url.indexOf("http://")) <0){
			url = "http://" + url;
		}
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
}
