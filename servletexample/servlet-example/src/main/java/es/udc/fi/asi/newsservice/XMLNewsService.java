package es.udc.fi.asi.newsservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Reads the latest news from an XML file.
 */
public class XMLNewsService implements NewsService {
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public List<NewTO> getLatestNews() {

		System.out.println( "===== Reading latest news from an XML file =====" );
		
		ArrayList<NewTO> newsList = new ArrayList<NewTO>();		
		newsList.add(new NewTO("New Spring version released!",
				"Visit www.spring.org"));
		newsList.add(new NewTO("Spring into Action, 3rd edition",
				"Visit www.manning.com"));
		
		return newsList;
	}

}
