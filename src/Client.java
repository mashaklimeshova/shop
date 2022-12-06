import java.util.ArrayList;

class Client extends Person implements Information,Statistic {
    Cart cart;
    int clientId;
    ArrayList<Order> orders = new ArrayList<>();
    public Client(int clientId, String fullName, String Address, String telephone,Cart cart) {
        super(fullName, Address, telephone);
        this.cart=cart;
        this.clientId=clientId;

    }
    //Климешова
    public void createOrder(Shop shop) throws CloneNotSupportedException {
        Order order = new Order ((Cart) this.cart.clone(),this.clientId);
        orders.add(order);
        System.out.println("Your order number is " + orders.get(orders.size()-1).orderId + " ");
        shop.addOrder(order);
    }
    //Валявская
    public void showInfo() {
        if (orders.size() == 0) {
            System.out.println("You don't have any orders");
        } else if (orders.size() == 1) {
            System.out.println("\nOrder of " + this.fullName + " is:");
            System.out.println("№" + orders.get(0).orderId);
            orders.get(0).cart.showProducts();
        } else {
            System.out.println("\nOrders of " + this.fullName + " are:");
            for (Order order : orders) {
                System.out.println("№" + order.orderId);
                order.cart.showProducts();
            }

        }
    }
    public boolean equals(Client client) {
        return client.fullName.equalsIgnoreCase(this.fullName) && client.telephone.equalsIgnoreCase(this.telephone) && client.Address.equalsIgnoreCase(this.Address);
    }

    @Override
    public void stats() {
        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.cart.getSum();
        }
        System.out.println("\n-----------------------");
        System.out.println("Average check is " + sum/orders.size());
        System.out.println("-----------------------\n");
    }
}
