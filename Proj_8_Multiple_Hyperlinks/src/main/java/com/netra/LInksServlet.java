package com.netra;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/linksurl")
public class LInksServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        Locale locales[] = Locale.getAvailableLocales();
        String pval = req.getParameter("p1");

        if (pval != null) {
            if (pval.equalsIgnoreCase("link1")) {
                pw.println("<h1>All Languages are here</h1>");
                for (Locale l : locales) {
                    pw.println(l.getDisplayLanguage() + " ");
                }
            } else if (pval.equalsIgnoreCase("link2")) {
                pw.println("<h1>All Countries are </h1>");
                for (Locale l : locales) {
                    pw.println(l.getDisplayCountry() + " ");
                }
            } else {
                pw.println("<h1>System date and Time::" + LocalDateTime.now() + "</h1>");
            }
        } else {
            pw.println("<h1>Invalid request parameter.</h1>");
        }
        pw.println("<br><a href='links.html'>home</a>");
        pw.close();
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Implement doPost if needed
    }
	
	

}
