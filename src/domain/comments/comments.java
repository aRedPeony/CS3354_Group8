package domain.comments;

//Madeline Peterson


public class comments{
	private String comment;
	private long timestamp;
	private String username;
	private String page;
	private boolean reviewed;
	
	public String getPage() {
		return page;
	}
	public String getComment() {
		return comment;
	}
	public long getTime() {
		
		return timestamp;
	}
	public String getUsername() {
		return username;
	}
	public boolean getReviewed()  {
		return reviewed;
	}
	public void setPage(String page) {
		this.page=page;
	}
	public void setTime() {
		java.util.Date date = new java.util.Date();
		timestamp=date.getTime();
	}
	public void setComment(String comment) {
		this.comment=comment;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public void setReviewed(boolean reviewed) {
		this.reviewed=reviewed;
	}
}