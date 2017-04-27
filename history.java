package default1;

public class history {

	private String date;
	private String link;

	public history(){
		this.date="";
		this.link="";
	}
	public history(String date,String link){
		this.date=date;
		this.link=link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
