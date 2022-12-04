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

        if (orders.size() == 0) {
            System.out.println("You don't have any orders");
        } else if (orders.size() == 1) {
            System.out.println("Order of " + this.fullName + " is:");
            System.out.println(orders.get(0).orderId);
        } else {
            System.out.println("Orders of " + this.fullName + " are:");
            for (int i = 0; i < orders.size(); i++) {
                System.out.println(orders.get(i).orderId);
            }

        }
    }
    public boolean equals(Client client) {
        if (client.fullName.equalsIgnoreCase(this.fullName)&&client.telephone.equalsIgnoreCase(this.telephone)&&client.Address.equalsIgnoreCase(this.Address))  return true;
        else return false;
    }
}
