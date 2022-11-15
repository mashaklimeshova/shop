class Product {
    String name;
    String type;
    int price, amount;
    public static int i = 0;
    int product_id;

    public Product(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
        product_id=i;
        i++;
    }
}
