import java.util.ArrayList;

class Client extends Person implements Information {
    public static int gl_cart_id = 0;
    int cart_id;
    Cart cart;
    ArrayList<Order> orders = new ArrayList<>();
    public Client(String fullName, String Address, String telephone,Cart cart) {
        super(fullName, Address, telephone);
        this.cart_id = gl_cart_id;
        this.cart=cart;

        gl_cart_id++;
    }

    Order createOrder() {
        Order order = new Order (this.cart);
        orders.add(order);
        for (int i=0;i<orders.size();i++){
            System.out.println(orders.get(i).orderId);
        }
        return order;
    }

    public void showInfo() {

    }
}
