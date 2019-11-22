/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FamilyDao;
import entities.Family;
import entities.Salesman;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anastasios
 */
public class FamilyService {
    private FamilyDao fdao;

    public FamilyService() {
        fdao = new FamilyDao();
    }

    public boolean deleteFamilyById(int code) {
         boolean result = fdao.delete(code);
         return result;
    }
    
    public boolean createFamily(String name, String relation, String dob, int scode ){
        Salesman s = new Salesman();
        s.setScode(scode);
        Family f = new Family(name, relation, getDateFromString(dob), s);
        boolean result = fdao.create(f);
        return result;
    }
    
    
    public LocalDate getDateFromString(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
    
}
