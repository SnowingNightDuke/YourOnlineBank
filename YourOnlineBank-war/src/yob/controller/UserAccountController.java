package yob.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import yob.mbeans.AccountMbean;
import yob.repository.entities.Account;
import yob.util.FacesContextUtils;

@Named("userAccountController")
@SessionScoped
public class UserAccountController implements Serializable {
	private String accountNo;
	public UserAccountController() {
		this.accountNo = "";
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void clear() {
		this.accountNo = "";
	}
	public String getUserAccountNo() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "Account Not Found";
		}else {
			return account.getAccountNo();
		}
	}
	public String getUserAccountName() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "Account Not Found";
		}else {
			return account.getAccountName();
		}
	}
	public String getUserAccountOwner() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "Account Not Found";
		}else {
			return account.getOwner().getUsername();
		}
	}
	public String getUserAccountTotal() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "Account Not Found";
		}else {
			return String.valueOf(account.getTotal());
		}
	}
}
