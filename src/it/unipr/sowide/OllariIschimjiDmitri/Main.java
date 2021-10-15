package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Product;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OnlineShop onlineShop = new OnlineShop();

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

    }
}
