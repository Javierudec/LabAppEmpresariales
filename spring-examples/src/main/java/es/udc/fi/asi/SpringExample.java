package es.udc.fi.asi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {
	
	/* 
	 * Example without using Spring: the client and the specific service
	 * implementation are wired in the code.
	 */
	public void exampleNoSpring() {
		
		DBNewsService dbNewsService = new DBNewsService();
		
		NewsServiceClient newsServiceClient = new NewsServiceClient();
		newsServiceClient.setNewsService(dbNewsService);
		
		newsServiceClient.showLatestNews();
	}
	
	/* 
	 * Example using Spring: the client and the specific service
	 * implementation are NOT wired in the code.
	 */
	public void exampleSpring() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-module.xml");
		
		NewsServiceClient newsServiceClient =
				(NewsServiceClient) context.getBean("newsServiceClientBean");
		
		newsServiceClient.showLatestNews();
		
	}
	
    public static void main(String [] args) {
    	
    	SpringExample se = new SpringExample();
    	
    	System.out.println("Example without Spring.");
    	se.exampleNoSpring();
    	
    	System.out.println("");
    	System.out.println("Example with Spring.");
    	se.exampleSpring();
    }
}
