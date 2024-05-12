package com.jcode;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ComposeServlet")
public class ComposeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.html");
		}else{
			String sender=(String)session.getAttribute("sender");
			out.print("<span style='float:right'>Hi, "+sender+"</span>");
			
			String msg=(String)request.getAttribute("message");
			if(msg!=null){
				out.print("<p>"+msg+"</p>");
			}
		request.getRequestDispatcher("composeform.html").include(request, response);
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
