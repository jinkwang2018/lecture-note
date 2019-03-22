package Bank;

import java.util.Calendar;

public class Transaction {
	Calendar date = Calendar.getInstance();
	String transactionDate;
	String transactionTime;
	String Kind;
	long amount;
	long balance;
	public Transaction(String kind, long amount, long balance) {
		this.transactionDate = date.get(Calendar.YEAR) + "-" +
                (date.get(Calendar.MONTH)+1) + "-" +
                date.get(Calendar.DATE);
		this.transactionTime = date.get(Calendar.HOUR) + ":" + 
                date.get(Calendar.MINUTE) + ":" + 
                date.get(Calendar.SECOND);
		this.Kind = kind;
		this.amount = amount;
		this.balance = balance;
	}
	@Override
	public String toString() {
        return "Transaction [tsDate=" + transactionDate + ", tsTime=" + transactionTime + ", kind=" + Kind
                + ", amount=" + amount + ", balance=" + balance + "]";
    }
	
	
	
}
