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
        System.out.println("Name:" + this.name);
        System.out.println("Address:" + this.Address);
        System.out.println("Owner is " + this.owner.fullName + " and their telephone is " + this.owner.telephone);


    }
    //Валявская
    public void stats() {
        int sum = 0;
        if (madeOrders.size() == 0) {
            System.out.println("------------------------");
            System.out.println("There are no orders yet.");
            System.out.println("------------------------");

        } else {
            for (int i = 0; i < madeOrders.size(); i++) {
                sum = sum + madeOrders.get(i).cart.getSum();
            }
            System.out.println("Average check of your clients is " + sum / madeOrders.size());

        }
    }
    //Климешова
    public void report(ArrayList<Product> startProducts, ArrayList<Product> availableProducts) {
        int i=0;
        System.out.println("Sold products:");
        System.out.printf("%-2s | %10s | %4s | %4s\n", " ", "name" , "amount","income");
        System.out.println("-----------------------------");
        for (Product availableProduct : availableProducts) {
            System.out.printf("%-2s | %10s | %4d | %4d\n", availableProduct.product_id + 1, availableProduct.name, startProducts.get(i).amount-availableProduct.amount,availableProduct.price*(startProducts.get(i).amount-availableProduct.amount));
            i++;
        }
    }
}
