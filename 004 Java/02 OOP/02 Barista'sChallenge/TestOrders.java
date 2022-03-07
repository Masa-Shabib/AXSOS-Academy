public class TestOrders {
    public static void main(String[] args) {
        // Menu items
        Items item1 = new Items(3.2,"Latte" );
        Items item2 = new Items(4.5,"mocha");
        Items item3 = new Items(6.5,"drip coffee");
        Items item4 = new Items(5.0,"capuccino");

        // Order variables -- order1, order2 etc.
        Orders order1 = new Orders();
        order1.addItem(item4);
        order1.setReady(true);
        Orders order2 = new Orders();
        order2.addItem(item2);
        Orders order3 = new Orders("Cindhuri");
        order3.addItem(item1);
        order3.addItem(item2);
        Orders order4 = new Orders("Jimmy");
        Orders order5 = new Orders("Noah");


        order1.display();
        order1.getStatusMessage();
        order1.getOrderTotal();
        }
}
