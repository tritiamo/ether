package edu.mum.cs525.framework.Command;

import edu.mum.cs525.framework.AccountService;

public class DepositCommand extends AbstractAccountCommand {

	private String accountNumber;
	private double ammount;
	
	public DepositCommand(AccountService serviceA, String accountNumber, double ammount) {
		super(serviceA);
		this.accountNumber = accountNumber;
		this.ammount = ammount;
	}

	@Override
	public void execute() {
		serviceA.deposit(accountNumber, ammount);
	}
}
