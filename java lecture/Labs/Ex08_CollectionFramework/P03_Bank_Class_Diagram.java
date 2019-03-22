import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
�ó�����
������ ���¸� �����Ѵ�.
������ ���¸� ����Ѵ�.
������ ���¹�ȣ�� ���¸� ã�� �� �ִ�.
������ ������ �����ڸ����� ���¸� ã�� �� �ִ�.
������ ��� ������ ����� �� �� �ִ�.
���´� �����ڸ�, ���¹�ȣ, �ܰ�� �����ȴ�.
���´� �Ա�,��� ��ɰ� �ܰ�Ȯ�� ����� �ִ�.
���¿��� �ܾ��� ��ȭ�� ���� ������ ����� ���� ��ϵȴ�.
����� ���� �ŷ�����, �ŷ��ð�, �Ա�/���, �ݾ�, �ܾ����� �����ȴ�.
 */
class Bank {
	private Map<Integer, Account> accounts;
	private int totalAccount;
	int index = -1;
	
	Bank() {
		accounts = new HashMap<>(); //Default Constructor���� ��ü �������� �ʱ�ȭ ���ִ� ���� ��ü���⿡�� �Ǵ�.
	}
	
	public void addAccount(String accountNo, String name) {
		accounts.put(++index, new Account(accountNo, name));
	}
	
	public void print() {
		System.out.println(accounts.get(0));
	}
	
	public Account getAccount(String accountNo) {
		Account result = null;
		for(int i = 0; i < accounts.size(); i++) {
			if(accountNo.equals(accounts.get(i).getAccountNo())) {
				result = accounts.get(i);
			}
		}
		return result;
	}
	public List findAccounts(String name) {
		List list = new ArrayList();
		
		for(int i = 0; i < accounts.size(); i++) {
			if(name.equals(accounts.get(i).getName())) {
				list.add(accounts.get(i));
			}
		}
		
		return list;
	}
	public List getAccounts() {
		List list = new ArrayList();
		
		for(int i = 0; i < accounts.size(); i++) {
			list.add(accounts.get(i));
		}
		return list;
	}
	public int getTotalAccount() {
		return accounts.size();
	}
}

class Account {
	private String accountNo;
	private String name;
	private long balance;
	private List<Transaction> transactions;
	private Calendar cal = Calendar.getInstance();
	
	Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0;
		this.transactions = new ArrayList<>(); //Constructor���� ��ü �������� �ʱ�ȭ ���ִ� ���� ��ü���⿡�� �Ǵ�.
	}
	
	//���´� �����ڸ�, ���¹�ȣ, �ܰ�� �����ȴ�.
	@Override
	public String toString() {
		return "�������� [���¹�ȣ=" + accountNo + ", �����ڸ�=" + name + ", �ܰ�=" + balance + "]";
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void deposit(long amount) {
		this.balance += amount;
		String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE);
        String time = cal.get(Calendar.HOUR) + "-" + cal.get(Calendar.MINUTE) + "-" + cal.get(Calendar.SECOND);
        transactions.add(new Transaction(date, time, "�Ա�", amount, this.balance));
        System.out.println(this.name + "�� " + amount + "�� �Ա�!"); 
	}
	public void withdraw(long amount) {
		if(this.balance >= amount) {
            this.balance -= amount;
            String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE);
            String time = cal.get(Calendar.HOUR) + "-" + cal.get(Calendar.MINUTE) + "-" + cal.get(Calendar.SECOND);
            transactions.add(new Transaction(date, time, "���", amount, this.balance));
            System.out.println(this.name + "�� " + amount + "�� ���!");
        }else {
            System.out.println("�ܾ��� �����մϴ�.");
            System.out.println("���� �ܾ�: " + getBalance());
        }
	}
	public long getBalance() {
		return this.balance;
	}
	public List<Transaction> getTransactions() {
		return this.transactions;
	}
}

class Transaction {
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	private long balance;
	
	public Transaction(String transactionDate, String transactionTime, String kind, long amount, long balance) {
        super();
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }
	
	public void print() {
		
	}
 
    @Override
    public String toString() {
        return "����� �� [�ŷ�����=" + transactionDate + ", �ŷ��ð�=" + transactionTime + ", �Ա�/���="
                + kind + ", �ݾ�=" + amount + ", �ܾ�=" + balance + "]";
    }
}

public class P03_Bank_Class_Diagram {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addAccount("100", "ȫ�浿");
		bank.addAccount("200", "ȣ�ý�");
		bank.addAccount("300", "Ű��Ĺ");
		bank.print();
		System.out.println(bank.getAccount("100").toString());
		Iterator find = bank.findAccounts("ȣ�ý�").iterator();
		while(find.hasNext()) {
			System.out.println(find.next());
		}
		
		Iterator total = bank.getAccounts().iterator();
		while(total.hasNext()) {
			System.out.println(total.next());
		}
		System.out.println("�� ���� ��: " + bank.getTotalAccount());
		
		bank.getAccount("100").deposit(13000);
		bank.getAccount("100").withdraw(5000);
		System.out.println("�ܾ�: " + bank.getAccount("100").getBalance() + "��");
		
		Iterator ts = bank.getAccount("100").getTransactions().iterator();
		while(ts.hasNext()) {
			System.out.println(ts.next());
		}
		System.out.println(bank.getAccount("100").toString());
	}
}
