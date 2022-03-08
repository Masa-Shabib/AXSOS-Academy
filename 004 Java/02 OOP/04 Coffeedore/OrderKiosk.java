import java.util.ArrayList;
class OrderKiosk {
    private ArrayList<Items> menu = new ArrayList<Items>();
    private ArrayList<Orders> orders = new ArrayList<Orders>();

    public OrderKiosk (){
    }
    public void addMenuItem(String name, double price) {
        Items newItem = new Items(name, price);
        menu.add(newItem);
        newItem.setIndex(menu.size()-1);
        }
    public void displayMenu() {
        for (int i=0 ;i < this.menu.size(); i++){
            Items item1 = this.menu.get(i); 
            System.out.println(item1.getIndex() + " " + item1.getName()+ " -- $" + item1.getPrice());
        }
    }
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Orders newOrder = new Orders();
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            for (Items item : menu ){
                if (Integer.parseInt(itemNumber)== item.getIndex()){
                    newOrder.addItem(item);
                }
            }
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their inputcopy
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        newOrder.display();
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        
    }
}
