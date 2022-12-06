import java.util.ArrayList;

class Shop implements Information,Statistic {
    static String name = "Шестерочка";
    static String Address = "Moscow";
    static Owner owner = new Owner ("Ivanov Ivan Ivanovich", "Moscow", "89451234567");
    ArrayList<Order> madeOrders = new ArrayList<>();
    //Валявская
    public void addOrder(Order order){
        madeOrders.add(order);
    }
    //Валявская
    public void showInfo() {
        System.out.println("Name:" + name);
        System.out.println("Address:" + Address);
        System.out.println("Owner is " + owner.fullName + " and their telephone is " + owner.telephone);


    }
    //Валявская
    public void stats() {
        int sum = 0;
        if (madeOrders.size() == 0) {
            System.out.println("------------------------");
            System.out.println("There are no orders yet.");
            System.out.println("------------------------");

        } else {
            for (Order madeOrder : madeOrders) {
                sum = sum + madeOrder.cart.getSum();
            }
            System.out.println("Average check of your clients is " + sum / madeOrders.size());

        }
    }
    //Климешова
    public void stats(int k) {
        int sum = 0;
        int amount=0;

        if (madeOrders.size() == 0) {
            System.out.println("------------------------");
            System.out.println("There are no orders yet.");
            System.out.println("------------------------");

        } else {
            for (Order madeOrder : madeOrders) {
                if (madeOrder.clientId == k) {

                    sum = sum + madeOrder.cart.getSum();
                    amount++;
                }
            }
            if (amount!=0) {
                System.out.println("Average check of your client is " + (sum / amount));
            }
            else {
                System.out.println("------------------------");
                System.out.println("There are no orders yet.");
                System.out.println("------------------------");
            }
        }
    }
    //Климешова
    public void report(ArrayList<Product> startProducts, ArrayList<Product> availableProducts) {
        int i=0;
        System.out.println("-----------------------------");
        for (Product availableProduct : availableProducts) {
            System.out.printf("%-2s | %10s | %4d | %4d\n", availableProduct.product_id + 1, availableProduct.name, startProducts.get(i).amount-availableProduct.amount,availableProduct.price*(startProducts.get(i).amount-availableProduct.amount));
            i++;
        }
        System.out.println("-----------------------------");
    }
}
