import java.util.ArrayList;

class Cart {


    protected int i=0;
    public int cart_id;
    ArrayList<Products> products = new ArrayList<Products>();


    public Cart() {
        this.cart_id=i;
        i++;

    }
    void addProduct(ArrayList<Product> availableProducts, Product newProduct, int amount) {
        int check = 0;
        if (availableProducts.get(newProduct.product_id).amount < amount) System.out.println("Amount is not available now. Try to add less");
        else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).product.name == newProduct.name) {
                    products.get(i).amount = products.get(i).amount + amount;
                    check = 1;
                }
            }

            if (check == 0) {

                products.add(new Products(newProduct, amount));
            }

            availableProducts.get(newProduct.product_id).amount = availableProducts.get(newProduct.product_id).amount - amount;

        }
    }
    void clearCart(ArrayList<Product> availableProducts) {

        for (int i=0;i<products.size();i++){
            if (products.get(i).product.product_id==availableProducts.get(i).product_id){
                availableProducts.get(i).amount=products.get(i).amount+ availableProducts.get(i).amount;
            }
        }
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

    void deleteItem(String product, ArrayList<Product> availableProducts) {
        for (int i = 0; i < products.size(); i++) {
            if (product.equalsIgnoreCase(products.get(i).product.name)) {
                availableProducts.get(i).amount = availableProducts.get(i).amount+ products.get(i).amount;
                products.remove(i);


            }
        }

    }


    void showProducts(){
        int total=0;
        if (products.size()==0) System.out.println("Cart is empty");
        else {
            System.out.printf("%-10s | %6s |%8s \n", "Item", "amount","price");
            System.out.printf("-----------------------------\n");
            for (int j = 0; j < products.size(); j++) {
                total = total + products.get(j).product.price * products.get(j).amount;
                System.out.printf("%-10s | %6d |%8d\n",products.get(j).product.name, products.get(j).amount,products.get(j).product.price * products.get(j).amount);
            }
            System.out.printf("-----------------------------\n");
            System.out.println("Total:" + total);
        }
    }
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
}
