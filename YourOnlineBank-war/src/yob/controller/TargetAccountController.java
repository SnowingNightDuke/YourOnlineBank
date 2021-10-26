package yob.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import yob.mbeans.AccountMbean;
import yob.repository.entities.Account;
import yob.util.FacesContextUtils;

@Named("targetAccountController")
@SessionScoped
public class TargetAccountController implements Serializable {
	private String accountNo;
	public TargetAccountController() {
		this.accountNo = "";
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getTargetAccountNo() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "***************************";
		} else {
			return account.getAccountNo();
		}
	}
	public String getTargetAccountName() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "Input Account To Transfer";
		} else {
			return account.getAccountName();
		}
	}
	public String getTargetAccountOwner() {
		AccountMbean accountMbean =
				FacesContextUtils.getManagedBean("accountMbean");
		Account account = accountMbean.getAccoutByNo(accountNo);
		if (account == null) {
			return "***************************";
		} else {
			return account.getOwner().getUsername();
		}
	}
	public void clear() {
		this.accountNo = "";
	}
}
