import java.util.ArrayList;

class Client extends Person implements Information {

    Cart cart;
    ArrayList<Order> orders = new ArrayList<>();
    public Client(String fullName, String Address, String telephone,Cart cart) {
        super(fullName, Address, telephone);
        this.cart=cart;

    }

    Order createOrder() {
        Order order = new Order (this.cart);
        orders.add(order);
        System.out.println("Your order number is " + orders.get(orders.size()-1).orderId);
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
            for (Order order : orders) {
                System.out.println(order.orderId);
            }

        }
    }
    public boolean equals(Client client) {
        return client.fullName.equalsIgnoreCase(this.fullName) && client.telephone.equalsIgnoreCase(this.telephone) && client.Address.equalsIgnoreCase(this.Address);
    }
}
