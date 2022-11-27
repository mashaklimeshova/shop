import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Shop makeShop(){
        Owner owner = new Owner ("Ivanov Ivan Ivanovich", "Moscow", "89451234567");
        Shop six = new Shop ("Шестерочка","Moscow",owner);
        return six;
    }
    static void fillShop(ArrayList<Product> availableProducts){
        Product product = new Product("Apple", "food", 52,100);
        Product product1 = new Product("Cheese", "food", 300,100);
        Product product2 = new Product("Banana", "food", 30,100);

        availableProducts.add(product);
        availableProducts.add(product1);
        availableProducts.add(product2);

    }

     static Object terminal(ArrayList<Client> clients ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("1. Start shopping\n2. Continue shopping\n3. Show information about the shop\n4. Finish");
        int key = scanner.nextInt();

        switch (key){
            case (1):
                Client client = null;
                Cart cart = new Cart();
                return cart;

            case (2):
                System.out.println("hello motherfucker");
                return clients.get(0).cart;

            case(3):
                Shop shop = makeShop();
                shop.showInfo();
                terminal(clients);


            case(4):
                System.out.println("Good bye");
                System. exit(0);

            default:
               System.out.println("Invalid input");
               terminal(clients);
        }

         return null;
     }
     static void cases(Cart cart, ArrayList<Product> availableProducts,Client client,ArrayList clients){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add product\n2. Show your cart\n3. Change an amount\n4. Make order\n5. Delete item\n6. Clear cart\n7. Show your orders\n8. Exit to main menu");
        int key = scanner.nextInt();
        switch (key){
            case(1):
                int t = 1;
                    while (t == 1) {
                        System.out.println("What product do you want to add");
                        System.out.printf("%-2s | %10s | %4s | %4s\n"," ", "name", "price", "amount");
                        System.out.printf("-----------------------------\n");
                        for (int i = 0; i < availableProducts.size(); i++) {
                            System.out.printf("%-2s | %10s | %4d | %4d\n", (i + 1), availableProducts.get(i).name, availableProducts.get(i).price, availableProducts.get(i).amount);
                        }
                        int id = scanner.nextInt();
                        if (id<=0 || id>= availableProducts.size()) {System.out.println ("No such product"); cases(cart, availableProducts,client,clients); break;}
                        System.out.print("Amount: ");
                        int amount = scanner.nextInt();
                        cart.addProduct(availableProducts, availableProducts.get(id - 1), amount);
                        System.out.println("Do you want to continue? \n 1. yes \n 2. no ");
                        t = scanner.nextInt();
                        if (t == 2)  {cases(cart, availableProducts,client,clients); break;}

                }
            case(2):
                cart.showProducts();
                cases(cart, availableProducts,client,clients);
                break;
            case (3):
                while (true) {
                    cart.showProducts();
                    System.out.print("Choose product ");
                    String prod = scanner.nextLine();
                    if (cart.findItem(prod)) {
                        System.out.print("Enter new amount ");
                        int newAmount = scanner.nextInt();
                        cart.changeAmount(availableProducts,prod,newAmount);
                        break;

                    }
                    else System.out.println("There is no such product. Try again.");
                }
                cart.showProducts();
                cases(cart, availableProducts,client,clients);
                break;
            case(4):
                if (client.fullName=="default") {
                    System.out.print("Enter your full name:");
                    String fullName = scanner.nextLine();
                    fullName = scanner.nextLine();
                    System.out.print("Enter your address:");
                    String address;
                    address = scanner.nextLine();
                    System.out.print("Enter your telephone:");
                    String telephone;
                    telephone = scanner.nextLine();

                    client.fullName = fullName;
                    client.telephone = telephone;
                    client.Address = address;

                    clients.add(client);
                }
                Order newOrder = client.createOrder();
                System.out.println(newOrder.orderId + " " + newOrder.cart_id + " " + client.fullName);
                break;
            case(5):
                while (true) {
                    cart.showProducts();
                    System.out.print("Choose product ");
                    String prod = scanner.nextLine();
                    if (cart.findItem(prod)) {
                        cart.deleteItem(prod,availableProducts);
                        break;

                    }
                    else System.out.println("There is no such product. Try again.");
                }
                cart.showProducts();
                cases(cart, availableProducts,client,clients);
                break;
            case(6):
                cart.clearCart(availableProducts);
                cases(cart, availableProducts,client,clients);
                break;
            case(7):
                client.showInfo();
                cases(cart, availableProducts,client,clients);
                break;
            case(8):
                cart= (Cart) terminal(clients);
                cases(cart,availableProducts,client,clients);
            default:
                System.out.println("Invalid input");
                cases(cart,availableProducts,client,clients);
        }

     }

    public static void main(String[] args) {
        makeShop();
        ArrayList<Product> availableProducts = new ArrayList<Product>();

        Cart cart = new Cart();

        Client client = new Client("default", "default", "default",cart);
        ArrayList<Client> clients = new ArrayList<Client>();
        System.out.println("Welcome to our shop!\nWhat do you want?");
        terminal(clients);

        fillShop(availableProducts);
        cases(client.cart,availableProducts,client,clients);


    }
}