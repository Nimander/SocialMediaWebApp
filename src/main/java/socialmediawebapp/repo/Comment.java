package socialmediawebapp.repo;

public class Comment {
	private String userName;
	private String message;
	private String timestamp;

	public Comment(String userName, String message, String timestamp){
		this.userName = userName;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getUserName() {
		return userName;
	}

	public String getTimestamp() {
		return timestamp;
	}
}

