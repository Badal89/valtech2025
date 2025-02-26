package hibernate1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer1 {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String address;
	private String permanent_add;
	
	public Customer1() {
		
	}
	
	
	

	public Customer1(String name, int age, String address, String permanent_add) {

		this.name = name;
		this.age = age;
		this.address = address;
		this.permanent_add = permanent_add;
	}


	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", permanent_add="
				+ permanent_add + "]";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermanent_add() {
		return permanent_add;
	}

	public void setPermanent_add(String permanent_add) {
		this.permanent_add = permanent_add;
	}
	
	

}
