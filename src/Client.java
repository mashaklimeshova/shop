import java.util.ArrayList;

class Client extends Person implements Information {

    Cart cart;
    ArrayList<Order> orders = new ArrayList<>();
    public Client(String fullName, String Address, String telephone,Cart cart) {
        super(fullName, Address, telephone);
        this.cart=cart;
        
    }

    Order createOrder(ArrayList<Product> availableProducts) {
        Order order = new Order (this.cart);
        orders.add(order);
        System.out.println("Your order number is " + orders.get(orders.size()-1).orderId);
        for (int i=0;i<availableProducts.size();i++){
            for (int j=0;j<this.cart.products.size();j++){
                if (this.cart.products.get(j).product.product_id==availableProducts.get(i).product_id){
                        availableProducts.get(i).amount=availableProducts.get(i).amount-this.cart.products.get(j).amount;
                }
            }
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
