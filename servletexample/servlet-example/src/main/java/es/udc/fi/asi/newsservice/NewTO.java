package es.udc.fi.asi.newsservice;

/**
 * News Transfer Object (TO)
 */
public class NewTO {
	
	private String title;
	private String text;
	
	public NewTO(String title, String text) {
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return "NewTO [title=" + title + ", text=" + text + "]";
	}

}
