import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
시나리오
은행은 계좌를 관리한다.
은행은 계좌를 등록한다.
은행은 계좌번호로 계좌를 찾을 수 있다.
은행은 계좌의 소유자명으로 계좌를 찾을 수 있다.
은행은 모든 계좌의 목록을 볼 수 있다.
계좌는 소유자명, 계좌번호, 잔고로 구성된다.
계좌는 입금,출금 기능과 잔고확인 기능이 있다.
계좌에서 잔액의 변화가 있을 때마다 입출금 명세에 기록된다.
입출금 명세는 거래일자, 거래시간, 입금/출금, 금액, 잔액으로 구성된다.
 */
class Bank {
	private Map<Integer, Account> accounts;
	private int totalAccount;
	int index = -1;
	
	Bank() {
		accounts = new HashMap<>(); //Default Constructor에서 객체 생성으로 초기화 해주는 것이 객체지향에서 옳다.
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
		this.transactions = new ArrayList<>(); //Constructor에서 객체 생성으로 초기화 해주는 것이 객체지향에서 옳다.
	}
	
	//계좌는 소유자명, 계좌번호, 잔고로 구성된다.
	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accountNo + ", 소유자명=" + name + ", 잔고=" + balance + "]";
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
        transactions.add(new Transaction(date, time, "입금", amount, this.balance));
        System.out.println(this.name + "님 " + amount + "원 입금!"); 
	}
	public void withdraw(long amount) {
		if(this.balance >= amount) {
            this.balance -= amount;
            String date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE);
            String time = cal.get(Calendar.HOUR) + "-" + cal.get(Calendar.MINUTE) + "-" + cal.get(Calendar.SECOND);
            transactions.add(new Transaction(date, time, "출금", amount, this.balance));
            System.out.println(this.name + "님 " + amount + "원 출금!");
        }else {
            System.out.println("잔액이 부족합니다.");
            System.out.println("현재 잔액: " + getBalance());
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
        return "입출금 명세 [거래일자=" + transactionDate + ", 거래시간=" + transactionTime + ", 입금/출금="
                + kind + ", 금액=" + amount + ", 잔액=" + balance + "]";
    }
}

public class P03_Bank_Class_Diagram {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addAccount("100", "홍길동");
		bank.addAccount("200", "호올스");
		bank.addAccount("300", "키이캣");
		bank.print();
		System.out.println(bank.getAccount("100").toString());
		Iterator find = bank.findAccounts("호올스").iterator();
		while(find.hasNext()) {
			System.out.println(find.next());
		}
		
		Iterator total = bank.getAccounts().iterator();
		while(total.hasNext()) {
			System.out.println(total.next());
		}
		System.out.println("총 계좌 수: " + bank.getTotalAccount());
		
		bank.getAccount("100").deposit(13000);
		bank.getAccount("100").withdraw(5000);
		System.out.println("잔액: " + bank.getAccount("100").getBalance() + "원");
		
		Iterator ts = bank.getAccount("100").getTransactions().iterator();
		while(ts.hasNext()) {
			System.out.println(ts.next());
		}
		System.out.println(bank.getAccount("100").toString());
	}
}
