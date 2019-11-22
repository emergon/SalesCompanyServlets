package entities;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    
    private int pcode;
    private String description;
    private double price;
    private List<Sale> sales;
    
    public Product() {
    }

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Product(int pcode, String description, double price) {
        this.pcode = pcode;
        this.description = description;
        this.price = price;
    }

    
    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Sale> getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", description=" + description + ", price=" + price + '}';
    }
    
    
}
