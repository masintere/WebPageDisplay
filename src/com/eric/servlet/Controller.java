package com.eric.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

//Servlet import packages
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//baseLib imports
import com.eric.pojo.URLParser;
import com.baselib.servlet.BaseServlet;
import com.eric.pojo.HtmlFormater;
//project imports
import com.eric.pojo.WebAccessor;
/**
 * Servlet implementation class Controller
 */
public class Controller extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext sc = null;
	private String mainDisplay = "main.jsp";
	private String websiteDisplay = "index.jsp";
	
	private static final Map<String, String> USER_AGENTS = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L; {
			put("desktop", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:38.0) Gecko/20100101 Firefox/38.0");
			put("mobile", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
			put("tablet", "Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10");
	}};

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
    public void init(ServletConfig config) {
    	sc = config.getServletContext();
    }
    

	/* (non-Javadoc)
	 * @see com.baselib.servlet.BaseServlet#getAndPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void getAndPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		Integer counts = session.getAttribute("count") == null ? 0 : (Integer) session.getAttribute("count");
		session.setAttribute("count", counts++);
		String path = mainDisplay;
		
		if(req.getParameter("url") != null) this.getHtml(req);

		if(req.getAttribute("htmlFormat") != null) path = websiteDisplay;
		sc.getRequestDispatcher("/WEB-INF/include/" + path).forward(req, res);
		
	}
	
	/**
	 * 
	 * @param req
	 * @throws IOException
	 */
	public void getHtml(HttpServletRequest req) throws IOException {
		
		String display = req.getParameter("Display");
		
		URLParser up = new URLParser(req.getParameter("url"));
		WebAccessor wa = new WebAccessor(up.getUrl(), "User-Agent", USER_AGENTS.get(display));

		HtmlFormater hf = new HtmlFormater(wa.getHtml(), display, up.getUrl());
		wa.setHtml(hf.displayFormat());
		
		// TODO: Evaluate using three seperate user agents
		if(req.getParameter("format").equals("source")){
			
			req.setAttribute("htmlFormat", hf.format());
		} else{
			req.setAttribute("htmlFormat", wa.getHtml());
		}
	}

}
