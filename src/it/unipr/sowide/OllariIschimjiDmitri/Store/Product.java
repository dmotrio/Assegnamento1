package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.Comparator;
import java.util.UUID;

/**
 * @author Ollari Ischimji Dmitri
 * This class is used to emulate the fisical products in a store and is used to populate
 * the store itself.
 */
public class Product implements Comparator<Product> {
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
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * <p>
     * The implementor must ensure that {@link Integer#signum
     * signum}{@code (compare(x, y)) == -signum(compare(y, x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * compare(x, y)} must throw an exception if and only if {@code
     * compare(y, x)} throws an exception.)<p>
     * <p>
     * The implementor must also ensure that the relation is transitive:
     * {@code ((compare(x, y)>0) && (compare(y, z)>0))} implies
     * {@code compare(x, z)>0}.<p>
     * <p>
     * Finally, the implementor must ensure that {@code compare(x,
     * y)==0} implies that {@code signum(compare(x,
     * z))==signum(compare(y, z))} for all {@code z}.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     * @apiNote It is generally the case, but <i>not</i> strictly required that
     * {@code (compare(x, y)==0) == (x.equals(y))}.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     */
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
