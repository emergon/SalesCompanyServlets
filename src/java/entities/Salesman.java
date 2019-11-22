package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Salesman {

    private int scode;
    private String name;
    private String city;
    private double commission;
    private List<Sale> sales;
    private List<Family> family;
    private List<Store> stores;
    
    public Salesman() {
    }

    public Salesman(String name, String city, double commission) {
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public Salesman(int scode, String name, String city, double commission) {
        this.scode = scode;
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    public void addFamilyMember(Family member){
        if(family == null){
            family = new ArrayList();
        }
        family.add(member);
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
 
    public void addStore(Store store){
        if(stores == null){
            stores = new ArrayList();
        }
        stores.add(store);
    }
    @Override
    public String toString() {
        return "Salesman{" + "scode=" + scode + ", name=" + name + ", city=" + city + ", commission=" + commission + '}';
    }

}
