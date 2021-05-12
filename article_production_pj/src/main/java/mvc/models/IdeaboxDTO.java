package mvc.models;

import java.io.*;

public class IdeaboxDTO implements Serializable{
	private String nickname;
	private String idea;
	private String memo;
	private String email;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIdea() {
		return idea;
	}
	public void setIdea(String idea) {
		this.idea = idea;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "IdeaboxDTO [nickname=" + nickname + ", idea=" + idea + ", memo=" + memo + ", email=" + email + "]";
	}
	
	
}
