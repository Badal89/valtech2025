package day4;

import org.junit.jupiter.api.Test;
import day4.Employee.Gender;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EmployeeTest {
	
	

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

    @Test
    void testAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder().id(1).name("Eve").age(28).salary(4800).level(2).experience(4).gender(Gender.FEMALE).build());
        employees.add(Employee.builder().id(2).name("Frank").age(32).salary(5200).level(3).experience(6).gender(Gender.MALE).build());
        employees.add(Employee.builder().id(3).name("Grace").age(45).salary(7100).level(5).experience(12).gender(Gender.OTHER).build());
        employees.add(Employee.builder().id(4).name("Hank").age(39).salary(6900).level(4).experience(9).gender(Gender.MALE).build());

        // Salary by Gender
        double totalSalaryMale = employees.stream()
                .filter(e -> e.getGender() == Gender.MALE)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of male employees: " + totalSalaryMale);
        assertEquals(12100, totalSalaryMale, 0.01, "The total salary of male employees should be 12100");

        // Salary by Age
        double totalSalaryAge = employees.stream()
                .filter(e -> e.getAge() > 30)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of employees with 30+ age: " + totalSalaryAge);
        assertEquals(19200, totalSalaryAge, 0.01, "The total salary of 30+ age employees should be 19200");

        // Salary by Name
        double salaryByName = employees.stream()
                .filter(e -> e.getName().equals("Eve"))
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of Eve: " + salaryByName);
        assertEquals(4800, salaryByName, 0.01, "The salary of Eve should be 4800");

        // Salary by Level
        double salaryByLevel = employees.stream()
                .filter(e -> e.getLevel() == 4)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of employees with level 4: " + salaryByLevel);
        assertEquals(6900, salaryByLevel, 0.01, "The total salary of employees with level 4 should be 6900");

        // Sorting employees by level
        Collections.sort(employees, (e1, e2) -> Integer.compare(e1.getLevel(), e2.getLevel()));
        assertEquals(2, employees.get(0).getLevel(), "First employee should have the lowest level");
        assertEquals(3, employees.get(1).getLevel(), "Second employee should have the middle level");
        assertEquals(4, employees.get(2).getLevel(), "Third employee should have the next highest level");
        assertEquals(5, employees.get(3).getLevel(), "Fourth employee should have the highest level");
    }

}
