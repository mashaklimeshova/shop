import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class main {
    static Shop makeShop(){
        Owner owner = new Owner ("Ivanov Ivan Ivanovich", "Moscow", "89451234567");
        Shop six = new Shop ("Шестерочка","Moscow",owner);
        return six;
    }

    static void scanClients(ArrayList<Client> clients){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("ClientsDataBase"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Файл не найден");
        }
        while (scanner.hasNext()) {
            Cart cart = new Cart();
            Client client = new Client(scanner.next() + " " + scanner.next(), scanner.next(), scanner.next(), cart);
            clients.add(client);
        }
    }
    static void fillShop(ArrayList<Product> availableProducts){
        Product product = new Product("Apple", "food", 52,100);
        Product product1 = new Product("Cheese", "food", 300,100);
        Product product2 = new Product("Banana", "food", 30,100);

        availableProducts.add(product);
        availableProducts.add(product1);
        availableProducts.add(product2);

    }

     static void terminal(ArrayList<Client> existingClients,ArrayList<Product> availableProducts ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("1. Start shopping\n2. Continue shopping\n3. Show information about the shop\n4. Finish");

        try{
        int key = scanner.nextInt();
        scanClients(existingClients);
        switch (key){
            case (1):
                Client client = new Client("default","default","default",null);
                client.cart= new Cart();
                cases(availableProducts, client, existingClients);
            case (2):
                int flag=-1;
                while (flag==-1) {
                    System.out.print("Enter your name. If it consists of more than one word, enter it using - (example Maria-Sofia): ");
                    String firstName = scanner.next();
                    String secondName = scanner.next();
                    for (int i = 0; i < existingClients.size(); i++) {
                        if ((existingClients.get(i).fullName.equalsIgnoreCase(firstName + " " + secondName)) || (existingClients.get(i).fullName.equalsIgnoreCase(secondName + " " + firstName))) {
                            flag = i;

                        }
                    }
                    if (flag == -1) System.out.println("Invalid name");
                    else cases(availableProducts,existingClients.get(flag), existingClients);
                }

            case(3):
                Shop shop = makeShop();
                shop.showInfo();
                terminal(existingClients,availableProducts);


            case(4):
                System.out.println("Good bye");
                System. exit(0);

        }} catch (InputMismatchException e) {
            System.err.println("Invalid input");
            terminal(existingClients,availableProducts);
        }
        catch (NoSuchElementException d){
            System.exit(0);

        }

     }
     static void cases(ArrayList<Product> availableProducts,Client client,ArrayList<Client> clients){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add product\n2. Show your cart\n3. Change an amount\n4. Make order\n5. Delete item\n6. Clear cart\n7. Show your orders\n8. Exit to main menu");
        try{
        int key = scanner.nextInt();
        switch (key){
            case(1):
                int t = 1;
                    while (t == 1) {
                        System.out.println("What product do you want to add (choose number). If you want to go back, enter BACK:");
                        System.out.printf("%-2s | %10s | %4s | %4s\n", " ", "name", "price", "amount");
                        System.out.printf("-----------------------------\n");
                        for (int i = 0; i < availableProducts.size(); i++) {
                            System.out.printf("%-2s | %10s | %4d | %4d\n", (i + 1), availableProducts.get(i).name, availableProducts.get(i).price, availableProducts.get(i).amount);
                        }
                        Scanner sc = new Scanner(System.in);
                        String enter = sc.next();
                        try {
                            Integer id = Integer.valueOf(enter);
                            if (id <= 0 || id > availableProducts.size()) {
                                System.out.println("No such product");
                                cases(availableProducts, client, clients);
                                break;
                            }
                            System.out.print("Amount: ");
                            int amount = scanner.nextInt();
                            client.cart.addProduct(availableProducts, availableProducts.get(id - 1), amount);
                            System.out.println("Do you want to continue? \n 1. yes \n 2. no ");
                            t = scanner.nextInt();
                            if (t == 2) {
                                cases(availableProducts, client, clients);
                                break;
                            }
                        } catch (NumberFormatException e) {
                            if (enter.equalsIgnoreCase("back")) {
                                cases(availableProducts, client, clients);
                                break;
                            } else {
                                System.err.println("Invalid input");
                                cases(availableProducts, client, clients);
                                break;
                            }

                        }
                    }
            case(2):
                client.cart.showProducts();
                cases(availableProducts,client,clients);
                break;
            case (3):
                Scanner sc = new Scanner(System.in);
                if (!(client.cart.products.isEmpty())) {
                    while (true) {
                        client.cart.showProducts();
                        System.out.print("Choose product ");
                        String prod = sc.nextLine();
                        if (client.cart.findItem(prod)) {
                            System.out.print("Enter new amount ");
                            int newAmount = sc.nextInt();
                            client.cart.changeAmount(availableProducts, prod, newAmount);
                            break;

                        } else System.out.println("There is no such product. Try again.");
                    }
                }
                    client.cart.showProducts();
                    cases(availableProducts, client, clients);
                    break;
            case(4):
                Scanner in = new Scanner(System.in);
                if (!client.cart.products.isEmpty()) {
                    if (client.fullName == "default") {
                        System.out.print("Enter your full name (example - Ivanov Ivan). If it consists of more than one word, enter it using - (example Ivanova-Petrova Maria-Sofia): ");
                        String fullName = in.nextLine();
                        System.out.print("Enter your address: ");
                        String address;
                        address = in.nextLine();
                        System.out.print("Enter your telephone: ");
                        String telephone;
                        telephone = in.nextLine();

                        client.fullName = fullName;
                        client.telephone = telephone;
                        client.Address = address;

                        int a = findClient(clients, client);
                        if (a == 0) clients.add(client);
                        else System.out.println("This client already exist. We will place an order for their account");
                    }
                    System.out.println("");
                    Order newOrder = client.createOrder(availableProducts);
                    client.cart.clearCart(availableProducts);
                    System.out.println("Thanks for your order!");
                    System.out.println("");
                    cases(availableProducts,client,clients);
                    break;
                }
                else {
                    System.out.println("Your cart is empty");
                    cases(availableProducts,client,clients);
                    break;
                }

            case(5):
                Scanner deleter = new Scanner (System.in);
                if (!client.cart.products.isEmpty()) {
                    while (true) {
                        client.cart.showProducts();
                        System.out.print("Choose product. If you want to exit write back: ");
                        String prod = deleter.nextLine();
                        if (prod.equalsIgnoreCase("back")) break;
                        else if (client.cart.findItem(prod)) {
                            client.cart.deleteItem(prod, availableProducts);
                            break;
                        }
                        else System.out.println("There is no such product. Try again.");
                    }


                }
                client.cart.showProducts();
                cases(availableProducts,client,clients);
                break;
            case(6):
                client.cart.clearCart(availableProducts);
                cases(availableProducts,client,clients);
                break;
            case(7):
                client.showInfo();
                cases(availableProducts,client,clients);
                break;
            case(8):
                terminal(clients,availableProducts);
                cases(availableProducts,client,clients);
            default:
                System.err.println("Invalid input");
                cases(availableProducts,client,clients);
        }
        } catch (InputMismatchException e) {
           System.err.println("Invalid input");
            cases(availableProducts,client,clients);
        }
        catch (NoSuchElementException d){
            System.exit(0);

        }


     }

    public static int findClient(ArrayList<Client> clients, Client newClient) {
        int a=0;
        for (int i=0; i<clients.size();i++){
            if (clients.get(i).equals(newClient)) a=1;
        }
        return a;
    }

    public static void main(String[] args) {
        ArrayList<Product> availableProducts = new ArrayList<Product>();
        System.out.println("\nnotice:\nTo work with menus please enter the number of action you want to do.");
        System.out.println("------------------------------------------------------------------\n\n");
        Client client = null;
        ArrayList<Client> clients = new ArrayList<Client>();
        System.out.println("Welcome to our shop!\nWhat do you want?");
        fillShop(availableProducts);
        terminal(clients,availableProducts);



    }
}