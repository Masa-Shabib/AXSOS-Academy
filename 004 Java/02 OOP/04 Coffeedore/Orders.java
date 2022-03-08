import java.util.ArrayList;
class Orders {
    private String name;
    private boolean isReady ;
    private ArrayList<Items> items = new ArrayList<Items>();

    public Orders (){
        this.name = "Guest";
        this.items = new ArrayList<>();
    }
    public Orders (String name){
        this.name = name;
    }
    public void addItem(Items item) {
        items.add(item); 
        }
    public void getStatusMessage() {
        if (this.isReady) {
            System.out.println("Your order is ready"); 
        }
        else{
            System.out.println("Thank you for waiting. Your order will be ready soon."); 
        }
        }
    public void display() {
        System.out.println("Customer name: "+this.name);
        double total = 0;
        for (int i=0 ;i < this.items.size(); i++){
            Items order1 = this.items.get(i); 
            total+=order1.getPrice();
            System.out.println(order1.getName() + " - $" + order1.getPrice());
        }
        System.out.println("Total: $"+total);
        }
        public void getOrderTotal() {
            double total = 0;
            for (int i=0 ;i < this.items.size(); i++){
                Items order1 = this.items.get(i); 
                total+=order1.getPrice();
            }
            System.out.println("Total: $"+total);
            }
    // getter
    public String getName() {
    return name;
    }
    // setter
    public void setName(String name) {
    this.name = name; 
    }
    // // getter
    // public Items getItems() {
    //     return items;
    //     }
    //     // setter
    //     public void setItems(Items item) {
    //     items.add(item);
    //     }
    // getter
    public Boolean getReady() {
    return isReady;
    }
    // setter
    public void setReady() {
    this.isReady = true; 
    }
    
}
