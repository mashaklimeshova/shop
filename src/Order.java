class Order implements Statistic {
    int cart_id;
    public Order(Client client) {
        this.cart_id=client.cart_id;

    }

    public void stats() {

    }
}
