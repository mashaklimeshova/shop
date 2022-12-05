import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


//TODO пробелы в имени и адресе,hashcode,статистика по клиенту

public class main {
    private static ArrayList<Product> startProducts;
    private static Shop shop = new Shop();

    static void printClients (ArrayList<Client> existingClients) throws IOException {
        try {
            FileWriter fstream1 = new FileWriter("ClientsDataBase");
            BufferedWriter out = new BufferedWriter(fstream1);
            for (Client existingClient : existingClients) {
                out.write(existingClient.fullName + " " + existingClient.Address + " " + existingClient.telephone + "\n");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void printProducts(ArrayList<Product> availableProducts) throws IOException {
        try {
            FileWriter fstream2 = new FileWriter("ProductsDataBase");
            BufferedWriter out2 = new BufferedWriter(fstream2);
            for (Product availableProduct : availableProducts) {
                out2.write(availableProduct.name + " " + availableProduct.type + " " + availableProduct.price + " " + availableProduct.amount + "\n");
            }
            out2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void scanProducts(ArrayList<Product> availableProducts){
        availableProducts.clear();
        Scanner scanner = null;
        int i=0;

        try {
            scanner = new Scanner(new File("ProductsDataBase"));
        } catch (Exception e) {
            System.err.println("Error");
        }
        if (scanner != null) {
            while (scanner.hasNext()) {
                Product product = new Product(i,scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());
                i++;
                availableProducts.add(product);
            }
        }

    }

    static void scanClients(ArrayList<Client> clients){
        Scanner scanner = null;
        ArrayList<Client> newClients = new ArrayList<>();
        try {
            scanner = new Scanner(new File("ClientsDataBase"));
        } catch (Exception e) {
            System.err.println("Error");
        }
        if (scanner != null) {
            while (scanner.hasNext()) {

                Cart cart = new Cart();
                Client client = new Client(scanner.next() + " " + scanner.next(), scanner.next(), scanner.next(), cart);
                newClients.add(client);
            }
        }
        if (clients.isEmpty()){
            clients.addAll(newClients);
        }
    }
    static void shopController(ArrayList<Client> existingClients, ArrayList<Product> availableProducts,ArrayList<Product>startProducts ) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. View products\n2. Show clients\n3. Get stats\n4. Sales report\n5. Go back");
        try {
            int key = scanner.nextInt();
            switch (key){
                case(1):
                    System.out.printf("%-2s | %10s | %4s | %4s\n", " ", "name", "price", "amount");
                    System.out.println("-----------------------------");
                    for (Product availableProduct : availableProducts) {
                        System.out.printf("%-2s | %10s | %4d | %4d\n", availableProduct.product_id + 1, availableProduct.name, availableProduct.price, availableProduct.amount);
                    }
                    System.out.println("-----------------------------");
                    shopController(existingClients,availableProducts,startProducts);
                    break;
                case(2):
                    System.out.println("-----------------------------");
                    for (int i=0;i<existingClients.size();i++){
                        System.out.println((i+1) + ". " + existingClients.get(i).fullName);
                    }
                    System.out.println("-----------------------------");
                    shopController(existingClients,availableProducts, startProducts);
                    break;
                case(3):
                    shop.stats();
                    shopController(existingClients,availableProducts,startProducts);
                    break;
                case(4):
                    shop.report(startProducts, availableProducts);
                    shopController(existingClients,availableProducts,startProducts);
                    break;

                case(5):
                    terminal(existingClients,availableProducts);

            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
            shopController(existingClients,availableProducts,startProducts);
        }

    }

     static void terminal(ArrayList<Client> existingClients, ArrayList<Product> availableProducts) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Start shopping\n2. Continue shopping\n3. Show information about the shop\n4. Owner menu\n5. Finish");
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
                    System.out.print("Enter your name. If it consists of more than one word, enter it using - (example Maria-Sofia). To leave enter GO BACK: ");
                    String firstName = scanner.next();
                    String secondName = scanner.next();
                    if (firstName.equalsIgnoreCase("GO") && secondName.equalsIgnoreCase("back")) {
                        terminal(existingClients, availableProducts);
                        break;
                    } else {
                        for (int i = 0; i < existingClients.size(); i++) {
                            if ((existingClients.get(i).fullName.equalsIgnoreCase(firstName + " " + secondName)) || (existingClients.get(i).fullName.equalsIgnoreCase(secondName + " " + firstName))) {
                                flag = i;

                            }
                        }
                        if (flag == -1) System.out.println("Invalid name");
                        else cases(availableProducts, existingClients.get(flag), existingClients);
                    }
                }

            case(3):
                shop.showInfo();
                terminal(existingClients,availableProducts);

            case(4):
                System.out.println("Enter owner password to manage the shop:");
                int password= Integer.parseInt(scanner.next());
                if (password==1234){
                    shopController(existingClients,availableProducts,startProducts);
                }
                else terminal(existingClients,availableProducts);
            case(5):
                System.out.println("Good bye");
                System. exit(0);

            default:
                System.err.println("Invalid input");
                terminal(existingClients,availableProducts);



        }} catch (InputMismatchException e) {
            System.err.println("Invalid input");
            terminal(existingClients,availableProducts);
        }
        catch (NoSuchElementException d){
            System.exit(0);

        }
     }
     static void cases(ArrayList<Product> availableProducts,Client client,ArrayList<Client> clients) throws CloneNotSupportedException {
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
                        System.out.println("-----------------------------");
                        for (Product availableProduct : availableProducts) {
                            System.out.printf("%-2s | %10s | %4d | %4d\n", availableProduct.product_id + 1, availableProduct.name, availableProduct.price, availableProduct.amount);
                        }
                        Scanner sc = new Scanner(System.in);
                        String enter = sc.next();
                        try {
                            int id = Integer.parseInt(enter);
                            if (id <= 0 || id > availableProducts.size()) {
                                System.out.println("No such product");
                                cases(availableProducts, client, clients);
                                break;
                            }
                            System.out.print("Amount: ");
                            int amount = scanner.nextInt();
                            if (amount >0) {
                                client.cart.addProduct(availableProducts, availableProducts.get(id - 1), amount);
                                System.out.println("Do you want to continue? \n 1. yes \n 2. no ");
                                t = scanner.nextInt();
                                if (t == 2) {
                                    cases(availableProducts, client, clients);
                                    break;
                                }
                            }
                            else System.out.println("Invalid input");
                        } catch (NumberFormatException e) {
                            if (!enter.equalsIgnoreCase("back")) {
                                System.out.println("Invalid input");
                            }
                            cases(availableProducts, client, clients);
                            break;

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
                            if (newAmount>=0) {
                                client.cart.changeAmount(availableProducts, prod, newAmount);
                            }
                            else System.out.println("Invalid input");
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
                    if (client.fullName.equalsIgnoreCase("default")) {
                        System.out.print("Enter your full name (example - Ivanov Ivan). If it consists of more than one word, enter it using - (example Ivanova-Petrova Maria-Sofia): ");
                        String secondName = in.next();
                        String firstName = in.next();
                        System.out.print("Enter your address: ");
                        String address;
                        address = in.next();
                        System.out.print("Enter your telephone: ");
                        String telephone;
                        telephone = in.next();
                        while (telephone.length()!=11){
                            System.out.print("Enter your telephone again, previous can not be interpreted: ");
                            telephone = in.next();
                        }
                        client.fullName = secondName + " " + firstName;
                        client.telephone = telephone;
                        client.Address = address;

                        int a = findClient(clients, client);
                        if (a == 0) {
                            clients.add(client);
                            printClients(clients);
                        }
                        else System.out.println("This client already exist. We will place an order for their account");
                    }
                    client.createOrder(shop);
                    client.cart.clearCart();
                    printProducts(availableProducts);
                    System.out.println("\nThanks for your order!\n");
                }
                else {
                    System.out.println("Your cart is empty");
                }
                cases(availableProducts,client,clients);
                break;

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
                Scanner enter = new Scanner(System.in);
                System.out.println("What do you want to see?\n1. Show orders\n2. Get average check\n3. Go back");
                try {
                    key = enter.nextInt();
                    if (key==1){
                        client.showInfo();
                        cases(availableProducts, client, clients);
                        break;
                    }
                    else if (key==2){
                        if (!client.orders.isEmpty()) {
                            client.stats();
                        }
                        else client.showInfo();
                        cases(availableProducts, client, clients);
                        break;
                    }
                    else if (key==3) {
                        cases(availableProducts, client, clients);
                        break;
                    }
                } catch (CloneNotSupportedException e) {
                    System.out.println("Invalid input");
                    cases(availableProducts,client,clients);
                }

            case(8):
                scanProducts(availableProducts);
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

        } catch (IOException e) {
            e.printStackTrace();
        }


     }

    public static int findClient(ArrayList<Client> clients, Client newClient) {
        int a=0;
        for (Client client : clients) {
            if (client.equals(newClient)) a = 1;
        }
        return a;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Product> availableProducts = new ArrayList<>();
        System.out.println("\nnotice:\nTo work with menus please enter the number of action you want to do.");
        System.out.println("------------------------------------------------------------------\n\n");
        scanProducts(availableProducts);
        startProducts= (ArrayList<Product>) availableProducts.clone();
        ArrayList<Client> clients = new ArrayList<>();
        System.out.println("Welcome to our shop!\nWhat do you want?");
        terminal(clients,availableProducts);



    }
}