package es.udc.fi.asi;

import java.util.ArrayList;
import java.util.List;

/**
 * Reads the latest news from a relational DB.
 */

public class DBNewsService implements NewsService {

	public List<NewTO> getLatestNews() {
		
		System.out.println( "===== Reading latest news from a RELATIONAL database =====" );
		
		ArrayList<NewTO> newsList = new ArrayList<NewTO>();		
		newsList.add(new NewTO("PostgreSQL in a nutshell!",
				"Check out this new book..."));
		
		return newsList;
	}

}
