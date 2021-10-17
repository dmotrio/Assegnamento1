package it.unipr.sowide.OllariIschimjiDmitri;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Orders;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Product;
import it.unipr.sowide.OllariIschimjiDmitri.Store.ShoppingCart;
import it.unipr.sowide.OllariIschimjiDmitri.Users.NormalUser;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OnlineShop onlineShop = new OnlineShop();
        Orders orders = new Orders();
        NormalUser user1 = new NormalUser();

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

        user1.getShoppingCart().addProductToShoppingCart(a , 100);
        user1.getShoppingCart().addProductToShoppingCart(a , 100);
        user1.getShoppingCart().addProductToShoppingCart(c, 10);


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
        System.out.println("ShoppingCart");
        user1.purchase(onlineShop, orders);

        for (int i = 0; i < orders.getOrderList().size(); i++){
            System.out.println(orders.getOrderList().get(i).getUserName());
            System.out.println(orders.getOrderList().get(i).getProductId());
            System.out.println(orders.getOrderList().get(i).getProductQuantity());
        }

        System.out.println("carrello post purchase");
        for (int i = 0; i < user1.getShoppingCart().getShoppingCart().size(); i++){
            System.out.println(user1.getShoppingCart().getShoppingCart().get(i).toString());
        }

    }
}
