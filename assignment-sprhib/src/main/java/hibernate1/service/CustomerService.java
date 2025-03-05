package hibernate1.service;

import java.util.List;
import hibernate1.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);
	Customer getCustomer(int id);
	List<Customer> getAll();
	void updateCustomer(Customer customer);
	void deleteCustomer(int id);

}
