package yob.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import yob.mbeans.UserMbean;
import yob.repository.entities.User;
import yob.util.FacesContextUtils;

@Named("userController")
@RequestScoped
public class UserController {
	private String uuid;
	private User user;
	public UserController() {
		this.uuid = FacesContextUtils.getParameter("uuid");
		this.user = ((UserMbean)FacesContextUtils.getManagedBean("userMbean")).getUserByUuid(uuid);
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
