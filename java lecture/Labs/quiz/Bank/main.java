package Bank;

public class main {

	public static void main(String[] args) {
		Bank bank = new Bank();
        System.out.println(bank.getAccounts());
        bank.addAccount("1001", "���¿�");
        bank.addAccount("1002", "������");
        bank.addAccount("1003", "���ֿ�");
        bank.addAccount("1004", "�̾Ƹ�");
        bank.addAccount("1005", "���¿�");
        System.out.println(bank.getAccounts());
        
        System.out.println("��ȣ�� ã��" + (bank.getAccount("1001")));
        System.out.println("�̸����� ã��" + (bank.fineAccounts("���¿�")));
        
        while(true) {
            bank.transactionSystem(bank.getAccount("1001").get(0));
        }
    

	}

}
