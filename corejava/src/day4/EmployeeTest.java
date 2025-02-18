package day4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
 
class EmployeeTest {
 
    @Test
    void testHashCode() {
        Employee emp1 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Employee.Gender.MALE).build();
        Employee emp2 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Employee.Gender.MALE).build();
        Employee emp3 = Employee.builder().id(2).name("Jane").age(30).salary(4000).level(3).experience(5).gender(Employee.Gender.FEMALE).build();
 
        assertEquals(emp1.hashCode(), emp2.hashCode());
        assertNotEquals(emp1.hashCode(), emp3.hashCode());
    }
 
    @Test
    void testEquals() {
        Employee emp1 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Employee.Gender.MALE).build();
        Employee emp2 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Employee.Gender.MALE).build();
        Employee emp3 = Employee.builder().id(2).name("Jane").age(30).salary(4000).level(3).experience(5).gender(Employee.Gender.FEMALE).build();
 
        assertTrue(emp1.equals(emp2));
        assertFalse(emp1.equals(emp3));
    }
 
    @Test
    void testAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().id(1).name("Alice").age(30).salary(5000).level(3).experience(5).gender(Employee.Gender.FEMALE).build());
        employees.add(Employee.builder().id(2).name("Bob").age(25).salary(4000).level(2).experience(3).gender(Employee.Gender.MALE).build());
        employees.add(Employee.builder().id(3).name("Charlie").age(35).salary(6000).level(4).experience(8).gender(Employee.Gender.OTHER).build());
        employees.add(Employee.builder().id(4).name("David").age(40).salary(7000).level(4).experience(10).gender(Employee.Gender.MALE).build());
     
      
        double totalSalaryMale = employees.stream()
                .filter(e -> e.getGender() == Employee.Gender.MALE) 
                .mapToDouble(Employee::getSalary)               
                .sum();                                           
     
      
        System.out.println("Total salary of male employees: " + totalSalaryMale);
     
      
        assertEquals(11000, totalSalaryMale, 0.01, "The total salary of male employees should be 11000");
        
        double totalSalaryAge = employees.stream()
                .filter(e -> e.getAge()>30) 
                .mapToDouble(Employee::getSalary)                
                .sum(); 
        System.out.println("Total salary of employees with 30+ age: " + totalSalaryAge);
        
        assertEquals(13000, totalSalaryAge, 0.01, "The total salary of 30+ age employees should be 13000");

        
     
        // Sorting employees by level
        Collections.sort(employees, (e1, e2) -> Integer.compare(e1.getLevel(), e2.getLevel()));
        assertEquals(2, employees.get(0).getLevel(), "First employee should have the lowest level");
        assertEquals(3, employees.get(1).getLevel(), "Second employee should have the middle level");
        assertEquals(4, employees.get(2).getLevel(), "Third employee should have the highest level");
        assertEquals(4, employees.get(3).getLevel(), "Fourth employee should have the highest level too");
    }
     
}
 