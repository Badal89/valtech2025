package day4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import day4.Employee.Gender;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EmployeeTest {
	
	private EmployeeService employeeService;
	List<Employee> employees;
	
	@BeforeEach
    void test() {
        employees = new ArrayList<>();
        employeeService = new EmployeeServiceImpl(); 
       
        
        employees.add(Employee.builder().id(11).name("Arjun")
                .age(22).salary(99000).gender(Gender.MALE).level(2)
                .experience(2).build());

        employees.add(Employee.builder().id(12).name("Rahul")
                .age(23).salary(55000).gender(Gender.MALE)
                .level(1).experience(1).build());

        employees.add(Employee.builder().id(13).name("Vikram")
                .age(23).salary(88000).gender(Gender.MALE)
                .level(1).experience(1).build());

        employees.add(Employee.builder().id(14).name("Priya")
                .age(25).salary(59000).gender(Gender.FEMALE).level(3)
                .experience(3).build());

        employees.add(Employee.builder().id(15).name("Suresh")
                .age(40).salary(65000).gender(Gender.MALE)
                .level(13).experience(10).build());

        employees.add(Employee.builder().id(16).name("Ankit")
                .age(38).salary(89000).gender(Gender.MALE)
                .level(9).experience(9).build());

        employees.add(Employee.builder().id(17).name("Rina")
                .age(27).salary(60000).gender(Gender.FEMALE).level(4)
                .experience(4).build());

        employees.add(Employee.builder().id(18).name("Sonia")
                .age(35).salary(70000).gender(Gender.FEMALE)
                .level(8).experience(8).build());

   }

	@Test
	public void testTotalSalaryByGender() {
	    double totalSalaryMale = employeeService.getTotalSalaryByGender(employees, Gender.MALE);
	    System.out.println("Total salary of male employees: " + totalSalaryMale);
	    assertEquals(396000, totalSalaryMale, 0.01, "The total salary of male employees should be 396000");
	}


	@Test
	public void testTotalSalaryByAge() {
	    // Test that the total salary of employees aged 30 or more is returned correctly
	    double totalSalaryAge = employeeService.getTotalSalaryByAge(employees, 30);
	    System.out.println("Total salary of employees with 30+ age: " + totalSalaryAge);
	    assertEquals(224000, totalSalaryAge, 0.01, "The total salary of employees with 30+ age should be 224000");
	}


	@Test
    public void testTotalSalaryByName() {
        double salaryByName = employeeService.getTotalSalaryByName(employees, "Ankit");
        System.out.println("Total salary of Ankit: " + salaryByName);
        assertEquals(89000, salaryByName, 0.01, "The salary of Ankit should be 89000");
    }

	@Test
	public void testTotalSalaryByLevel() {
	    double salaryByLevel = employeeService.getTotalSalaryByLevel(employees, 4);
	    System.out.println("Total salary of employees with level 4: " + salaryByLevel);
	    assertEquals(60000, salaryByLevel, 0.01, "The total salary of employees with level 4 should be 60000");
	}

	

    @Test
    void testHashCode() {
        Employee emp1 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Gender.MALE).build();
        Employee emp2 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Gender.MALE).build();
        Employee emp3 = Employee.builder().id(2).name("Jerry").age(30).salary(4000).level(3).experience(5).gender(Gender.FEMALE).build();

        assertEquals(emp1.hashCode(), emp2.hashCode());
        assertNotEquals(emp1.hashCode(), emp3.hashCode());
    }

    @Test
    void testEquals() {
        Employee emp1 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Gender.MALE).build();
        Employee emp2 = Employee.builder().id(1).name("John").age(25).salary(3000).level(2).experience(3).gender(Gender.MALE).build();
        Employee emp3 = Employee.builder().id(2).name("Jerry").age(30).salary(4000).level(3).experience(5).gender(Gender.FEMALE).build();

        assertTrue(emp1.equals(emp2));
        assertFalse(emp1.equals(emp3));
    }
    
    
    
    
}
