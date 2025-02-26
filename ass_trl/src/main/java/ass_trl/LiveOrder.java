package ass_trl;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
 
@Entity

public class LiveOrder {
 
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
 
    @ManyToOne

    private Item item;
 
    private int qty;
 
    @ManyToOne

    private Order order;
 
    // Getters and Setters

    public int getId() {

        return id;

    }
 
    public void setId(int id) {

        this.id = id;

    }
 
    public Item getItem() {

        return item;

    }
 
    public void setItem(Item item) {

        this.item = item;

    }
 
    public int getQty() {

        return qty;

    }
 
    public void setQty(int qty) {

        this.qty = qty;

    }
 
    public Order getOrder() {

        return order;

    }
 
    public void setOrder(Order order) {

        this.order = order;

    }

}

 