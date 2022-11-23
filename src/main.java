import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static void makeShop(){
        Shop six = new Shop ("Шестерочка","Moscow");
        Owner owner = new Owner ("Ivanov Ivan Ivanovich", "Moscow", "89451234567", six);
    }
    static void fillShop(ArrayList<Product> availableProducts){
        Product product = new Product("Apple", "food", 52);
        Product product1 = new Product("Cheese", "food", 10);
        Product product2 = new Product("Banana", "food", 50);

        availableProducts.add(product);
        availableProducts.add(product1);
        availableProducts.add(product2);

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
               System.out.println("Invalid input");
               terminal();
        }

         return null;
     }
     static void cases(Cart cart, ArrayList<Product> availableProducts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add product\n2. Show your cart\n3. Change an amount\n4. Make order\n5. Delete item\n6. Clear cart");
        int key = scanner.nextInt();
        switch (key){
            case(1):
                int t = 1;
                if (cart != null) {
                    while (t == 1) {
                        System.out.println("What product do you want to add");
                        for (int i = 0; i < availableProducts.size(); i++) {
                            System.out.println((i + 1) + ". " + availableProducts.get(i).name);
                        }
                        int id = scanner.nextInt();
                        System.out.print("Amount: ");
                        int amount = scanner.nextInt();
                        cart.addProduct(availableProducts.get(id - 1), amount);
                        System.out.println("Do you want to continue? \n 1. yes \n 2. no ");
                        t = scanner.nextInt();
                        if (t == 2)  {cases(cart, availableProducts); break;}
                    }

                }
            case(2):
                cart.showProducts();
                cases(cart, availableProducts);
                break;
            case (3):
                while (true) {
                    cart.showProducts();
                    System.out.print("Choose product ");
                    String prod = scanner.nextLine();
                    if (cart.findItem(prod)) {
                        System.out.print("Enter new amount ");
                        int newAmount = scanner.nextInt();
                        cart.changeAmount(prod,newAmount);
                        break;

                    }
                    else System.out.println("There is no such product. Try again.");
                }
                cart.showProducts();
                cases(cart, availableProducts);
                break;
            case(4):
                System.out.print("Enter your full name:");
                String fullName=scanner.nextLine();
                fullName=scanner.nextLine();
                System.out.print("Enter your address:");
                String address;
                address=scanner.nextLine();
                System.out.print("Enter your telephone:");
                String telephone;
                telephone=scanner.nextLine();

                cart.client.fullName=fullName;
                cart.client.telephone=telephone;
                cart.client.Address=address;

                Order newOrder = cart.createOrder();
                System.out.println(newOrder.orderId + " " + newOrder.cart_id + " " + cart.client.fullName);
                break;
            case(5):
                while (true) {
                    cart.showProducts();
                    System.out.print("Choose product ");
                    String prod = scanner.nextLine();
                    if (cart.findItem(prod)) {
                        cart.deleteItem(prod);
                        break;

                    }
                    else System.out.println("There is no such product. Try again.");
                }
                cart.showProducts();
                cases(cart, availableProducts);
                break;
            case(6):
                cart.clearCart();
                cases(cart, availableProducts);
                break;
            default:
                System.out.println("Invalid input");
                cases(cart,availableProducts);
        }

     }

    public static void main(String[] args) {
        makeShop();
        ArrayList<Product> availableProducts = new ArrayList<Product>();

        Client client = new Client("default", "default", "default");
        Cart cart = (Cart) terminal();

       fillShop(availableProducts);
       cases(cart,availableProducts);


    }
}