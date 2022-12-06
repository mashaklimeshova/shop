import java.util.ArrayList;
import java.util.Random;
//Валявская
class Order {
    private int hash=137;
    Random rand = new Random();
    int orderId, clientId;
    Cart cart;
    public Order(Cart cart, int clientId) {
        this.cart=cart;
        this.clientId=clientId;
        orderId = hashCode()+rand.nextInt(100);

    }
    @Override
    public int hashCode() {
        return (clientId+1) * cart.hashCode() + hash;
    }
}