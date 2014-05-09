package es.udc.fi.asi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.udc.fi.asi.newsservice.NewTO;
import es.udc.fi.asi.newsservice.NewsService;

public class ServletNewsService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
		
		NewsService newsService = (NewsService) context.getBean("newsServiceBean");
		
		List<NewTO> newsList = newsService.getLatestNews();
		
		List<String> newsTitle = new ArrayList<String>();
		List<String> newsContent = new ArrayList<String>();
		
		String filter = request.getParameter("keywords");
		
		for(int i = 0; i < newsList.size(); i++) {
			String tmpTitle = newsList.get(i).getTitle();
			
			if(filter.compareTo("") == 0 || tmpTitle.contains(filter))
			{
				newsTitle.add(tmpTitle);
				newsContent.add(newsList.get(i).getText());
			}
		}
		
		request.setAttribute("titles", newsTitle);
		request.setAttribute("texts", newsContent);
		
		
		request.getRequestDispatcher("news.jsp").forward(request, response);
	}

}
