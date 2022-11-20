import java.awt.*;
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

    void deleteItem(int id) {
        products.remove(id);



    }

    void createOrder() {

    }
    void showProducts(){
        if (products.size()==0) System.out.println("Cart is empty");
        else
            for (int j=0;j<products.size();j++){
            System.out.println(products.get(j).product.name + " " + products.get(j).amount);
        }

    }
    void changeAmount (int id, int newAmount){
        products.get(id).amount=newAmount;
    }
}
