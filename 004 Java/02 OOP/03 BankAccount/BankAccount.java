
import java.util.Random;
class BankAccount {
    private double checkingBalance;
    private double savingsBalance; 
    private String accountNumber; 
    private static int numberOfAccounts = 0;
    private static double totalAmountOfMoney = 0;
    
    public BankAccount(){
        accountNumber = createAccountNumber();
        numberOfAccounts+=1;
    }
    public int getNumberOfAccounts() {
        return numberOfAccounts;
        }
    public double getTotalAmountOfMoney() {
        return totalAmountOfMoney;
        }
    public void deposit(double money , String type) {
        if (type == "savings"){
            this.savingsBalance += money;
        }
        else{
            this.checkingBalance += money;
        }
        totalAmountOfMoney+= money;
        }
    public void withdraw(double money , String type) {
        if (totalAmountOfMoney < money){
            System.out.println("Not enough money");
        }
        else{
            if (type == "savings"){
                this.savingsBalance -= money;
            }
            else{
                this.checkingBalance -= money;
            }
            totalAmountOfMoney-= money;
        }
        }
    private  String createAccountNumber(){
        Random randMachine =  new Random();
        String random ="";
        for (int i=0 ;i < 10; i++){
            int x = randMachine.nextInt(10 - 1) + 1;
            random += String.valueOf(x) ;
        }
    return random;
    }
    public double getCheckingBalance() {
        return checkingBalance;
        }
    public double getSavingsBalance() {
        return savingsBalance;
        }
    public String getAccountNumber() {
        return accountNumber;
        }

}
