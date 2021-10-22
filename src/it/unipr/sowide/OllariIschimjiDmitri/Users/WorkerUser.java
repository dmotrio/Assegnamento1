package it.unipr.sowide.OllariIschimjiDmitri.Users;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.OrderToShip;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Orders;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Product;

import java.util.ArrayList;

/**
 * @author Ollari Ischimji Dmitri
 * class used to create the workers and administrate all the workers functions.
 */
public class WorkerUser {
    private String name;
    private String password;

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
     *function used to check if a product is low in quantity
     * @param onlineShop shop were check the quantities
     * @return arraylist of all the objects below the low quantity range(for this exapmle 100 products)
     */
    public ArrayList<Product> checkLowQuantity(OnlineShop onlineShop){
        ArrayList<Product> lowProducts = new ArrayList<>();
        for (Product product: onlineShop.getOnlineShop()){
            if (product.getQuantity() <= 100){
                lowProducts.add(product);
            }
        }

        return lowProducts;
    }

    /**
     * function used to ship one order to the customer
     * @param orders is the arraylist that contain all the orders by the users
     * @return a single order to ship
     */
    public OrderToShip nextOrder(Orders orders){
        if (!orders.getOrderList().isEmpty()){
            OrderToShip nextorder = new OrderToShip();
            nextorder = orders.getOrderList().get(0);
            orders.getOrderList().remove(0);
            return nextorder;
        }
        return null;
    }

    /**
     * function used after the check low quantity, used to restock a single product
     * @param onlineShop the shop were the product is stored
     * @param index the product index in  the products arralist
     * @param quantity quantity to add to the product in the shop.
     */
    public void restockLowProducts(OnlineShop onlineShop, int index, int quantity){
            onlineShop.increaseQuantityOfProduct(index, quantity);
    }
}
