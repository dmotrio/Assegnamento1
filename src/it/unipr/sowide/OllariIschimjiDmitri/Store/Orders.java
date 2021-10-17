package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.ArrayList;
import java.util.Objects;

public class Orders {
    private final ArrayList<OrderToShip> orderList = new ArrayList<>();


    public ArrayList<OrderToShip> getOrderList() {
        return orderList;
    }

    public void addToOrders(OrderToShip orderToShip){

        this.orderList.add(orderToShip);
    }
}
