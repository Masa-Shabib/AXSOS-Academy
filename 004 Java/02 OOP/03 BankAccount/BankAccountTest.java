public class BankAccountTest {
    
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.deposit(200.5,"savings");
        account1.withdraw(100,"savings");
        account1.withdraw(200,"savings");
        System.out.println("Account Number : "+account1.getAccountNumber());
        System.out.println("Total Balance : "+account1.getTotalAmountOfMoney());
        System.out.println("Saving Balance : "+account1.getSavingsBalance());
        System.out.println("Chicking Balance : "+account1.getCheckingBalance());
        System.out.println("Number of created accountes: "+account2.getNumberOfAccounts());
    }
}
