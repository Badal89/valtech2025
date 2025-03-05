package hibernate1.dao;

import java.util.List;
import hibernate1.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer);
	Customer getCustomer(int id);
	List<Customer> getAll();
	void updateCustomer(Customer customer);
	void deleteCustomer(int id);

}