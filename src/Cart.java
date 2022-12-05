import java.util.ArrayList;
import java.util.Objects;

class Cart implements Cloneable{

    ArrayList<Products> products = new ArrayList<>();
    //Валявская
    void addProduct(ArrayList<Product> availableProducts, Product newProduct, int amount) {
        int check = 0;
        if (availableProducts.get(newProduct.product_id).amount < amount) System.out.println("Amount is not available now. Try to add less");
        else {
            for (Products product : products) {
                if (Objects.equals(product.product.name, newProduct.name)) {
                    product.amount = product.amount + amount;
                    check = 1;
                }
            }

            if (check == 0) {
                products.add(new Products(newProduct, amount));
            }

            availableProducts.get(newProduct.product_id).amount = availableProducts.get(newProduct.product_id).amount - amount;

        }
    }
    //Валявская
    void clearCart(ArrayList<Product> availableProducts) {

        for (Products product : products) {
            for (Product availableProduct : availableProducts) {
                if (product.product.product_id == availableProduct.product_id) {
                    availableProduct.amount = product.amount + availableProduct.amount;
                }
            }
        }
        products.clear();


    }
    //Климешова
    void clearCart(){
            products.clear();
    }
    //Климешова
    boolean findItem(String product){
        boolean flag=false;
        for (Products value : products) {
            if (product.equalsIgnoreCase(value.product.name)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Валявская
    void deleteItem(String product, ArrayList<Product> availableProducts) {
        for (int i = 0; i < products.size(); i++) {
            if (product.equalsIgnoreCase(products.get(i).product.name)) {
                availableProducts.get(products.get(i).product.product_id).amount = availableProducts.get(products.get(i).product.product_id).amount+ products.get(i).amount;
                products.remove(i);


            }
        }

    }

    //Климешова
    void showProducts(){
        int total=0;
        if (products.size()==0) System.out.println("Cart is empty");
        else {
            System.out.printf("%-10s | %6s |%8s \n", "Item", "amount","price");
            System.out.println("-----------------------------");
            for (Products product : products) {
                total = total + product.product.price * product.amount;
                System.out.printf("%-10s | %6d |%8d\n", product.product.name, product.amount, product.product.price * product.amount);
            }
            System.out.println("-----------------------------");
            System.out.println("Total:" + total);
        }
    }
    //Климешова
    void changeAmount(ArrayList<Product> availableProducts, String product, int newAmount){
        for (int i = 0; i < products.size(); i++) {
            if (product.equalsIgnoreCase(products.get(i).product.name)) {
                    if(availableProducts.get(i).amount+products.get(i).amount>=newAmount) {
                        availableProducts.get(i).amount = availableProducts.get(i).amount + products.get(i).amount - newAmount;
                        products.get(i).amount = newAmount;
                    }
                    else System.out.println("Amount is not available now. Try to add less");
            }
        }

    }
    //Климешова
    @Override
    public Object clone() throws CloneNotSupportedException {
        Cart cart = (Cart) super.clone();
        cart.products= (ArrayList<Products>) products.clone();
        return cart;
    }
    //Валявская
    int getSum(){
        int sum=0;
        for (int i=0;i< products.size();i++){
            sum=products.get(i).product.price*products.get(i).amount+sum;
        }
        return sum;

    }

    void getAmount(int amount){
        for (int i=0;i< products.size();i++){
            amount=products.get(i).amount+amount;
        }

    }
}
