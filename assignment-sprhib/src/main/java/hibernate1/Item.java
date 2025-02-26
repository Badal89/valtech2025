package hibernate1;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1)
	private long id;
	private String name;
	private String description;
	private int quantity;
	private int reorder_Quantity;
	private int max_Quantity;

	
	private Set<Order> orders;
	
	
	public Item() {
		
	}

	public Item(String name, String description, int quantity, int reorder_Quantity, int max_Quantity) {
		
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorder_Quantity = reorder_Quantity;
		this.max_Quantity = max_Quantity;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getReorder_Quantity() {
		return reorder_Quantity;
	}
	public void setReorder_Quantity(int reorder_Quantity) {
		this.reorder_Quantity = reorder_Quantity;
	}
	public int getMax_Quantity() {
		return max_Quantity;
	}
	public void setMax_Quantity(int max_Quantity) {
		this.max_Quantity = max_Quantity;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorder_Quantity=" + reorder_Quantity + ", max_Quantity=" + max_Quantity + ", orders=" + orders
				+ "]";
	}
	
	
	
	
	
	

}
