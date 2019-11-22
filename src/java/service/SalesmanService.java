/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FamilyDao;
import dao.SalesmanDao;
import entities.Family;
import entities.Salesman;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class SalesmanService {

    private SalesmanDao sdao;

    public SalesmanService() {
        this.sdao = new SalesmanDao();
    }

    public List<Salesman> getSalesmen() {
        return sdao.findAll();
    }

    public boolean createSalesman(String name, String city, double comm) {
        Salesman s = new Salesman(name, city, comm);
        boolean result = sdao.create(s);
        return result;
    }

    public Salesman getSalesmanById(int code) {
        return sdao.findById(code);
    }

    public boolean updateSalesman(int code, String name, String city, double commission) {
        Salesman s = new Salesman(code, name, city, commission);
        boolean result = sdao.update(s);
        return result;
    }

    public boolean deleteSalesmanById(int code) {
        boolean result = sdao.delete(code);
        return result;
    }

    public Salesman getSalesmanWithFamily(int code) {
        FamilyDao fdao = new FamilyDao();
        Salesman s = sdao.findById(code);
        List<Family> family = fdao.findAllBySalesman(s.getScode());
        s.setFamily(family);
        System.out.println("************family of"+s+"==="+family);
        return s;
    }
}
