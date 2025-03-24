package day4;

import java.util.List;

import day4.Employee.Gender;

public interface EmployeeService {

	double getTotalSalaryByGender(List<Employee> employees, Gender gender);
	double getTotalSalaryByAge(List<Employee> employees, int age);
	double getTotalSalaryByName(List<Employee> employees, String name);
	double getTotalSalaryByLevel(List<Employee> employees, int level);

}