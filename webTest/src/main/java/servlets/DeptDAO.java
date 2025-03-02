package servlets;

import java.util.List;
import java.util.Set;

import dao.Employee;

public interface DeptDAO {
    Dept first();
    Dept last();
    Dept next(int id);
    Dept previous(int id);
    
    void save(Dept dept);  // Already exists
    void update(Dept dept);
    void delete(int id);
    Dept getDept(int id);
    Set<Dept> getAll();

    List<Employee> getEmployeesByDept(int deptId);
}


