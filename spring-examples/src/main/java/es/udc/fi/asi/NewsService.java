package es.udc.fi.asi;

import java.util.List;

/**
 * Interface of the news service.
 */
public interface NewsService {
	
	/**
	 * Returns a list with the latest news.
	 */
	public List<NewTO> getLatestNews();

}
