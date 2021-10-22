package it.unipr.sowide.OllariIschimjiDmitri.Users;

import it.unipr.sowide.OllariIschimjiDmitri.Store.OnlineShop;
import it.unipr.sowide.OllariIschimjiDmitri.Store.Product;

import java.util.ArrayList;

/**
 * @author Ollari Ischimji Dmitri
 * This class is used to create the admin user and to crete the first 10 sample product to populate the shop.
 * this class can create worker users, delete worker users, add product to he shop and remove product from the shop.
 *
 */
public class Admin {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    /**
     * function used to create worker account
     * @param name rappresent the name for the user
     * @param password rappresent the password for the user
     * @param workers is an arraylist where all the workers account were stored.
     */
    public void createNewWorker(String name, String password, ArrayList<WorkerUser> workers){
        WorkerUser work = new WorkerUser();
        work.setName(name);
        work.setPassword(password);
        workers.add(work);
    }

    /**
     * function used to delete worker account
     * @param work is the object that rapresent the account
     * @param workers is the arraylist that contains all the workers
     * @throws Exception throw an exception if the class passed to delete is not in the workers arraylist
     */
    public void removeWorker(WorkerUser work, ArrayList<WorkerUser> workers) throws Exception {
        if (workers.contains(work)){
            workers.remove(work);
        }
        else
        {
            throw new Exception("Not in worker users");
        }
    }

    /**
     * default sample of all the product to instance at the startup
     * @param onlineShop object that rapresent the store that contains all the products.
     */
    public Admin(OnlineShop onlineShop) {
        this.name = "Admin";
        this.password = "Admin";

        //CREO DIECI PRODOTTI
        Product a = new Product("LavatriceX", "Brandfamoso", 1.99f, 1000);
        Product b = new Product("Iphone9", "apple", 5.99f, 10000);
        Product c = new Product("PC", "msi", 1234.56f, 5000);
        Product d = new Product("LavatriceY", "arcTAN", 9.99f, 99);
        Product e = new Product("OnePlus9", "OnePlus", 99.99f, 250);
        Product f = new Product("PC-gaming", "lenovo", 14.56f, 5000);
        Product g = new Product("LavatriceKSG", "KSG", 345.99f, 100000);
        Product h = new Product("Iphone99", "apple", 50.99f, 10000);
        Product k = new Product("Laptop", "MSI", 10000.56f, 199);
        Product l = new Product("LavatriceQWERTY", "BrandMenoFamoso", 100.99f, 100);

        //INSERISCO I DIECI PRODOTTI NELLO SHOP
        onlineShop.addProductToShop(a);
        onlineShop.addProductToShop(b);
        onlineShop.addProductToShop(c);
        onlineShop.addProductToShop(d);
        onlineShop.addProductToShop(e);
        onlineShop.addProductToShop(f);
        onlineShop.addProductToShop(g);
        onlineShop.addProductToShop(h);
        onlineShop.addProductToShop(k);
        onlineShop.addProductToShop(l);
    }

    /**
     * function used to add new products to the catalog of the shop
     * @param onlineShop is the shop (in case this sistem is used to mantein multiple shops) were add the products
     * @param product is the new product to add in the shop.
     */
    public void newProductInShop(OnlineShop onlineShop, Product product){
        onlineShop.getOnlineShop().add(product);
    }

    /**
     * function used to remove products from the catalog of the shop
     * @param onlineShop is the shop (in case this sistem is used to mantein multiple shops) were remove the products
     * @param productId is the product to remove from the shop.
     */
    public void removeProduct(OnlineShop onlineShop, String productId){
        for(Product product: onlineShop.getOnlineShop()){
            if (product.getId().equals(productId)){
                onlineShop.getOnlineShop().remove(product);
                break;
            }
        }
    }
}
