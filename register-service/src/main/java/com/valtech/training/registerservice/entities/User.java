package com.valtech.training.registerservice.entities;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity
@Table(name="users")
public class User {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)

	private long id;
	private String name;
	private int age;
	private String mobile;
	private String email;
	private boolean iskid;

	@ManyToOne(targetEntity = Subscription.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="sub", referencedColumnName="id")
	private Subscription subscription;
 
	public User() {

	}

	public User(String name, int age, String mobile, String email) {

		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;

	}

	public User(String name, int age, String mobile, String email, boolean iskid) {

		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.iskid = iskid;

	}

	public User(String name, int age, String mobile, String email, boolean iskid, Subscription subscription) {

		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.iskid = iskid;
		this.subscription= subscription;

	}
 
	public Long getId() {

		return id;

	}
 
	public void setId(Long id) {

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
 
	public String getMobile() {

		return mobile;

	}
 
	public void setMobile(String mobile) {

		this.mobile = mobile;

	}
 
	public String getEmail() {

		return email;

	}
 
	public void setEmail(String email) {

		this.email = email;

	}
 
	public boolean isKid() {

		return iskid;

	}
 
	public void setKid(boolean iskid) {

		this.iskid = iskid;

	}
 
	public Subscription getSubscription() {

		return subscription;

	}
 
	public void setSubscription(Subscription subscription) {

		this.subscription = subscription;

	}
 
}

 