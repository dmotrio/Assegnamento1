package it.unipr.sowide.OllariIschimjiDmitri.Users;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.OrderToShip;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Orders;
import it.unipr.sowide.OllariIschimjiDmitri.Store.ShoppingCart;

public class NormalUser {
    private String name;
    private String password;
    private ShoppingCart shoppingCart = new ShoppingCart();

    public NormalUser(){
        this.name = "userTest";
        this.password = "passwordTest";
        
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

    public boolean purchase(OnlineShop onlineShop, Orders orders){
        if (this.shoppingCart.getShoppingCart().isEmpty()){
            return false;
        }
        else
        {
            for (int i = 0; i < this.shoppingCart.getShoppingCart().size(); i++){
                for (int j = 0; j < onlineShop.getOnlineShop().size(); j++){
                    String idInCart = this.shoppingCart.getShoppingCart().get(i).getId();
                    String idInStore = onlineShop.getOnlineShop().get(j).getId();

                    if (idInCart == idInStore){
                        int quantityInCart = this.shoppingCart.getShoppingCart().get(i).getQuantity();
                        int quantityInShop = onlineShop.getOnlineShop().get(j).getQuantity();

                        if (quantityInShop < quantityInCart){
                            return false;
                        }
                        else
                        {
                            OrderToShip orderToShip = new OrderToShip();
                            orderToShip.setUserName(getName());
                            orderToShip.setProductId(this.shoppingCart.getShoppingCart().get(i).getId());
                            orderToShip.setProductQuantity(this.shoppingCart.getShoppingCart().get(i).getQuantity());
                            orders.addToOrders(orderToShip);
                            shoppingCart.getShoppingCart().clear();
                            break;
                        }
                    }
                }
            }

            return true;
        }
    }

}
