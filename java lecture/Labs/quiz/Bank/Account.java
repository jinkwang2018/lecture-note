package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
	String accountNo; //계좌번호
	String name; //소유자명
	long balance; //잔고
	List<Transaction> list; //거래내역
	
	public Account(String accountNo, String name) {
		this.accountNo  = accountNo;
		this.name = name;
		this.balance = 0;
		this.list = new ArrayList<>();
				
	}
	public void deposit(long amount) { //입금
		this.balance += amount;
		list.add(new Transaction("입금",amount, balance));
		
		
	}
	public void withdraw(long amount) { //출금
		this.balance -= amount;
		list.add(new Transaction("출금",amount, balance));
		
	}
	public long getBalance() { //잔고확인
		return balance;
	
	}
	public List<Transaction> Transactions() { //거래내역확인
		return list;
	
	}
	@Override
	public String toString() {
		return  name + "Account {accountNo=" + accountNo + ", balance=" + balance + ", list=" + list
                + "}\n";
	}
	
}
