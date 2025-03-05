package hibernate1.client;


import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hibernate1.Customer;
import hibernate1.Item;
import hibernate1.LineItem;
import hibernate1.Order;
import hibernate1.dao.LineItemDAO;
import hibernate1.dao.OrderDAO;
import hibernate1.service.CustomerService;
import hibernate1.service.InventoryService;
import hibernate1.service.OrderService;


public class HibernateClient {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("assignment-hibernate-ann.xml");
		
		CustomerService cs=ctx.getBean(CustomerService.class);
		InventoryService is=ctx.getBean(InventoryService.class);
		OrderService os=ctx.getBean(OrderService.class);
		LineItemDAO lDAO=ctx.getBean(LineItemDAO.class);
		

	
//		Customer c1= new Customer("Badal",20,"AHM","Jaipur");
//		Customer c2= new Customer("Swapnil",23,"Delhi","AHM");
//		Customer c3= new Customer("Rahul",22,"Noida","Kota");
//		Customer c4= new Customer("Mayank",21,"Mumbai","Jaipur");
//	
//		cs.addCustomer(c1);
//		cs.addCustomer(c2);
//	    cs.addCustomer(c3);
//		cs.addCustomer(c4);
		
		//cs.deleteCustomer(9);
	
		Item i1 = new Item("GAMING LAPTOP", "RTX 3060", 12, 5, 18);
//		Item i2 = new Item("DESKTOP", "Ryzen 7", 7, 3, 12);
//		Item i3 = new Item("MOUSE", "Bluetooth", 4, 1, 7);
//		Item i4 = new Item("KEYBOARD", "RGB Backlit", 6, 3, 9);


//		is.addInventory(i1);
//		is.addInventory(i2);
//		is.addInventory(i3);
//		is.addInventory(i4);
		
		LineItem l1= new LineItem(i1,2);
		lDAO.addLineItem(l1);
//		
		
		ctx.close();
	}
	
	
}