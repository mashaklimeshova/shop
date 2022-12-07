import java.util.Random;
//Валявская
class Order {
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
        int hash = 137;
        return (clientId+1) * cart.hashCode() + hash;
    }
}