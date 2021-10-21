package it.unipr.sowide.OllariIschimjiDmitri.Users;

import it.unipr.sowide.OllariIschimjiDmitri.Store.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalUser {
    private String name;
    private String password;
    private ShoppingCart shoppingCart = new ShoppingCart();

    public NormalUser(){
        this.name = "userTest";
        this.password = "passwordTest";
        
    }
    public NormalUser(String name, String password){
        this.name = name;
        this.password = password;

    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void purchase(OnlineShop onlineShop, Orders orders) throws Exception {
        int shoppingListSize = this.shoppingCart.getShoppingCart().size();

            for(Product prInShop: onlineShop.getOnlineShop()){
                for (Product prInCart: this.shoppingCart.getShoppingCart()){
                    if (prInCart.getId().equals(prInShop.getId()))
                        if (prInCart.getQuantity() > prInShop.getQuantity())
                            throw new Exception("Not enough products in the store.");
                }
            }

            for(Product prInShop: onlineShop.getOnlineShop()){
                for (Product prInCart: this.shoppingCart.getShoppingCart()){
                    if (prInCart.getId().equals(prInShop.getId())){
                        OrderToShip demo = new OrderToShip();
                        demo.setUserName(this.getName());
                        demo.setProductId(prInCart.getId());
                        demo.setProductQuantity(prInCart.getQuantity());
                        orders.addToOrders(demo);
                        int i = onlineShop.getOnlineShop().indexOf(prInShop);
                        onlineShop.getOnlineShop().get(i).setQuantity(prInShop.getQuantity() - prInCart.getQuantity());
                    }
                }
            }
            this.getShoppingCart().getShoppingCart().clear();
    }

    public ArrayList<Product> searchByProductName(ArrayList<Product> products, String productName){
        ArrayList<Product> toReturn = new ArrayList<>();
        Pattern p = Pattern.compile("\\b(?:" + productName + ")\\b", Pattern.CASE_INSENSITIVE);
        for (Product pr:products){
            Matcher m = p.matcher(pr.getName());
            if (m.matches())
            {
                toReturn.add(pr);
            }
        }
        return toReturn;
    }

    public ArrayList<Product> searchBySupplier(ArrayList<Product> products, String productSupplier){
        ArrayList<Product> toReturn = new ArrayList<>();
        Pattern p = Pattern.compile(productSupplier, Pattern.CASE_INSENSITIVE);
        for (Product pr:products){
            Matcher m = p.matcher(pr.getSupplier());
            if (m.matches())
            {
                toReturn.add(pr);
            }
        }
        return toReturn;
    }

    public ArrayList<Product> crescentOrder(ArrayList<Product> products){
        products.sort(Comparator.comparingDouble(Product::getQuantity));
        return products;
    }

    public ArrayList<Product> decrescentOrder(ArrayList<Product> products){
        ArrayList<Product> reverse = crescentOrder(products);
        Collections.reverse(reverse);
        return reverse;
    }
}
