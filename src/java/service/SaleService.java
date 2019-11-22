package service;

import dao.CustomerDao;
import dao.ProductDao;
import dao.SaleDao;
import dao.SalesmanDao;
import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.Salesman;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class SaleService {

    private SaleDao sldao;

    public SaleService() {
        sldao = new SaleDao();
    }

    public List<Sale> getSales() {
        List<Sale> list = sldao.findAll();
        return list;
    }

    public List<Salesman> listOfSalesman() {
        SalesmanDao sdao = new SalesmanDao();
        return sdao.findAll();
    }

    public List<Customer> listOfCustomer() {
        CustomerDao cdao = new CustomerDao();
        return cdao.findAll();
    }

    public List<Product> listOfProduct() {
        ProductDao pdao = new ProductDao();
        return pdao.findAll();
    }

    public boolean createSale(Map<String, String[]> parameterMap) {
        int salesman = Integer.parseInt(parameterMap.get("salesman")[0]);
        int customer = Integer.parseInt(parameterMap.get("customer")[0]);
        int product = Integer.parseInt(parameterMap.get("product")[0]);
        int quant = Integer.parseInt(parameterMap.get("quant")[0]);
        double cost = Double.parseDouble(parameterMap.get("cost")[0]);
        LocalDate date = getDateFromString(parameterMap.get("date")[0]);
        System.out.println(salesman);
        System.out.println(customer);
        System.out.println(product);
        System.out.println(quant);
        System.out.println(cost);
        System.out.println(date);
        boolean result = sldao.create(salesman, customer, product, quant, cost, date);
        return result;
    }
    
    public LocalDate getDateFromString(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
    
}
