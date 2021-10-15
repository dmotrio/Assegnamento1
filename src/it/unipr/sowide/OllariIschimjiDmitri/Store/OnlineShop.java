package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.ArrayList;

public class OnlineShop {
    private final ArrayList<Product> onlineShop = new ArrayList<Product>();

    public void addProductToShop(Product a){
        onlineShop.add(a);
    }

    public void increaseQuantityOfProduct(String id, int quantity){


            for (int i = 0; i < onlineShop.size(); i++){
                if (onlineShop.get(i).getId() == id){
                    int oldQuantity = onlineShop.get(i).getQuantity();
                    onlineShop.get(i).setQuantity(oldQuantity + quantity);
                }
            }

    }

    public int getSize(){
        return onlineShop.size();
    }

    public ArrayList<Product> getOnlineShop() {
        return onlineShop;
    }
}
