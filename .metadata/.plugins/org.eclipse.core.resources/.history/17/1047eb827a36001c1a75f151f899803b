package yob.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import yob.controller.TransactionContainer;
import yob.repository.AccountRepository;
import yob.repository.TransactionRepository;
import yob.repository.UserRepository;
import yob.repository.entities.Account;
import yob.repository.entities.Transaction;
import yob.util.FacesContextUtils;


@Named("transactionMbean")
@RequestScoped
public class TransactionMbean {
	@EJB
	TransactionRepository transactionRepository;
	@EJB
	UserRepository userRepository;
	@EJB
	AccountRepository accountRepository;
	
	private Transaction convertTransactionToEntity(TransactionContainer t) {
		Transaction transaction = new Transaction(); //entity
		String transactionNo = t.getTransactionNo();
		double amount = t.getAmount();
		List<String> types = t.getTypes();
		Account payerAccount = accountRepository.findByNo(t.getFromAccountNo());
		Account payeeAccount = accountRepository.findByNo(t.getTargetAccountNo());
		transaction.setTransactionNo(transactionNo);
		transaction.setAmount(amount);
		transaction.setTypes(types);
		transaction.setUserAccount(payeeAccount);
		transaction.setTargetAccount(payerAccount);
		transaction.setTransactionName(t.getTransactionName());

		return transaction;
	}

	public void addTransaction(TransactionContainer t) throws Exception {
		Transaction transaction = convertTransactionToEntity(t);
		transactionRepository.add(transaction);
	}
	public List<Transaction> getAllTransactions() throws Exception{
		return transactionRepository.findAll();
	}
	public Transaction getTransactionByNo(String no) throws Exception{
		return transactionRepository.findByNo(no);
	}

	public void removeTransactionByNo(String no) throws Exception{
		transactionRepository.del(no);
	}
	public void editTransaction(Transaction t) throws Exception{
		transactionRepository.update(t);
		FacesContextUtils.showMessage("Successfully edited");
	}
}