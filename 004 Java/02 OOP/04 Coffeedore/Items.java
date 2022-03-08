class Items {
    private double price;
    private String name;
    private int index;

    public Items(String name,double price){
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
    public int getIndex() {
        return this.index;
    }

    public void setIndex(int newIndex) {
        index = newIndex;
    } 

}
