package it.unipr.sowide.OllariIschimjiDmitri.Users;

import it.unipr.sowide.OllariIschimjiDmitri.Store.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ollari Ischimji Dmitri
 * class that is used to create and administrate the worker user and all the functions relate to this user like.
 * - see shopping cart
 * - add to shopping cart
 * - set new users
 * - purchase the products in the cart
 */
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

    /**
     * function to check if the user's cart is not empty and if is not, purchase all the products adding them to the ordersToShip list
     * @param onlineShop shop used to check if the products in the cart of the users are available and if thei are available sand the order
     * @param orders orders list that store all the orders to ship(task for the workers)
     * @throws Exception throwed if the products in the cart is not enough in the store
     */
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

    /**
     * function used to search a product / products in the shop by the products name
     * @param products arraylist of all the products in the shop
     * @param productName string containing the name to search
     * @return an arraylist of all the product that match the string to research.
     */
    public ArrayList<Product> searchByProductName(ArrayList<Product> products, String productName){
        ArrayList<Product> toReturn = new ArrayList<>();

        for (Product pr:products){

            if (pr.getName().toLowerCase().contains(productName.toLowerCase()))
            {
                toReturn.add(pr);
            }
        }
        return toReturn;
    }

    /**
     * function used to search a product by the supplier name
     * @param products list of the products of the shop
     * @param productSupplier name of the supplier to match
     * @return a list of all the product that match the string
     */
    public ArrayList<Product> searchBySupplier(ArrayList<Product> products, String productSupplier){
        ArrayList<Product> toReturn = new ArrayList<>();

        for (Product pr:products){

            if (pr.getSupplier().toLowerCase().contains(productSupplier.toLowerCase()))
            {
                toReturn.add(pr);
            }
        }
        return toReturn;
    }

    /**
     * function toorder all the products by crescent price order
     * @param products all the products
     * @return ordered products arraylist
     */
    public ArrayList<Product> crescentOrder(ArrayList<Product> products){
        Collections.sort(products, new Product());

        return products;
    }

    /**
     * function that order all the products passed by decrescent order for the price
     * @param products all the products passed
     * @return ordered products
     */
    public ArrayList<Product> decrescentOrder(ArrayList<Product> products){
        ArrayList<Product> reverse = crescentOrder(products);
        Collections.reverse(reverse);
        return reverse;
    }
}
