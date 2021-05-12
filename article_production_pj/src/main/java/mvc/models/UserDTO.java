package mvc.models;

import java.io.*;

import org.apache.commons.codec.digest.*;

public class UserDTO implements Serializable{
	private String password;
	private String email;
	private String id;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = DigestUtils.sha512Hex(password);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id;
	}
	
	
}
