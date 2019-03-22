package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
	String accountNo; //���¹�ȣ
	String name; //�����ڸ�
	long balance; //�ܰ�
	List<Transaction> list; //�ŷ�����
	
	public Account(String accountNo, String name) {
		this.accountNo  = accountNo;
		this.name = name;
		this.balance = 0;
		this.list = new ArrayList<>();
				
	}
	public void deposit(long amount) { //�Ա�
		this.balance += amount;
		list.add(new Transaction("�Ա�",amount, balance));
		
		
	}
	public void withdraw(long amount) { //���
		this.balance -= amount;
		list.add(new Transaction("���",amount, balance));
		
	}
	public long getBalance() { //�ܰ�Ȯ��
		return balance;
	
	}
	public List<Transaction> Transactions() { //�ŷ�����Ȯ��
		return list;
	
	}
	@Override
	public String toString() {
		return  name + "Account {accountNo=" + accountNo + ", balance=" + balance + ", list=" + list
                + "}\n";
	}
	
}
