package yob.repository;

import java.util.List;

import javax.ejb.Remote;

import yob.repository.entities.Account;
import yob.repository.entities.Transaction;

@Remote
public interface TransactionRepository {
	public void add(Transaction transaction);
	public void del(String no);
	public void update(Transaction transaction);
	public Transaction findByNo(String no);
	public List<Transaction> findAll();
	public List<Transaction> findAllTransactionsByAccount(Account account);
	public List<Transaction> findTransactionsOutByAccount(Account account);
	public List<Transaction> findTransactionsInByAccount(Account account);
}
