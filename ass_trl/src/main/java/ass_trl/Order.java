package ass_trl;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
 
@Entity

public class Order {
 
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
 
    @ManyToOne

    private Customer customer;
 
    private String status;
 
    // Getters and Setters

    public int getId() {

        return id;

    }
 
    public void setId(int id) {

        this.id = id;

    }
 
    public Customer getCustomer() {

        return customer;

    }
 
    public void setCustomer(Customer customer) {

        this.customer = customer;

    }
 
    public String getStatus() {

        return status;

    }
 
    public void setStatus(String status) {

        this.status = status;

    }

}

 
