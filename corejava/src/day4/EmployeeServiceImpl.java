package day4;

import java.util.List;
import java.util.stream.Collectors;

import day4.Employee.Gender;

public class EmployeeServiceImpl implements EmployeeService{

   
    @Override
	public double getTotalSalaryByGender(List<Employee> employees, Gender gender) {
        return employees.stream()
                .filter(e -> e.getGender() == gender)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

 
    @Override
	public double getTotalSalaryByAge(List<Employee> employees, int age) {
        return employees.stream()
                .filter(e -> e.getAge() > age)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

   
    @Override
	public double getTotalSalaryByName(List<Employee> employees, String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .mapToDouble(Employee::getSalary)
                .sum();
    }


    @Override
	public double getTotalSalaryByLevel(List<Employee> employees, int level) {
        return employees.stream()
                .filter(e -> e.getLevel() == level)
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
