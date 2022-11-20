class Owner extends Person {
    Shop shop;

    public Owner(String fullName, String Address, String telephone,Shop shop) {
        super(fullName, Address, telephone);
        this.shop = shop;
    }
}
