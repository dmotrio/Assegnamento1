package it.unipr.sowide.OllariIschimjiDmitri.Store;

/**
 * @author Ollari Ischimji Dmitri
 * class used to create the object that go inside the Orders arraylist
 * this class is used only like getter and setter function of the order.
 */
public class OrderToShip extends Orders{
    private String userName;
    private String productId;
    private int productQuantity;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
