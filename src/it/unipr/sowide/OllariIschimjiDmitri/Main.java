package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.*;
import it.unipr.sowide.OllariIschimjiDmitri.Users.Admin;
import it.unipr.sowide.OllariIschimjiDmitri.Users.NormalUser;
import it.unipr.sowide.OllariIschimjiDmitri.Users.WorkerUser;

import java.io.IOException;
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

        Admin admin = new Admin(onlineShop);
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop){
            System.out.println("Select one option: \n1 - login\n2 - register\n0 - Quit program");
            int choice = scanner.nextInt();

            switch (choice){
                case 1: System.out.println("login");
                        break;
                case 2: System.out.println("register");
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
