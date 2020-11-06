package bean;

public class UserBean {
	
	private String userId;
	private String password;
	private String timeStamp;
	
	public UserBean() {
		this.userId = null;
		this.password = null;
		this.timeStamp = null;
	}
	
	public UserBean(String userId, String password, String timeStamp) {
		this.userId = userId;
		this.password = password;
		this.timeStamp = timeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
	
}
