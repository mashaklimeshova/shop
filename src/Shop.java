import java.lang.reflect.Array;
import java.util.ArrayList;

class Shop implements Information,Statistic {
    String name;
    String Address;

    ArrayList<Order> madeOrders = new ArrayList<Order>();

    public Shop(String name, String Address) {
        this.name = name;
        this.Address = Address;

    }
    public void addOrder(Order order){
        madeOrders.add(order);
    }

    public void showInfo() {

    }
    public void stats() {

    }
}
