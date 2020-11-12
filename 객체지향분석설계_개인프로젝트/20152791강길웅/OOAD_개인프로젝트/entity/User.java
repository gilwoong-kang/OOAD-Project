package entity;

public class User {
	private UserLevel level;
	private String userNumber;
	
	public User(String userNumber) {
		this.userNumber = userNumber;
	}
	
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber; 
	}
	
	public String getUserNumber() {
		return userNumber;
	}
	
	public void setUserLevel(UserLevel level) {
		this.level = level;
	}
	public UserLevel getUserLevel() {
		return level;
	}
}
