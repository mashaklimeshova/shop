//Климешова
class Product implements Cloneable {
    String name;
    String type;
    int price,amount;
    int product_id;

    public Product(int product_id, String name, String type, int price,int amount) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
        this.product_id=product_id;
    }
    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
    @Override
    public int hashCode() {
        return name.length()+(amount%3);
    }
}
