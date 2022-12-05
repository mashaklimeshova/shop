import java.util.ArrayList;
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
    public Object clone() throws CloneNotSupportedException {
        Product product = (Product) super.clone();
        return product;
    }
}
