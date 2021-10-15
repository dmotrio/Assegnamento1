package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.ArrayList;
import java.util.Objects;

public class OnlineShop {
    private final ArrayList<Product> onlineShop = new ArrayList<>();

    public void addProductToShop(Product a){
        onlineShop.add(a);
    }

    public void increaseQuantityOfProduct(String id, int quantity){


        for (Product product : onlineShop) {
            if (Objects.equals(product.getId(), id)) {
                int oldQuantity = product.getQuantity();
                product.setQuantity(oldQuantity + quantity);
            }
        }

    }

    public void decreaseQuantityOfProduct(String id, int quantity){


        for (Product product : onlineShop) {
            if (Objects.equals(product.getId(), id)) {
                int oldQuantity = product.getQuantity();
                product.setQuantity(oldQuantity - quantity);
            }
        }

    }

    public ArrayList<Product> getQuantityOfProducts(){
        ArrayList<Product> productsLowInQuantity = new ArrayList<>();

        for (Product product : onlineShop) {
            if (product.getQuantity() < 10) {
                productsLowInQuantity.add(product);
            }
        }
        return productsLowInQuantity;
    }

    public int getSize(){
        return onlineShop.size();
    }

    public ArrayList<Product> getOnlineShop() {
        return onlineShop;
    }
}
