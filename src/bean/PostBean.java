package bean;

public class PostBean {
	
	private String postId;
	private String userId;
	private String content;
	private String timeStamp;
	
	public PostBean() {
		this.postId = null;
		this.userId = null;
		this.content = null;
		this.timeStamp = null;
	}
	
	public PostBean(String postId, String userId, String content, String timeStamp) {
		this.postId = postId;
		this.userId = userId;
		this.content = content;
		this.timeStamp = timeStamp;
	}

	public String getPostId() {
		return postId;
	}

	public String getUserId() {
		return userId;
	}

	public String getContent() {
		return content;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
	
}