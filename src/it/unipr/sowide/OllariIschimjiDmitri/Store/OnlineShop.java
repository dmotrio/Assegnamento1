package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Ollari Ischimji Dmitri
 * this class is used to store all the product
 */
public class OnlineShop {
    private final ArrayList<Product> onlineShop = new ArrayList<>();

    /**
     * Add product to the shop arraylist
     * @param a rapresent the product to add
     */
    public void addProductToShop(Product a){
        onlineShop.add(a);
    }

    /**
     * function used to increese the quantity of a product stored in the onlineShop arraylist
     * @param index is the index of the product
     * @param quantity is the quantity to add to the current quantity in the shop
     */
    public void increaseQuantityOfProduct(int index, int quantity){
        int oldQuantity = this.onlineShop.get(index).getQuantity();
        this.onlineShop.get(index).setQuantity(oldQuantity + quantity);
    }

    /**
     * function to decrease the quantity of a product stored in the onlineshop arraylist
     * @param id the unique id of the product to decrease in quantity
     * @param quantity the quantity to subtract to the current quantity
     * @return true if the decrease is successful and false if not
     */
    public boolean decreaseQuantityOfProduct(String id, int quantity){


        for (Product product : onlineShop) {
            if (Objects.equals(product.getId(), id)) {
                int oldQuantity = product.getQuantity();
                product.setQuantity(oldQuantity - quantity);
                return true;
            }
        }
        return false;
    }

    /**
     * remove product function
     * @param index of the product to remove
     * @param onlineShop is the onlineshop to lock in for the product to delete
     */
    public void removeProduct (int index, OnlineShop onlineShop){
        onlineShop.getOnlineShop().remove(index);
    }

    /**
     * get sie function
     * @return size
     */
    public int getSize(){
        return onlineShop.size();
    }

    /**
     * return the arreylist that contain all the product
     * @return all products in arraylist type
     */
    public ArrayList<Product> getOnlineShop() {
        return onlineShop;
    }
}
