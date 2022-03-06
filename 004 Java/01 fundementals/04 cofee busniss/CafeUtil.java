import java.util.ArrayList;

public class CafeUtil {

    public  int getStreakGoal() {
        int sum = 0;
    for (int i=1 ;i < 11; i++){
        sum +=i;
    }
       return sum;
   }

    public  double getOrderTotal(double[] prices){
        double sum = 0;
    for (int i=0 ;i < prices.length; i++){
        sum += prices[i];
    }
    return sum;
    }

    public  void displayMenu(ArrayList<String> menuItems){
    for (int i=0 ;i < menuItems.size(); i++){
        String name = menuItems.get( i ); 
        System.out.println(i+ " " + name);
    }
    }

    public void addCustomer(ArrayList<String> customers){
        String userName =  System .console().readLine();
        customers.add(userName);
        String name = customers.get(customers.size()-1);
        System.out.println("Hello, " + name + "! There are "+ (customers.size()-1) + " in front of you");
        System.out.println(customers);
    }
}
