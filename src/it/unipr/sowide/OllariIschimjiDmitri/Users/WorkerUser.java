package it.unipr.sowide.OllariIschimjiDmitri.Users;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.OrderToShip;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Orders;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Product;

import java.util.ArrayList;

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

    public ArrayList<Product> checkLowQuantity(OnlineShop onlineShop){
        ArrayList<Product> lowProducts = new ArrayList<>();
        for (Product product: onlineShop.getOnlineShop()){
            if (product.getQuantity() <= 100){
                lowProducts.add(product);
            }
        }

        return lowProducts;
    }

    public OrderToShip nextOrder(Orders orders){
        if (!orders.getOrderList().isEmpty()){
            OrderToShip nextorder = new OrderToShip();
            nextorder = orders.getOrderList().get(0);
            orders.getOrderList().remove(0);
            return nextorder;
        }
        return null;
    }

    public void restockLowProducts(OnlineShop onlineShop, int index, int quantity){
            onlineShop.increaseQuantityOfProduct(index, quantity);
    }
}
