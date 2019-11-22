package entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Family {
    private int id;
    private String name;
    private String relationship;
    private LocalDate dob;
    private Salesman salesman;
    
    public Family() {
    }

    public Family(int id, String name, String relationship, LocalDate dob, Salesman salesman) {
        this.id = id;
        this.name = name;
        this.relationship = relationship;
        this.dob = dob;
        this.salesman = salesman;
    }

    public Family(int id, String name, String relationship, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.relationship = relationship;
        this.dob = dob;
    }

    public Family(String name, String relationship, LocalDate dob, Salesman salesman) {
        this.name = name;
        this.relationship = relationship;
        this.dob = dob;
        this.salesman = salesman;
    }

    
    

    public Family(String name, String relationship, LocalDate dob) {
        this.name = name;
        this.relationship = relationship;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "Family{" + "id=" + id + ", name=" + name + ", relationship=" + relationship + ", dob=" + dob + '}';
    }
    
}
