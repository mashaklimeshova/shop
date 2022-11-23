import java.util.Random;

class Order implements Statistic {
    int cart_id;
    Random rand = new Random();
    public static int i = 49;
    int orderId;
    Cart cart;
    public Order(Cart cart) {
        this.cart=cart;
        orderId=i;
        i++;

    }

    public void stats() {

    }
}
