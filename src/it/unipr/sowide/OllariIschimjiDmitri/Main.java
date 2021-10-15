package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Orders;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Product;
import it.unipr.sowide.OllariIschimjiDmitri.Store.ShoppingCart;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OnlineShop onlineShop = new OnlineShop();
        ShoppingCart shoppingCart = new ShoppingCart();
        Orders orders = new Orders();

        Product a = new Product("iphone1", "apple", 123.4f, 100);
        Product b = new Product("iphone2", "apple", 123.4f, 10);
        Product c = new Product("iphone3", "apple", 123.4f, 50);

        onlineShop.addProductToShop(a);
        onlineShop.addProductToShop(b);
        onlineShop.addProductToShop(c);

        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }
        System.out.println();
        System.out.println("Updated");
        System.out.println();

        onlineShop.increaseQuantityOfProduct(a.getId(), 1000);

        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }

        System.out.println();
        System.out.println("Updated");
        System.out.println();

        onlineShop.decreaseQuantityOfProduct(b.getId(), 9);

        for (int i = 0; i < onlineShop.getSize(); i++){
            System.out.println(onlineShop.getOnlineShop().get(i).toString());
        }

        System.out.println();
        System.out.println();
        System.out.println("Products low in quantity");
        for (int i = 0; i < onlineShop.getQuantityOfProducts().size(); i++){
            System.out.println(onlineShop.getQuantityOfProducts().get(i));
        }

        shoppingCart.addProductToShoppingCart(a, 100);
        shoppingCart.addProductToShoppingCart(c, 10);

        System.out.println();
        System.out.println();
        System.out.println("ShoppingList");
        for (int i = 0; i < shoppingCart.getShoppingCart().size(); i++){
            System.out.println(shoppingCart.getShoppingCart().get(i).toString());
        }
    }
}
