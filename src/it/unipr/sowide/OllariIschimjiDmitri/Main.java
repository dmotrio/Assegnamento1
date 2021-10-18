package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.*;
import it.unipr.sowide.OllariIschimjiDmitri.Users.NormalUser;
import it.unipr.sowide.OllariIschimjiDmitri.Users.WorkerUser;

public class Main {

    public static void main(String[] args) {
	/*
	* creo i due oggetti alla base di tutto che sono lo shop e la lista degli ordini.
	* Dopo di che con la programmazione sequenziale, dovrò creare gli utenti mediante un utente login hardcoded
	*
	*/
        OnlineShop onlineShop = new OnlineShop();
        Orders orders = new Orders();
        NormalUser user1 = new NormalUser();
        WorkerUser work1 = new WorkerUser();

        //CREO DIECI PRODOTTI
        Product a = new Product("LavatriceX", "Brandfamoso", 999.99f, 1000);
        Product b = new Product("Iphone9", "apple", 999.99f, 10000);
        Product c = new Product("PC", "lenovo", 1234.56f, 5000);
        Product d = new Product("LavatriceY", "arcTAN", 999.99f, 99);
        Product e = new Product("OnePlus9", "OnePlus", 999.99f, 250);
        Product f = new Product("PC-gaming", "lenovo", 1234.56f, 5000);
        Product g = new Product("LavatriceKSG", "KSG", 345.99f, 100000);
        Product h = new Product("Iphone99", "apple", 999.99f, 10000);
        Product k = new Product("Laptop", "MSI", 900.56f, 199);
        Product l = new Product("LavatriceQWERTY", "BrandMenoFamoso", 100.99f, 100);

        //INSERISCO I DIECI PRODOTTI NELLO SHOP
        onlineShop.addProductToShop(a);
        onlineShop.addProductToShop(b);
        onlineShop.addProductToShop(c);
        onlineShop.addProductToShop(d);
        onlineShop.addProductToShop(e);
        onlineShop.addProductToShop(f);
        onlineShop.addProductToShop(g);
        onlineShop.addProductToShop(h);
        onlineShop.addProductToShop(k);
        onlineShop.addProductToShop(l);



        /*
        //SAMPO IL CONTENUTO DELLO SHOP
        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }
         */

        //AUMENTO LA QUANTITÀ DI UN PRODOTTO(AZIONE ADIBITA A UTENTI WORKER)
        //onlineShop.increaseQuantityOfProduct(a.getId(), 1000);

        //RIDUCO QUANTITÀ(AZIONE ADIBITA A UTENTE WORKER)
        //onlineShop.decreaseQuantityOfProduct(b.getId(), 9);

        System.out.println("STAMPO LA LISTA DI OGGETTI IN NEGOZIO");
        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }

        /*
        System.out.println();
        System.out.println();
        System.out.println("Products low in quantity:");
        for (int i = 0; i < onlineShop.getQuantityOfProducts().size(); i++){
            System.out.println(onlineShop.getQuantityOfProducts().get(i));
        }
         */

        user1.getShoppingCart().addProductToShoppingCart(a , 2);

        user1.getShoppingCart().addProductToShoppingCart(c, 10);
        user1.getShoppingCart().addProductToShoppingCart(k, 20);


        System.out.println();
        System.out.println();
        System.out.println("ShoppingList");
        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }
        /*
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
         */

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

        /*
        System.out.println("cart post purchase");
        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }
         */

        /*
        System.out.println("LOW QUANTITY");
        if (!work1.checkLowQuantity(onlineShop).isEmpty()){
            for (Product product: work1.checkLowQuantity(onlineShop)){
                System.out.println(product.getId());
                System.out.println(product.getName());
                System.out.println(product.getSupplier());
                System.out.println(product.getPrice());
                System.out.println(product.getQuantity());
            }
        }
         */

        /*
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
