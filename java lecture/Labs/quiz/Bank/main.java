package Bank;

public class main {

	public static void main(String[] args) {
		Bank bank = new Bank();
        System.out.println(bank.getAccounts());
        bank.addAccount("1001", "±èÅÂ¿õ");
        bank.addAccount("1002", "¾ÆÀ±±Ù");
        bank.addAccount("1003", "¹ÚÁÖ¿ø");
        bank.addAccount("1004", "ÀÌ¾Æ¸²");
        bank.addAccount("1005", "±èÅÂ¿õ");
        System.out.println(bank.getAccounts());
        
        System.out.println("¹øÈ£·Î Ã£±â" + (bank.getAccount("1001")));
        System.out.println("ÀÌ¸§À¸·Î Ã£±â" + (bank.fineAccounts("±èÅÂ¿õ")));
        
        while(true) {
            bank.transactionSystem(bank.getAccount("1001").get(0));
        }
    

	}

}
