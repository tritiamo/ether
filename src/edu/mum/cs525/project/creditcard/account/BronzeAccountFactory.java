package edu.mum.cs525.project.creditcard.account;

import edu.mum.cs525.framework.CreditLimit;
import edu.mum.cs525.framework.Interestable;

public class BronzeAccountFactory extends CreditAccountFactory {

	@Override
	public Interestable createInterestCalculator() {
		return new BronzeInterest();
	}

	@Override
	public CreditLimit createCreditLimit() {
		return new BronzeCreditLimit();
	}
	
	@Override
	public String getType() {
		return "BRONZE";
	}

}
