class Cart {


    Client client;
    public static int global_i=0;
    public int i;

    Products[] products = new Products[100];


    public Cart(Client client) {
        this.client = client;

    }
    void addProduct(Product product, int amount){
        i=global_i;
        products[i]= new Products(product,amount);
        global_i++;

    }

    void clearCart(Client client) {


    }

    void deleteItem(Client client) {

    }

    void createOrder() {

    }
    void showProducts(){
        for (int j=0;j<global_i;j++){
            System.out.println(products[j].product.name + " " + products[j].amount);
        }

    }
}
