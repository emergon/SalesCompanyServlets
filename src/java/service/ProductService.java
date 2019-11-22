/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductDao;
import entities.Product;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class ProductService {
    ProductDao pdao;
    
    public ProductService() {
        pdao = new ProductDao();
    }
    
    public List<Product> getProducts(){
        return pdao.findAll();
    }
    
    public Product getProduct(int id){
        return pdao.findById(id);
    }
    
    public boolean createProduct(String description, double price){
        Product p = new Product(description, price);
        boolean result = pdao.create(p);
        return result;
    }
    
    public boolean deleteProduct(int pcode){
        boolean result = pdao.delete(pcode);
        return result;
    }
    
    public boolean updateProduct(int pcode, String description, double price){
        Product p = new Product(pcode, description, price);
        boolean result = pdao.update(p);
        return result;
    }
}
