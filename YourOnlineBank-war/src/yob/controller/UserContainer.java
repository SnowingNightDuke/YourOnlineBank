package yob.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("user")
@RequestScoped
public class UserContainer {
	private String uuid;
	private String username;
	private String password;
	private String type;
	public UserContainer() {
	}
	public UserContainer(String uuid, String username, String password, String
			type) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}