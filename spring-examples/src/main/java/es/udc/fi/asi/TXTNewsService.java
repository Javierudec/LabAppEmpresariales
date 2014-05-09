package es.udc.fi.asi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class TXTNewsService implements NewsService {
	private String path;
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	@Override
	public List<NewTO> getLatestNews() {
		System.out.println( "===== Reading latest news from an TXT file =====" );
		
		ArrayList<NewTO> newsList = new ArrayList<NewTO>();		
		
		Scanner in;
		try {
			in = new Scanner(new FileReader(path));
			while(in.hasNext())
			{
				newsList.add(new NewTO(in.nextLine(), in.nextLine()));
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newsList;
	}

}
