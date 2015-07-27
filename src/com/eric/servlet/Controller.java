package com.eric.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
//Servlet import packages
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//baseLib imports
import com.baselib.servlet.BaseServlet;
import com.eric.pojo.URLParser;
import com.eric.pojo.htmlFormater;
//project imports
import com.eric.pojo.webAccessor;
/**
 * Servlet implementation class Controller
 */
public class Controller extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/* (non-Javadoc)
	 * @see com.baselib.servlet.BaseServlet#getAndPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void getAndPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		req.getSession().removeAttribute("htmlFormat");
		Integer counts = (Integer)session.getAttribute("count");
		if(counts == null){
		counts = new Integer(1);
		session.setAttribute("count",  counts);
		}else{
		counts++;
		session.setAttribute("count", counts);
		}
		String url=null;
		webAccessor wa = null;
		if(req.getParameter("url") != null){
			url="";
			String format = req.getParameter("format");
			url = req.getParameter("url");
			String display = req.getParameter("Display");
		
			URLParser up = new URLParser(url);
			up.parseDisplay();
			url = up.getUrl();
			
			if(display.equals("desktop")){
				wa = new webAccessor(url, "User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:38.0) Gecko/20100101 Firefox/38.0");
			}
			else if(display.equals("mobile")){
				wa = new webAccessor(url, "User-Agent", "Mozilla/5.0 (Android 4.4; Mobile; rv:41.0) Gecko/41.0 Firefox/41.0");
			}
			else{
				wa = new webAccessor(url, "User-Agent", "Mozilla/5.0 (Android 4.4; Tablet; rv:41.0) Gecko/41.0 Firefox/41.0");
			}
			// TODO: Evaluate using three seperate user agents
			htmlFormater hf = new htmlFormater(wa.getHtml(), display, url);
			//wa.setHtml(hf.displayFormat());
			
			if(format.equals("source")){
				req.getSession().setAttribute("htmlFormat", hf.format());
			}
			else{
				req.getSession().setAttribute("htmlFormat", wa.getHtml());
			}
			req.removeAttribute("url");
			req.removeAttribute("format");
			req.removeAttribute("Display");
			
		}
		ServletContext sc = this.getServletContext();
		if(url != null){
			sc.getRequestDispatcher("/WEB-INF/include/index.jsp").forward(req, res);
		}else{	
			sc.getRequestDispatcher("/WEB-INF/include/main.jsp").forward(req, res);
			}
	}

}
