package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.ArrayList;
import java.util.Objects;

public class Orders {
    private final ArrayList<ShoppingCart> orderList = new ArrayList<>();

    public boolean placeOrder(ShoppingCart shoppingCart){
        OnlineShop onlineShop = new OnlineShop();
        for(int i = 0; i < shoppingCart.getShoppingCart().size(); i++){
            for (int j = 0; j < onlineShop.getOnlineShop().size(); j++){
                if (Objects.equals(shoppingCart.getShoppingCart().get(i).getId(), onlineShop.getOnlineShop().get(j).getId())){
                    int shoppCartQuantity = shoppingCart.getShoppingCart().get(i).getQuantity();
                    int onlineShopQuantity = onlineShop.getOnlineShop().get(j).getQuantity();
                    if (shoppCartQuantity <= onlineShopQuantity){
                        onlineShop.getOnlineShop().get(j).setQuantity(onlineShopQuantity - shoppCartQuantity);

                    }
                    else{
                        return false;
                    }
                }
            }
        }
        orderList.add(shoppingCart);
        return true;
    }
}
