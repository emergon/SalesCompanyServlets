package service;

import dao.CustomerDao;
import entities.Customer;
import java.util.List;

public class CustomerService {
    CustomerDao cdao = new CustomerDao();
    
    
    public List<Customer> getCustomers(){
        return cdao.findAll();
    }
    
    public boolean create(String name){
        Customer c = new Customer(name);
        boolean result = cdao.create(c);
        return result;
    }

    public Customer getCustomerById(int ccode) {
        Customer c = cdao.findById(ccode);
        return c;
    }
    
    public boolean update(int code, String name){
        Customer c = new Customer(code, name);
        boolean result = cdao.update(c);
        return result;
    }
    
    public boolean delete(int code){
        boolean result = cdao.delete(code);
        return result;
    }
}
