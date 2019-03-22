package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Bank {
	private int totalAccount;
	List<Account> list;

	
	public Bank() {
		list = new ArrayList<>();
		totalAccount = list.size();
	}
	

	public void addAccount(String accountNo, String name) {
		list.add(new Account(accountNo, name));
		totalAccount++;
	}

	public List<Account> getAccount(String accountNo) {
		Iterator<Account> li = list.iterator();
		List<Account> result = new ArrayList<>();
		while (li.hasNext()) {
			Account temp = li.next();
			if (temp.accountNo.equals(accountNo)) {
				result.add(temp);
			}

		}

		return result;
	}

	public List<Account> fineAccounts(String name) {
		Iterator<Account> li = list.iterator();
		List<Account> result = new ArrayList<>();
		while (li.hasNext()) {
			Account temp = li.next();
			if (temp.name.equals(name)) {
				result.add(temp);
			}

		}

		return result;
	}

	public List<Account> getAccounts() {// 계좌목록조회
		return list;
	}

	public int getTotalAccount() {
		return totalAccount;
	}

	public void transactionSystem(Account who) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.입금\t2.출금\t3.잔고\t4.거래내역");
		String input = sc.nextLine();
		switch (input) {
		case "1":
			System.out.print("입금 금액: ");
			long amount = Long.parseLong(sc.nextLine());
			who.deposit(amount);
			break;
		case "2":
			System.out.print("출금 금액: ");
			long amount2 = Long.parseLong(sc.nextLine());
			who.withdraw(amount2);
			break;
		case "3":
			System.out.println("잔액: " + who.getBalance());
			break;
		case "4":
			System.out.println("거래내역: " + who.Transactions());
			break;
		default:
			break;
		}
	}
}
