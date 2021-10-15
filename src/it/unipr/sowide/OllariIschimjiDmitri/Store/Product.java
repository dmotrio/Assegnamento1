package it.unipr.sowide.OllariIschimjiDmitri.Store;

import java.util.UUID;

public class Product implements Comparable<Product> {
    private final String uniqueID;
    private String name;
    private String supplier;
    private float price;
    private int quantity;

    public Product(){
        this.uniqueID = UUID.randomUUID().toString();
        this.name = "name";
        this.supplier = "supplier";
        this.price = 0.0f;
        this.quantity = 0;
    }

    public Product(String name, String supplier, float price, int quantity){
        this.uniqueID = UUID.randomUUID().toString();
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    @Override
    public int compareTo(Product o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}
