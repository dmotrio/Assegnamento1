package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.*;
import it.unipr.sowide.OllariIschimjiDmitri.Users.Admin;
import it.unipr.sowide.OllariIschimjiDmitri.Users.NormalUser;
import it.unipr.sowide.OllariIschimjiDmitri.Users.WorkerUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/*
	* creo i due oggetti alla base di tutto che sono lo shop e la lista degli ordini.
	* Dopo di che con la programmazione sequenziale, dovrò creare gli utenti mediante un utente login hardcoded
	*
	*/
        OnlineShop onlineShop = new OnlineShop();
        Orders orders = new Orders();
        ArrayList<NormalUser> users = new ArrayList<>();
        ArrayList<WorkerUser> workers = new ArrayList<>();

        Admin admin = new Admin(onlineShop);
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop){
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
                        System.out.println("insert name:");
                        String nameWorker = scanner.next();
                        System.out.println("insert password:");
                        String passwordWorker = scanner.next();
                        if (workers.isEmpty())
                        {
                            System.out.println("Worker list is empty, first register some workers");
                            break;
                        }
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
                                            //TODO: RESTOCK PRODUCT BY ID
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
                                                }
                                                System.out.println("select the index of the product to restock");
                                                int selectedIndex = scanner.nextInt();
                                                if (lowProduct.size() > selectedIndex){
                                                    System.out.println("select quantity to add in the store:");
                                                    int selectedQuantityToRestock = scanner.nextInt();
                                                    if (selectedQuantityToRestock > 0){
                                                        for (int i = 0; i < onlineShop.getSize(); i++){

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
                                            //SAMPO IL CONTENUTO DELLO SHOP
                                            for (int i = 0; i < onlineShop.getSize(); i++){
                                                System.out.println(onlineShop.getOnlineShop().get(i).toString());
                                            }
                                            break;
                                        case 2:
                                            System.out.println("If you want search by name(leave blanc if you want use this features), insert here the name of the product:");
                                            String searchByName = scanner.next();
                                            System.out.println("if you want search by product supplier name(leave blanc if wont use this features), insert here the supplier name of the product:");
                                            String searchBySupplier = scanner.next();
                                            System.out.println("decrescent order or crescent order for prodct price(leave blanc if wont use), 1 for decrescent or 0 for crescent");
                                            int crescDecres = scanner.nextInt();

                                            ArrayList<Product> search = new ArrayList<>();

                                            if (!searchByName.isEmpty()){
                                                for (Product product:onlineShop.getOnlineShop()){
                                                    if (product.getName().equals(searchByName)){
                                                        search.add(product);
                                                    }
                                                }
                                            }

                                            if (!searchBySupplier.isEmpty()){
                                                if (search.isEmpty()){
                                                    for (Product product:onlineShop.getOnlineShop()){
                                                        if (product.getSupplier().equals(searchBySupplier)){
                                                            search.add(product);
                                                        }
                                                    }
                                                }
                                                else
                                                {
                                                    search.clear();
                                                    for (Product product:onlineShop.getOnlineShop()){
                                                        if (product.getName().equals(searchByName) && product.getSupplier().equals(searchBySupplier)){
                                                            search.add(product);
                                                        }
                                                    }
                                                }
                                            }

                                            if (crescDecres == 1)
                                            {
                                                search.sort((o1, o2) -> {return (int) (o1.getPrice() - o2.getPrice());});
                                            }

                                            if (crescDecres == 0){


                                            }

                                            break;
                                        case 3:
                                            //add product to cart
                                            //SAMPO IL CONTENUTO DELLO SHOP
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
                case 2:
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
                case 0: System.out.println("QUIT");
                    loop = false;
                    break;
                default: System.out.println("Use a correct choise");
            }
        }












        /*

        //SAMPO IL CONTENUTO DELLO SHOP
        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }


        //AUMENTO LA QUANTITÀ DI UN PRODOTTO(AZIONE ADIBITA A UTENTI WORKER)
        //onlineShop.increaseQuantityOfProduct(a.getId(), 1000);

        //RIDUCO QUANTITÀ(AZIONE ADIBITA A UTENTE WORKER)
        //onlineShop.decreaseQuantityOfProduct(b.getId(), 9);

        System.out.println("STAMPO LA LISTA DI OGGETTI IN NEGOZIO");
        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }


        System.out.println();
        System.out.println();
        System.out.println("Products low in quantity:");
        for (int i = 0; i < onlineShop.getQuantityOfProducts().size(); i++){
            System.out.println(onlineShop.getQuantityOfProducts().get(i));
        }


        user1.getShoppingCart().addProductToShoppingCart(onlineShop.getOnlineShop().get(0) , 2);

        user1.getShoppingCart().addProductToShoppingCart(onlineShop.getOnlineShop().get(2), 10);
        user1.getShoppingCart().addProductToShoppingCart(onlineShop.getOnlineShop().get(5), 20);


        System.out.println();
        System.out.println();
        System.out.println("ShoppingList");
        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }

        System.out.println();
        System.out.println();
        System.out.println("Remove one product from shoppinglist");

        user1.getShoppingCart().removeProductInShoppingCart(a);
        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }

        System.out.println();
        System.out.println();
        System.out.println("increment quantity of one product");
        user1.getShoppingCart().increaseQuantityOfProduct(c.getId(), 15);

        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }

        System.out.println();
        System.out.println();
        System.out.println("decrement quantity of one product");
        user1.getShoppingCart().decreaseQuantityOfProduct(c.getId(), 21);

        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }


        System.out.println();
        System.out.println();
        System.out.println("Purchased");
        try
        {
            user1.purchase(onlineShop, orders);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }


        for (int i = 0; i < orders.getOrderList().size(); i++){
            System.out.println(orders.getOrderList().get(i).getUserName());
            System.out.println(orders.getOrderList().get(i).getProductId());
            System.out.println(orders.getOrderList().get(i).getProductQuantity());
            System.out.println();
            System.out.println();
        }


        System.out.println("cart post purchase");
        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }





        System.out.println("LOW QUANTITY");
        if (!work1.checkLowQuantity(onlineShop).isEmpty()){
            int i = 0;
            for (Product product: work1.checkLowQuantity(onlineShop)){
                System.out.println("Product number: " +  (i));
                System.out.print("Id: " + product.getId() + " - name: ");
                System.out.print(product.getName() + " - supplier: ");
                System.out.print(product.getSupplier() + " - price: ");
                System.out.print(product.getPrice() + " - quantity: ");
                System.out.println(product.getQuantity());
                i++;
            }
        }
        //ASK THE WORKER A INDEX TO MODIFY
        work1.restockLowProducts(onlineShop, 1, 2000);





        System.out.println("Quantitativo di ordini da spedire: " + orders.getOrderList().stream().count());

        OrderToShip app = work1.nextOrder(orders);
        System.out.println(app.getUserName());
        System.out.println(app.getProductId());
        System.out.println(app.getProductQuantity());

        OrderToShip app1 = work1.nextOrder(orders);
        System.out.println(app1.getUserName());
        System.out.println(app1.getProductId());
        System.out.println(app1.getProductQuantity());

        OrderToShip app2 = work1.nextOrder(orders);
        System.out.println(app2.getUserName());
        System.out.println(app2.getProductId());
        System.out.println(app2.getProductQuantity());

         */
    }
}
