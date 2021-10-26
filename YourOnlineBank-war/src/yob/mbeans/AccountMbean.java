package yob.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import yob.controller.AccountContainer;
import yob.repository.AccountRepository;
import yob.repository.UserRepository;
import yob.repository.entities.Account;
import yob.repository.entities.Address;
import yob.repository.entities.User;
import yob.util.FacesContextUtils;

@Named("accountMbean")
@RequestScoped
public class AccountMbean {
	@EJB
	AccountRepository accountRepository;
	@EJB
	UserRepository userRepository;
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	public Account getAccoutByNo(String no) {
		return accountRepository.findByNo(no);
	}
	public Account getAccountByUserId(String uuid) {
		User user = userRepository.findByUUID(uuid);
		return accountRepository.findByUser(user);
	}
	public void del(String no) {
		accountRepository.del(no);
	}
	public void edit(Account account) {
		try {
			accountRepository.update(account);
			FacesContextUtils.showMessage("Update successful...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContextUtils.showMessage("Update Failed...");
			e.printStackTrace();
		}
	}
	public void add(Account account) {
		accountRepository.add(account);
	}
	public void add(AccountContainer accountContainer) {
		Account account = convertToEntity(accountContainer);
		this.add(account);
	}
	public Account convertToEntity(AccountContainer accountContainer) {
		Address address = new
				Address(accountContainer.getStreetNumber(),accountContainer.getStreetAddress(),accountContainer.getSuburb(),accountContainer.getPostcode(),accountContainer.getState());
		User user =
				userRepository.findByUUID(accountContainer.getOwner().getUuid());
		return new Account(accountContainer.getAccountName(), address,
				accountContainer.getTotal(), user);
	}
}