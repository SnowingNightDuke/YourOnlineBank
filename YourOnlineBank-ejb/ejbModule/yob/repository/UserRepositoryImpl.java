package yob.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import yob.repository.entities.User;

@Stateless
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext(unitName = "YourOnlineBank-ejbPU")
	EntityManager em;
	@Override
	public void add(User user) {
		try {
			em.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void del(String uuid) {
		try {
			User user = this.findByUUID(uuid);
			if (user != null) {
				em.remove(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(User user) {
		try {
			em.merge(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public User findByUUID(String uuid) {
		try {
			return em.find(User.class, uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;}
	@Override
	public List<User> findAll() {
		return
				em.createNamedQuery(User.GET_ALL_NAMED_QUERY).getResultList();
	}
	@Override
	public List<User> findByType(String type) {
		Query createQuery = this.em.createQuery("select u from sys_user u where u.type = :utype");
				createQuery.setParameter("utype", type);
				return createQuery.getResultList();
	}
	@Override
	public User findByAccountNo(String accountNo) {
		Query createQuery = this.em.createQuery("select u from sys_user u where u.account.accountNo = :accountNo");
				createQuery.setParameter("accountNo", accountNo);
				return (User) createQuery.getResultList();
	}
}