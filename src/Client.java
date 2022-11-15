class Client extends Person implements Information {
    public static int gl_cart_id = 0;
    int cart_id;

    public Client(String fullName, String Address, String telephone) {
        super(fullName, Address, telephone);
        this.cart_id = gl_cart_id;
        gl_cart_id++;
    }

    public void showInfo() {

    }
}
