package it.unipr.sowide.OllariIschimjiDmitri.Store;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCart {
    private ArrayList<Product> shoppingCart = new ArrayList<>();

    public ShoppingCart(){}

    public void addProductToShoppingCart(Product productToAddInCart, int quantity){
        if (shoppingCart.isEmpty()){
            productToAddInCart.setQuantity(quantity);
            shoppingCart.add(productToAddInCart);
        }
        else
        {
            for (Product productAlreadyInCart : shoppingCart) {
                String idAlreadyInCart = productAlreadyInCart.getId();
                String idNewProduct = productToAddInCart.getId();
                if (idAlreadyInCart == idNewProduct) {
                    int oldQuantity = productAlreadyInCart.getQuantity();
                    productAlreadyInCart.setQuantity(oldQuantity + quantity);
                }
                else
                {
                    productToAddInCart.setQuantity(quantity);
                    shoppingCart.add(productToAddInCart);
                    break;
                }
            }
        }
    }

    /**
     *Used to remove a product from the shopping list
     * @param productToRemove object to remove from the shopping cart of the user
     * @return true if the product was found and modified
     * and return false if the product wasn't found in the shopping list.
     */
    public boolean removeProductInShoppingCart(Product productToRemove) {
        for (Product productToDelete : shoppingCart) {
            if (Objects.equals(productToRemove.getId(), productToDelete.getId())) {
                shoppingCart.remove(productToDelete);
                return true;
            }
        }
        return false;
    }

    /**
     *Used to increase the quantity of a product in the shopping list
     * @param id id of the product
     * @param quantity quantity to add at the actual quantity in the cart
     * @return true if the product was found and modified
     * and return false if the product wasn't found in the shopping list.
     */
    public boolean increaseQuantityOfProduct(String id, int quantity){


        for (Product product : shoppingCart) {
            String idAlreadyInCart = product.getId();

            if (idAlreadyInCart == id) {
                int oldQuantity = product.getQuantity();
                product.setQuantity(oldQuantity + quantity);
                return true;
            }
        }
        return false;
    }

    /**
     *Used to increase the quantity of a product in the shopping list
     * @param id id of the product
     * @param quantity quantity to subtract at the actual quantity in the cart
     * @return true if the product was found and modified
     * and return false if the product wasn't found in the shopping list
     * or if the subtraction cause a negative number in the quantity field
     */
    public boolean decreaseQuantityOfProduct(String id, int quantity){
        for (Product product : shoppingCart) {
            String alreadyInCart = product.getId();
            if (alreadyInCart == id) {
                int oldQuantity = product.getQuantity();
                if (oldQuantity < quantity){
                    return false;
                }else if (oldQuantity == quantity){
                    shoppingCart.remove(product);
                    return true;
                }else if(oldQuantity > quantity){
                    product.setQuantity(oldQuantity - quantity);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }



    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCart=" + shoppingCart +
                '}';
    }
}
