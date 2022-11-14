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
    public int i;

    int cart_id;

    public Client(int id, String fullName, String Address, String telephone) {
        super(id, fullName, Address, telephone);
        this.cart_id=i;
        i++;
    }
}
class Cart{


    Client client;
    public Cart(Client client) {
        this.client=client;

    }
    void print(){
        System.out.println(client.cart_id);
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
