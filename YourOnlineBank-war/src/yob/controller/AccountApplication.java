package yob.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import yob.mbeans.AccountMbean;
import yob.mbeans.UserMbean;
import yob.repository.entities.Account;
import yob.util.FacesContextUtils;

@Named("accountApp")
@ApplicationScoped
public class AccountApplication implements Serializable {
	private ArrayList<Account> accounts;
	private AccountMbean accountMbean;
	private UserMbean userMbean;
	public AccountApplication() {
		accounts = new ArrayList<Account>();
		accountMbean = FacesContextUtils.getManagedBean("accountMbean");
		userMbean = FacesContextUtils.getManagedBean("userMbean");
		updateAccounts();
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public AccountMbean getAccountMbean() {
		return accountMbean;
	}
	public void setAccountMbean(AccountMbean accountMbean) {
		this.accountMbean = accountMbean;
	}
	public UserMbean getUserMbean() {
		return userMbean;
	}
	public void setUserMbean(UserMbean userMbean) {
		this.userMbean = userMbean;
	}
	public void updateAccounts() {
		accounts.clear();
		for (Account a : accountMbean.getAllAccount()) {
			accounts.add(a);
		}
	}
	public void remove(Account account) {
		try {
			accountMbean.del(account.getAccountNo());
			FacesContextUtils.showMessage("Account(" + account.getAccountNo() +
					") has been removed.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContextUtils.showMessage("Remove failed...");
			e.printStackTrace();
		}
		updateAccounts();
	}
	public void add(AccountContainer accountContainer) {
		try {
			accountMbean.add(accountContainer);
			FacesContextUtils.showMessage("Add Account Successfully...");
		} catch (Exception e) {
			FacesContextUtils.showMessage("Add Account Failed...");
			e.printStackTrace();
		}
		updateAccounts();
	}
}
