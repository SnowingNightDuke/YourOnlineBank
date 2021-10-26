package yob.repository;

import java.util.List;

import javax.ejb.Remote;

import yob.repository.entities.Account;
import yob.repository.entities.User;

@Remote
public interface AccountRepository {
	public void add(Account account);
	public void del(String no);
	public void update(Account account);
	public Account findByNo(String no);
	public List<Account> findAll();
	public Account findByUser(User user);
	public Account findByUserId(String uuid);
	public Account findByUsername(String username);
}
