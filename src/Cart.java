import java.util.ArrayList;

class Cart {


    Client client;
    ArrayList<Products> products = new ArrayList<Products>();


    public Cart(Client client) {
        this.client = client;

    }
    void addProduct(Product newProduct, int amount){
        int check=0;
        for (int i=0;i<products.size();i++) {
            if (products.get(i).product.name == newProduct.name) {
                products.get(i).amount = products.get(i).amount + amount;
                check = 1;
            }
        }

        if (check==0) products.add(new Products(newProduct,amount));

    }

    void clearCart() {
        products.clear();


    }
    boolean findItem(String product){
        boolean flag=false;
        for (int i = 0; i < products.size(); i++) {
            if (product.equalsIgnoreCase(products.get(i).product.name)) {
                flag=true;
                break;
            }
            else flag=false;
        }
        return flag;
    }

    void deleteItem(String product) {
        for (int i = 0; i < products.size(); i++) {
            if (product.equalsIgnoreCase(products.get(i).product.name)) {
                products.remove(i);
            }
        }

    }

    Order createOrder() {
        Order order = new Order (this.client);

        return order;
    }
    void showProducts(){
        int total=0;
        if (products.size()==0) System.out.println("Cart is empty");
        else {
            System.out.printf("%-10s | %6s |%8s\n", "Item", "amount","price");
            System.out.printf("-----------------------------\n");
            for (int j = 0; j < products.size(); j++) {
                total = total + products.get(j).product.price * products.get(j).amount;
                System.out.printf("%-10s | %6d |%8d\n",products.get(j).product.name, products.get(j).amount,products.get(j).product.price * products.get(j).amount);
            }
            System.out.printf("-----------------------------\n");
            System.out.println("Total:" + total);
        }
    }
    void changeAmount (String product, int newAmount){
        for (int i = 0; i < products.size(); i++) {
            if (product.equalsIgnoreCase(products.get(i).product.name)) {
                products.get(i).amount=newAmount;
            }
        }

    }
}
