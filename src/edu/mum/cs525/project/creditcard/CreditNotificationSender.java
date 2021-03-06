package edu.mum.cs525.project.creditcard;

import edu.mum.cs525.framework.Account;
import edu.mum.cs525.framework.BusinessCustomer;
import edu.mum.cs525.framework.PersonalCustomer;
import edu.mum.cs525.framework.Transaction;
import edu.mum.cs525.framework.Command.CommandsManager;
import edu.mum.cs525.framework.Command.EmailManagerCommand;

public class CreditNotificationSender {
	
	private void sendEmail(String emailAddress, String message) {
		String emailMessage = "Sending email to: " + emailAddress + "\n" + "Message: " + message;
		EmailManagerCommand emc = new EmailManagerCommand(emailMessage);
	    CommandsManager.getInstance().setCommand(emc);
	    CommandsManager.getInstance().invokeCommand();
	}
	
	//personal account notification
	public void onOverdraft(Account acc, PersonalCustomer pc, Transaction tx){
		sendEmail(pc.getEmail(), "Exceed credit limit! A purchase of $" + Math.abs(tx.getAmount()) +
				" was attempted from account " + acc.getAccountNumber() + " on " + tx.getDate());
	}	

	public void onDeposit(Account acc, PersonalCustomer pc, Transaction tx) {
		if (tx.getAmount() > 400) {
			sendEmail(pc.getEmail(), "Account: " + acc.getAccountNumber() + " deposit: " + -tx.getAmount());
		}
	}
	
	public void onWithdraw(Account acc, PersonalCustomer pc, Transaction tx) {
		if (tx.getAmount() > 400) {
			sendEmail(pc.getEmail(), "Account: " + acc.getAccountNumber() + " withdraw: " + -tx.getAmount());
		}
	}
	
	//business account notification
	public void onDeposit(Account acc, BusinessCustomer bc, Transaction tx) {
		sendEmail(bc.getEmail(), "Account: " + acc.getAccountNumber() + " deposit: " + -tx.getAmount());
	}
	
	public void onWithdraw(Account acc, BusinessCustomer bc, Transaction tx) {
		sendEmail(bc.getEmail(), "Account: " + acc.getAccountNumber() + " withdraw: " + -tx.getAmount());
	}
	
}
