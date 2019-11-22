package entities;

import java.time.LocalDate;

public class Sale {
    
    private int scode;
    private Salesman salesman;
    private Customer customer;
    private Product product;
    private int quantity;
    private double cost;
    private LocalDate date;

    public Sale() {
    }

    public Sale(int scode, Salesman salesman, Customer customer, Product product, int quantity, double cost, LocalDate date) {
        this.scode = scode;
        this.salesman = salesman;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.date = date;
    }

    public Sale(Salesman salesman, Customer customer, Product product, int quantity, double cost, LocalDate date) {
        this.salesman = salesman;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
        this.date = date;
    }

    

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Sale{" + "scode=" + scode + ", product=" + product + ", date=" + date + ", customer=" + customer + ", salesman=" + salesman + ", quantity=" + quantity + ", cost=" + cost + '}';
    }
    
}
