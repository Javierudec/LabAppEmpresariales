package es.udc.fi.asi;

import java.util.List;

public class NewsServiceClient {
	
	/** News service */
	private NewsService newsService;
	
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	/** Prints the latest news */
	public void showLatestNews() {
		
		List<NewTO> latestNews = newsService.getLatestNews();
		
		for (NewTO n : latestNews)
			System.out.println(n);
	}

}
