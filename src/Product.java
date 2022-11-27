class Product {
    String name;
    String type;
    int price,amount;
    public static int i = 0;
    int product_id;

    public Product(String name, String type, int price,int amount) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount=amount;
        product_id=i;
        i++;
    }
}
