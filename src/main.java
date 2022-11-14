import java.util.Random;

class Shop{
    String name;
    String Address;
    Person owner;
    public Shop(String name, String Address, Person owner) {
        this.name=name;
        this.Address=Address;
        this.owner=owner;

    }
}

class Client extends Person{


    public Client(int id, String fullName, String Address, String telephone) {
        super(id, fullName, Address, telephone);
    }
}
class Cart{

    Random rand = new Random();
    int cart_id=rand.nextInt(200);

    Client client;
    public Cart(Client client) {
        this.client=client;

    }
    void print(){
        System.out.println(cart_id);
    }
}



public class main {
    public static void main(String[] args) {
        Client bob = new Client(1,"dffd","fgfg","54964");
        Cart cart = new Cart(bob);
        Cart cart2 = new Cart(bob);
        Cart cart1 = new Cart(bob);
        cart.print();
        cart1.print();
        cart2.print();


    }
}
