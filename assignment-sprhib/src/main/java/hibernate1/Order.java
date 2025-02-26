package hibernate1;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	private Customer1 customer;
	
	private enum status{
		BOOKED,DISPATCHED,DELIVERED
	};
	
	@ManyToMany
    @JoinTable(
        name = "order_items",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
	private Set<Item> items;


	
	
	public Order(){
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Customer1 getCustomer() {
		return customer;
	}




	public void setCustomer(Customer1 customer) {
		this.customer = customer;
	}




	public Set<Item> getItems() {
		return items;
	}




	public void setItems(Set<Item> items) {
		this.items = items;
	}




	public Order(int id, Customer1 customer, Set<Item> items) {
		this.id = id;
		this.customer = customer;
		this.items = items;
	}
	
	
	
	
}
	
	

	