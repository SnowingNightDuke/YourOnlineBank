package yob.repository.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import yob.util.IDUtils;

@Entity(name = "sys_user")
@NamedQueries({ @NamedQuery(name = User.GET_ALL_NAMED_QUERY, query = "select u from sys_user u") })

public class User implements Serializable {
	public static final String GET_ALL_NAMED_QUERY = "User.getAll";
	@Id
	private String uuid;
	private String username;
	private String password;
	private String type;
	@OneToOne(mappedBy = "owner", cascade = { CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.DETACH })
	private Account account;
	public User() {
		super();
	}
	public User(String username, String password, String type) {
		super();
		this.uuid = IDUtils.generateUserUUID();
		this.username = username;
		this.password = password;
		this.type = type;
		this.account = null;
	}
	public User(String uuid, String username, String password, String type,
			Account account) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.type = type;
		this.account = account;
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
