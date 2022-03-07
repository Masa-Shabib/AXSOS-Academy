class Items {
    private double price;
    private String name;

    public Items(double price,String name){
        this.name = name;
        this.price = price;
    }
    // getter
    public double getPrice() {
    return price;
    }
    // setter
    public void setPrice(Double number) {
    price = number;
    }
    // getter
    public String getName() {
    return name;
    }
    // setter
    public void setName(String name) {
    this.name = name; 
    }

}
