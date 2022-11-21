class Order implements Statistic {
    int cart_id;
    public static int i = 49;
    int orderId;
    public Order(Client client) {
        this.cart_id=client.cart_id;
        orderId=i;
        i++;

    }

    public void stats() {

    }
}
