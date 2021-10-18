package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.UUID;

/**
 * @author Ollari Ischimji Dmitri
 * This class is used to emulate the fisical products in a store and is used to populate
 * the store itself.
 */
public class Product implements Comparable<Product> {
    private String uniqueID;
    private String name;
    private String supplier;
    private float price;
    private int quantity;

    /**
     * default constructor for the Product class
     */
    public Product(){
        this.uniqueID = UUID.randomUUID().toString();
        this.name = "name";
        this.supplier = "supplier";
        this.price = 0.0f;
        this.quantity = 0;
    }

    /**
     * Constructor of the class
     * @param name represent the name of the product
     * @param supplier represent the supplier of the product
     * @param price represent the price of the product
     * @param quantity rapresent the quantity of the product
     */
    public Product(String name, String supplier, float price, int quantity){
        this.uniqueID = UUID.randomUUID().toString();
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Method used to get the id of the product
     * @return a string populated by UUID object that generate random Unique User identifier.
     */
    public String getId() {
        return uniqueID;
    }

    public void setId(String id){
        this.uniqueID = id;
    }

    /**
     * getter function of the name parameter
     * @return a string with the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * setter function of the name parameter
     * @param name string that contain the name of product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter function of the supplier parameter
     * @return a String with the product supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * setter function of the supplier parameter
     * @param supplier string that contain the supplier of the product
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * getter function of the price parameter
     * @return a flot with price of the product
     */
    public float getPrice() {
        return price;
    }

    /**
     * setter function of the price parameter
     * @param price float that contain the price of the product
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * getter function of the quantity parameter
     * @return int with the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * setter function of the quantity parameter
     * @param quantity int that contain the quantity of the product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * method used to represent all the parameter of the object in one string to display easily
     * @return String to print all the info about the object
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + uniqueID +
                ", name='" + name + '\'' +
                ", supplier='" + supplier + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    /**
     * Method used to compare two objects using the price
     * needed to perform sorting function.
     * @param o new object created by the class Product used for confronting the prices.
     * @return 1 if the first object is greater,
     *         0 if the two objects are the same
     *         -1 if the second object is grater than the first.
     */
    @Override
    public int compareTo(Product o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}
