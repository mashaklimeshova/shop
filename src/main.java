import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static void makeShop(){
        Shop six = new Shop ("Шестерочка","Moscow");
        Owner owner = new Owner ("Ivanov Ivan Ivanovich", "Moscow", "89451234567", six);
    }

     static Object terminal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our shop!\nWhat do you want?");
        System.out.println("1. Start shopping\n2. Continue shopping\n3. Finish");
        int key = scanner.nextInt();

        switch (key){
            case (1):
                Client client = new Client("default", "default","default");
                Cart cart = new Cart(client);
                return cart;

            case (2):
                System.out.println("Сделать готовых юзеров");
                return null;

            case(3):
                System.out.println("Good bye");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + key);
        }

         return null;
     }
     static void cases(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Change amount\n2. Make order\n3. Delete item\n4. Clear cart");
        int key = scanner.nextInt();
        switch (key){
            case (1):
                break;
            case(2):
                break;
            case(3):
                break;
            case(4):
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + key);
        }

     }

    public static void main(String[] args) {
        makeShop();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> availableProducts = new ArrayList<Product>();

        Client client = new Client("default", "default", "default");
        Cart cart = (Cart) terminal();

        Product product = new Product("Apple", "food", 100);
        Product product1 = new Product("Cheese", "food", 1000);
        Product product2 = new Product("Banana", "food", 50);

        availableProducts.add(product);
        availableProducts.add(product1);
        availableProducts.add(product2);

        int t = 1;

        if (cart != null) {

            while (t == 1) {
                System.out.println("What product do you want to add");
                for (int i = 0; i < availableProducts.size(); i++) {
                    System.out.println((i + 1) + ". " + availableProducts.get(i).name);
                }
                int id = scanner.nextInt();
                System.out.println("Amount:");
                int amount = scanner.nextInt();
                cart.addProduct(availableProducts.get(id - 1), amount);
                System.out.println("Do you want to continue? \n 1. yes \n 2. no ");
                t = scanner.nextInt();
                if (t == 2) break;
                else cases();
            }

            cart.showProducts();


        }
    }
}
