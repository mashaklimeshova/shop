import java.util.ArrayList;

class Shop implements Information,Statistic {
    String name;
    String Address;
    Owner owner;

    ArrayList<Order> madeOrders = new ArrayList<>();

    public Shop(String name, String Address, Owner owner) {
        this.name = name;
        this.Address = Address;
        this.owner=owner;

    }
    public void addOrder(Order order){
        madeOrders.add(order);
    }

    public void showInfo() {
        System.out.println("Name:" + this.name);
        System.out.println("Address:" + this.Address);
        System.out.println("Owner is " + this.owner.fullName + " and their telephone is " + this.owner.telephone);


    }
    public void stats() {

    }
}
