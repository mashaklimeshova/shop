import java.util.Random;
//Валявская
class Order {
    Random rand = new Random();
    int orderId;
    Cart cart;
    public Order(Cart cart) {
        this.cart=cart;
        orderId= rand.nextInt(1000)+rand.nextInt(100);

    }

}
