package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.*;
import it.unipr.sowide.OllariIschimjiDmitri.Users.Admin;
import it.unipr.sowide.OllariIschimjiDmitri.Users.NormalUser;
import it.unipr.sowide.OllariIschimjiDmitri.Users.WorkerUser;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ollari Ischimji Dmitri
 * class used for interface the system to the final users like normal users and worker users.
 */
public class Main {

    public static void main(String[] args) {
        OnlineShop onlineShop = new OnlineShop();
        Orders orders = new Orders();
        ArrayList<NormalUser> users = new ArrayList<>();
        ArrayList<WorkerUser> workers = new ArrayList<>();

        //setup for tests
        NormalUser dmo = new NormalUser("testUser","password");
        users.add(dmo);

        WorkerUser w = new WorkerUser();
        w.setName("workerUser");
        w.setPassword("password");
        workers.add(w);

        Admin admin = new Admin(onlineShop);// ADMIN CREDENTIALS ARE: Admin Admin
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop){//MAIN LOOP OF THE PROGRAM
            System.out.println("Select one option: \n1 - login\n2 - register\n0 - Quit program");
            int choice = scanner.nextInt();

            switch (choice){
                case 1: System.out.println("login");
                System.out.println("Select one option for login:\n1 - admin\n2 - worker\n3 - normal user\n0 - previous menu");
                int loginChoice = scanner.nextInt();
                switch (loginChoice){
                    case 1://ADMIN LOGIN
                        System.out.println("Insert the password for the admin account:");//password = "admin"
                        String passwordAdmin = scanner.next();
                        if (passwordAdmin.isEmpty())
                        {
                            System.out.println("Empty password");
                        }
                        else if (passwordAdmin.equals(admin.getPassword()))
                        {
                            //LOGGED IN AS ADMIN



                            boolean adminloop = true;
                            while (adminloop){
                                System.out.println("Select option:\n1 - add new product to shop\n2 - remove product from shop\n3- new credential for workers\n0 - logout");
                                int adminchoise = scanner.nextInt();
                                switch (adminchoise){
                                    case 1:
                                        //ADD NEW PRODUCT TO SHOP
                                        Product newProduct = new Product();
                                        System.out.println("Insert the name of the new prduct");
                                        String newName = scanner.next();
                                        if (newName.isEmpty())
                                        {
                                            break;
                                        }
                                        else
                                        {
                                            newProduct.setName(newName);
                                            System.out.println("Insert the supplier of the new product:");
                                            String newSupplier = scanner.next();
                                            if (newSupplier.isEmpty()){
                                                break;
                                            }
                                            else
                                            {
                                                System.out.println("Insert the product price");
                                                float newPrice = scanner.nextFloat();
                                                if (newPrice > 0){
                                                    System.out.println("Insert the product quantity to ad in the store:");
                                                    int newQuantity = scanner.nextInt();
                                                    if (newQuantity > 0){
                                                        newProduct.setName(newName);
                                                        newProduct.setSupplier(newSupplier);
                                                        newProduct.setPrice(newPrice);
                                                        newProduct.setQuantity(newQuantity);

                                                        onlineShop.addProductToShop(newProduct);
                                                    }
                                                }
                                            }
                                        }


                                        break;
                                    case 2:
                                        //REMOVE PRODUCT FROM SHOP
                                        //SAMPO IL CONTENUTO DELLO SHOP
                                        for (int i = 0; i < onlineShop.getSize(); i++){
                                            System.out.println("Index = " + i + " " + onlineShop.getOnlineShop().get(i).toString());
                                        }
                                        System.out.println("Select the id of the product to remove from the shop:");
                                        int idToRemove = scanner.nextInt();
                                        if (idToRemove >= 0)
                                        {
                                            if (onlineShop.getOnlineShop().size() >= idToRemove){
                                                onlineShop.removeProduct(idToRemove, onlineShop);
                                                System.out.println("Udated catolog");
                                                for (int i = 0; i < onlineShop.getSize(); i++){
                                                    System.out.println("Index = " + i + " " + onlineShop.getOnlineShop().get(i).toString());
                                                }
                                            }
                                        }


                                        break;
                                    case 3:
                                        //NEW CREDENTIAL FOR WORKERS
                                        System.out.println("Insert new username for worker");
                                        String newWorkerUsername = scanner.next();
                                        if (newWorkerUsername.isEmpty())
                                        {
                                            System.out.println("username can't be empty");
                                        }
                                        else
                                        {
                                            System.out.println("Insert password for the new worker");
                                            String newWorkerPassword = scanner.next();
                                            if (newWorkerPassword.isEmpty())
                                            {
                                                System.out.println("password can't be empty");
                                            }
                                            else
                                            {
                                                WorkerUser work = new WorkerUser();
                                                work.setName(newWorkerUsername);
                                                work.setPassword(newWorkerPassword);

                                                workers.add(work);
                                            }
                                        }
                                        break;
                                    case 0:
                                        adminloop = false;
                                        break;
                                    default:
                                        System.out.println("Wrong choise");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("wrong password");
                        }
                        break;
                    case 2://WORKER LOGIN
                        if (workers.isEmpty())
                        {
                            System.out.println("Worker list is empty, first register some workers");
                            break;
                        }
                        System.out.println("insert name:");
                        String nameWorker = scanner.next();
                        System.out.println("insert password:");
                        String passwordWorker = scanner.next();

                        for (WorkerUser workerUser:workers){
                            if (workerUser.getName().equals(nameWorker) && workerUser.getPassword().equals(passwordWorker)){
                                System.out.println("LoggedIn as: " + workerUser.getName());

                                boolean loopWorkerUser = true;
                                while(loopWorkerUser){
                                    System.out.println("Actions menu:\n1 - Show orders\n2 - ship order\n3 - restock product\n0 - logout");
                                    int workerChoise = scanner.nextInt();

                                    switch (workerChoise){
                                        case 1:
                                            //SHOW ORDERS
                                            if (orders.getOrderList().isEmpty())
                                            {
                                                System.out.println("order list empty, nothing to do.");
                                            }
                                            else
                                            {
                                                for (int i = 0; i < orders.getOrderList().size(); i++){
                                                    System.out.println(orders.getOrderList().get(i).getProductId() + "\n" + orders.getOrderList().get(i).getUserName() + "\n" + orders.getOrderList().get(i).getProductQuantity());
                                                }
                                            }
                                            break;
                                        case 2:
                                            //SHIP ORDER
                                            if (orders.getOrderList().isEmpty())
                                            {
                                                System.out.println("order list empty, nothing to do.");
                                            }
                                            else
                                            {
                                                workerUser.nextOrder(orders);
                                            }
                                            break;

                                        case 3:
                                            //RESTOCK PRODUCT BY ID
                                            ArrayList<Product> lowProduct =  workerUser.checkLowQuantity(onlineShop);
                                            if (lowProduct.isEmpty()){
                                                System.out.println("No low qualtity product");
                                            }
                                            else
                                            {
                                                System.out.println("list of low product:");
                                                int index = 0;
                                                for (Product low:lowProduct){
                                                    System.out.println("index = " + index + "\n" + low.toString());
                                                    index++;
                                                }
                                                System.out.println("select the index of the product to restock");
                                                int selectedIndex = scanner.nextInt();
                                                if (lowProduct.size() > selectedIndex){
                                                    System.out.println("select quantity to add in the store:");
                                                    int selectedQuantityToRestock = scanner.nextInt();
                                                    if (selectedQuantityToRestock > 0){
                                                        for (int i = 0; i < onlineShop.getSize(); i++){
                                                            for (int j = 0; j < lowProduct.size(); j++){
                                                                if (onlineShop.getOnlineShop().get(i).getId().equals(lowProduct.get(j).getId())){
                                                                    if (j == selectedIndex){
                                                                        workerUser.restockLowProducts(onlineShop, i, selectedQuantityToRestock);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            }

                                            break;
                                        case 0:
                                            loopWorkerUser = false;
                                            break;
                                        default:
                                            System.out.println("select a valid option:");
                                            break;
                                    }
                                }
                            }
                            System.out.println("wrong credentials");
                        }
                        break;
                    case 3://NORMAL USER LOGIN
                        System.out.println("insert name:");
                        String name = scanner.next();
                        System.out.println("insert password:");
                        String passwordUser = scanner.next();
                        if (users.isEmpty())
                        {
                            System.out.println("Users list is empty, first register some users");
                            break;
                        }
                        for (NormalUser normalUser:users){
                            if (normalUser.getName().equals(name) && normalUser.getPassword().equals(passwordUser)){
                                System.out.println("LoggedIn as: " + normalUser.getName());
                                //TODO: loop and switch statement per far le azioni che luser normale deve fare
                                boolean loopNormalUser = true;

                                while(loopNormalUser){
                                    System.out.println("Actions Menu:\n1 - Show all product\n2 - Search\n3 - add to cart\n4 - purchase all products in cart\n0 - logout");
                                    int choiseNormalUser = scanner.nextInt();
                                    switch (choiseNormalUser){
                                        case 1:
                                            //PRINT ALL THE PRODUCTS IN THE SHOP
                                            for (int i = 0; i < onlineShop.getSize(); i++){
                                                System.out.println(onlineShop.getOnlineShop().get(i).toString());
                                            }
                                            break;
                                        case 2:
                                            //search section to serach by name, supplier and crescent descendento order

                                            System.out.println("Select:\n1 - search by name\n2 - search by supplier\n3 - search by name and supplier");
                                            int choiceSearch = scanner.nextInt();

                                            ArrayList<Product> search = new ArrayList<>();
                                            //SEARCH PRODUCTS IN THE SHOP
                                            switch (choiceSearch){
                                                case 1://SEARCH BY NAME
                                                    System.out.println("input the name to search:");
                                                    String nameToSearch = scanner.next();
                                                    if (!nameToSearch.isEmpty()){
                                                        search =  normalUser.searchByProductName(onlineShop.getOnlineShop(), nameToSearch);
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Product not found by name");
                                                    }
                                                    break;
                                                case 2://SEARCH BY SUPPLIER
                                                    System.out.println("input the supplier to search:");
                                                    String supplierToSearch = scanner.next();
                                                    if (!supplierToSearch.isEmpty()){
                                                        search =  normalUser.searchBySupplier(onlineShop.getOnlineShop(), supplierToSearch);
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Product not found by supplier");
                                                    }
                                                    break;
                                                case 3://SEARCH BY NAME AND SUPPLIER
                                                    System.out.println("input the name to search:");
                                                    String nameToSearchCombo = scanner.next();
                                                    if (!nameToSearchCombo.isEmpty()){
                                                        ArrayList<Product> app = new ArrayList<>();
                                                        app =  normalUser.searchByProductName(onlineShop.getOnlineShop(), nameToSearchCombo);
                                                        System.out.println("input the supplier to search:");
                                                        String supplierToSearchCombo = scanner.next();
                                                        if (!supplierToSearchCombo.isEmpty()){
                                                            search =  normalUser.searchBySupplier(app, supplierToSearchCombo);
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Product not found by supplier");
                                                            break;
                                                        }

                                                    }
                                                    else
                                                    {
                                                        System.out.println("Product not found by name");
                                                        break;
                                                    }
                                                default:

                                                    break;

                                            }

                                            //ORDER METHODS TO ORDER THE RESEARCH RESULTS
                                            System.out.println("Select 0 for leave the query order unaltereted, select 1 to order by increasing price, select 2 to order by decreasing price:");
                                            int sortSelect = scanner.nextInt();

                                            if (sortSelect == 0)
                                            {
                                                for (Product product:search){
                                                    System.out.println(product.toString());
                                                }
                                            }
                                            else if (sortSelect == 1){
                                                ArrayList<Product> cres = normalUser.crescentOrder(search);
                                                for (Product product:cres){
                                                    System.out.println(product.toString());
                                                }
                                            }
                                            else if (sortSelect == 2)
                                            {
                                                ArrayList<Product> dec = normalUser.decrescentOrder(search);
                                                for (Product product:dec){
                                                    System.out.println(product.toString());                                                }
                                            }


                                            break;

                                        case 3:
                                            //add product to cart

                                            for (int i = 0; i < onlineShop.getSize(); i++){
                                                System.out.println("Index = " + i + " " + onlineShop.getOnlineShop().get(i).toString());
                                            }
                                            System.out.println("\n\nSelect the index of the product to add in cart:");
                                            int chosenProductToAdd = scanner.nextInt();
                                            if (chosenProductToAdd + 1 > onlineShop.getOnlineShop().size())
                                            {
                                                System.out.println("Chosen index is out of range");
                                            }
                                            else
                                            {
                                                System.out.println("Select the quantity of the product to add in cart:");
                                                int chosenProductQuantity = scanner.nextInt();
                                                if (chosenProductQuantity > onlineShop.getOnlineShop().get(chosenProductToAdd).getQuantity()){
                                                    System.out.println("Product quantity chosen is grated than the product quantity in the store.");
                                                }
                                                else
                                                {
                                                    normalUser.getShoppingCart().addProductToShoppingCart(onlineShop.getOnlineShop().get(chosenProductToAdd), chosenProductQuantity);
                                                    System.out.println("Product added to cart.");
                                                }
                                            }

                                            break;
                                        case 4://purchase all product in cart
                                            if (normalUser.getShoppingCart().getShoppingCart().isEmpty())
                                            {
                                                System.out.println("Product cart is empty");
                                            }
                                            else
                                            {
                                                try {
                                                    normalUser.purchase(onlineShop, orders);
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            break;
                                        case 0:
                                            loopNormalUser = false;
                                            break;
                                        default:
                                            System.out.println("Wrong selection");
                                            break;

                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Name or password wrong");
                            }
                        }
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Wrong selection");
                        break;
                }
                        break;
                case 2://REGISTER NEW NORMAL USER
                    System.out.println("register");
                    System.out.println("Insert name:");
                    String name = scanner.next();
                    System.out.println("Insert password:");
                    String password = scanner.next();

                NormalUser user = new NormalUser(name, password);
                if (users.isEmpty())
                {
                    users.add(user);
                }
                else
                {
                    for (NormalUser normalUser:users){
                        if (normalUser.getName().equals(user.getName())){
                            System.out.println("user already registered.");
                            break;
                        }
                    }
                    users.add(user);
                }
                    break;
                case 0: System.out.println("QUIT");//END OF THE PROGRAM
                    loop = false;
                    break;
                default: System.out.println("Use a correct choise");
            }
        }

    }
}
