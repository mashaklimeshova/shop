import java.util.Random;

class Order implements Statistic {
    int cart_id;
    Random rand = new Random();
    int orderId;
    Cart cart;
    public Order(Cart cart) {
        this.cart=cart;
        orderId= rand.nextInt(1000)+rand.nextInt(100);

    }

    public void stats() {

    }
}
