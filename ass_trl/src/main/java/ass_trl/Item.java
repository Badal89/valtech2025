package ass_trl;


 
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
 
@Entity

public class Item {
 
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;

    private String name;

    private String description;

    private int quantity;

    private int reorderQuantity;

    private int maxQuantity;
 
    // Getters and Setters

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
 
    public String getDescription() {

        return description;

    }
 
    public void setDescription(String description) {

        this.description = description;

    }
 
    public int getQuantity() {

        return quantity;

    }
 
    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }
 
    public int getReorderQuantity() {

        return reorderQuantity;

    }
 
    public void setReorderQuantity(int reorderQuantity) {

        this.reorderQuantity = reorderQuantity;

    }
 
    public int getMaxQuantity() {

        return maxQuantity;

    }
 
    public void setMaxQuantity(int maxQuantity) {

        this.maxQuantity = maxQuantity;

    }

}

 