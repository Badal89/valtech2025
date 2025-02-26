package hibernate1.dao;

import java.util.List;

import hibernate1.Customer1;



public interface CustomerServiceDAO {
	
    void save(Customer1 c);
	
	void update(Customer1 c);
	
	void delete(int id);
	
	Customer1 get(int id);
	
	List<Customer1> getAll();

}
