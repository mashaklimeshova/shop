class Owner extends Person {
    String shop_name;

    public Owner(String fullName, String Address, String telephone, String shop_name) {
        super(fullName, Address, telephone);
        this.shop_name = shop_name;
    }
}
