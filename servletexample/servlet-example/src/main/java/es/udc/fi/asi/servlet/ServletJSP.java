package es.udc.fi.asi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletJSP extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		List<String> movies = new ArrayList<String>();
		movies.add("Movie 1");
		movies.add("Movie 2");
		movies.add("Movie 3");
		
		request.setAttribute("movies", movies);
		
		request.getRequestDispatcher("example2.jsp").forward(request, response);
	}

}
