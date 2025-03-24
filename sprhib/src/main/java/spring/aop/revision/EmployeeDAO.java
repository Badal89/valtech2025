package spring.aop.revision;

import org.hibernate.Session;

import spring.Tx.Employee;

public interface EmployeeDAO {

	Employee save(Session ses, Employee e);

	Session get(Session ses, long id);

	Employee update(Session ses, Employee e);

}