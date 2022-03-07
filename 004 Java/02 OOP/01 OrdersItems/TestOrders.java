public class TestOrders {
    public static void main(String[] args) {
        // Menu items
        Items item1 = new Items();
        item1.name ="Latte";
        item1.price =3.2;
        Items item2 = new Items();
        item2.name ="mocha";
        item2.price =4.5;
        Items item3 = new Items();
        item3.name ="drip coffee";
        item3.price =6.5;
        Items item4 = new Items();
        item4.name ="capuccino";
        item4.price =5.0;
        // Order variables -- order1, order2 etc.
        Orders order1 = new Orders();
        order1.name= "Cindhuri";
        order1.ready = true;
        Orders order2 = new Orders();
        order2.name= "Jimmy";
        order2.items.add(item1);
        order2.total += item1.price;
        Orders order3 = new Orders();
        order3.name= "Noah";
        order3.items.add(item4);
        order3.total += item4.price;
        Orders order4 = new Orders();
        order4.name= "Sam";
        order4.items.add(item1);
        order4.total += item1.price;
        order4.items.add(item1);
        order4.total += item1.price;
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        System.out.printf("Items: %s\n", order2.items.get(0).name);
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        System.out.printf("Items: %s\n", order3.items.get(0).name);
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        System.out.printf("Items: %s\n", order4.items.get(0).name);
        }
}
