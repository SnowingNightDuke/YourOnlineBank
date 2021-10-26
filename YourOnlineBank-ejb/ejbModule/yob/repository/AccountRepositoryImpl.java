package yob.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import yob.repository.entities.Account;
import yob.repository.entities.User;

@Stateless
public class AccountRepositoryImpl implements AccountRepository {
	@PersistenceContext(unitName = "YourOnlineBank-ejbPU")
	EntityManager em;
	@Override
	public void add(Account account) {
		em.persist(account);
	}
	@Override
	public void del(String no) {
		Account account = this.findByNo(no);
		if (account!=null) {
			em.remove(account);
		}
	}
	@Override
	public void update(Account account) {
		em.merge(account);
	}
	@Override
	public Account findByNo(String no) {
		return em.find(Account.class, no);
	}
	@Override
	public List<Account> findAll() {
		return
				em.createNamedQuery(Account.GET_ALL_NAMED_QUERY).getResultList();
	}
	@Override
	public Account findByUser(User user) {
		Query createQuery = em.createQuery("select a from account a where a.owner = :auser");
				createQuery.setParameter("auser", user);
				return (Account) createQuery.getResultList().get(0);
	}
	@Override
	public Account findByUserId(String uuid) {
		Query createQuery = em.createQuery("select a from account a where a.owner.uuid = :uuid");
				createQuery.setParameter("uuid", uuid);
				return (Account) createQuery.getResultList().get(0);}
	@Override
	public Account findByUsername(String username) {
		Query createQuery = em.createQuery("select a from account a where a.owner.username = :username");
				createQuery.setParameter("username", username);
				return (Account) createQuery.getResultList().get(0);
	}
}