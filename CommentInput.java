package domain.login;

/**
 * 
 * @author mehra
 * This is the Customer before the validation.
 */
public class CommentInput {
	private String username;
	private String commentText;
	
	public CommentInput(String username, String commentText){
		this.username = username;
		this.commentText = commentText;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setPassword(String commentText) {
		this.commentText = commentText;
	}

}
