package yob.repository;

import java.util.List;

import javax.ejb.Remote;

import yob.repository.entities.User;

@Remote
public interface UserRepository {
	public void add(User user);
	public void del(String uuid);
	public void update(User user);
	public User findByUUID(String uuid);
	public List<User> findAll();
	public List<User> findByType(String type);
	public User findByAccountNo(String accountNo);
}