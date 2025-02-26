package hibernate1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hibernate1.dao.CustomerDAO;
import hibernate1.dao.CustomerServiceDAO;



@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerServiceDAO {
	@Autowired
    private CustomerDAO customerDAO;
	
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED)
	public void save(Customer1 c) {
		customerDAO.save(c);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Customer1 c) {
		
		customerDAO.update(c);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		customerDAO.delete(id);
	}

	@Override
	public Customer1 get(int id) {
		return customerDAO.get(id);
	}

	@Override
	public List<Customer1> getAll() {
		return customerDAO.getAll();
	}
    
    public void setEmployeeDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	    
	    
}




