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

    int cart_id;

    public Client(int id, String fullName, String Address, String telephone, int cart_id) {
        super(id, fullName, Address, telephone);
        this.cart_id=cart_id;
    }
}



public class main {
    public static void main(String[] args) {
        System.out.println("helloworld");
    }
}
