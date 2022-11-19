public class main {
    public static void main(String[] args) {
        Client bob = new Client("dffd","fgfg","54964");
        Product product = new Product("Apple","food",100);
        Product product1 = new Product("Cheese","food",1000);
        Product product2 = new Product("Banana","food",50);
        Cart cart = new Cart(bob);

        cart.addProduct(product,3);
        cart.addProduct(product1,2);
        cart.addProduct(product2,1);

        cart.showProducts();





    }
}
