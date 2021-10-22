package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.ArrayList;

/**
 * @author Ollari Ischimji Dmitri
 * class used to store all the orders from the users
 */
public class Orders {
    private final ArrayList<OrderToShip> orderList = new ArrayList<>();

    /**
     * get all the orders
     * @return an araaylist of all the orders
     */
    public ArrayList<OrderToShip> getOrderList() {
        return orderList;
    }

    /**
     * add order to the orderlist
     * @param orderToShip is a class that rapresent the product id, quantity ordered and username of the buyer
     */
    public void addToOrders(OrderToShip orderToShip){

        this.orderList.add(orderToShip);
    }
}
