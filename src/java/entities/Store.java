/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Store implements Serializable {

    private Integer stid;
    private String stname;
    private String stphone;
    private List<Salesman> salesmanCollection;

    public Store() {
    }

    public Store(Integer stid) {
        this.stid = stid;
    }

    public Store(String stname, String stphone) {
        this.stname = stname;
        this.stphone = stphone;
    }

    public Store(Integer stid, String stname) {
        this.stid = stid;
        this.stname = stname;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getStphone() {
        return stphone;
    }

    public void setStphone(String stphone) {
        this.stphone = stphone;
    }

    public List<Salesman> getSalesmanCollection() {
        return salesmanCollection;
    }

    public void setSalesmanCollection(List<Salesman> salesmanCollection) {
        this.salesmanCollection = salesmanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stid != null ? stid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.stid == null && other.stid != null) || (this.stid != null && !this.stid.equals(other.stid))) {
            return false;
        }
        return true;
    }
    
    public void addSalesman(Salesman salesman){
        if(salesmanCollection == null){
            salesmanCollection = new ArrayList();
        }
        salesmanCollection.add(salesman);
    }

    @Override
    public String toString() {
        return "Store{" + "stid=" + stid + ", stname=" + stname + ", stphone=" + stphone + '}';
    }
    
}
