package mvc.models;

import java.io.*;
import java.util.*;

import lombok.*;

@Data
public class ArticleDTO implements Serializable {
	private long no;
	private String title;
	private String subtitle;
	private String leadsentence;
	private String divide;
	private String content;
	private String photo;
	private Date regdate;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getLeadsentence() {
		return leadsentence;
	}
	public void setLeadsentence(String leadsentence) {
		this.leadsentence = leadsentence;
	}
	public String getDivide() {
		return divide;
	}
	public void setDivide(String divide) {
		this.divide = divide;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "ArticleDTO [no=" + no + ", title=" + title + ", subtitle=" + subtitle + ", leadsentence=" + leadsentence
				+ ", divide=" + divide + ", content=" + content + ", photo=" + photo + ", regdate=" + regdate + "]";
	}
	
}