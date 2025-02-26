package dao;

import java.util.List;

public interface EmployeeDAO {
    
    void save(Employee e);
    
    void update(Employee e);
    
    void delete(int id);
    
    Employee get(int id);
    
    List<Employee> getAll();
    
    List<Employee> sortEmployees(String sortBy, String sortOrder) ;

    
    List<Employee> searchEmployees(String searchBy, String searchValue, String comparison); // New method for search functionality
}
