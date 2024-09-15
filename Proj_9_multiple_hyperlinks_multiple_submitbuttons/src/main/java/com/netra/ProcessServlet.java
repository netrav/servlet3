package com.netra;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/processurl")
public class ProcessServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		String s1Val=req.getParameter("s1");
		int val1=0;
		int val2=0;
		
		if(!s1Val.equalsIgnoreCase("link1") && (!s1Val.equalsIgnoreCase("link2"))) //readtextbox value when req is not coming from hyperlink
		{
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));			
		}
		
		if( s1Val.equalsIgnoreCase("add"))
			pw.println("<h1> sum of "+val1+" and "+val2+" is ::"+(val1+val2)+"</h1>");
		else if(s1Val.equalsIgnoreCase("sub"))
			pw.println("<h1> sub of "+val1+" and "+val2+ "is ::"+(val1-val2)+"</h1>");
		else if(s1Val.equalsIgnoreCase("mul"))
			pw.println("<h1> mul of "+val1+" and "+val2+" is ::"+(val1*val2)+"</h1>");
		else if(s1Val.equalsIgnoreCase("div"))
			pw.println("<h1> div of "+val1+" and "+val2+" is ::"+((float)val1/val2)+"</h1>");
		else if(s1Val.equalsIgnoreCase("link1")) {
			pw.println("<h1>System Properties are :: </h1>");
		    pw.println("<b>"+System.getProperties());
		}
		 else	
	        pw.println("<h1>System Date Time:: "+LocalDate.now()+"</h1>");
		
		pw.println("<br><a href='form.html'>Home</a>");
				
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	

}
