package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import day4.Employee.Gender;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao=new EmployeeDAOImpl();
         dao.save(new Employee("Working",2,25,3,15000,6,Gender.FEMALE));
         Employee e=new Employee("DEF",2,25,3,15000,6,Gender.FEMALE);
         // dao.update(e);
//		e=dao.get(2);
//		assertEquals("DEF",e.getName());
//		assertEquals(2,e.getId());
//		
//		
//		assertEquals(25,e.getAge());
//		assertEquals(3,e.getLevel());
//		assertEquals(15000,e.getSalary());
//		assertEquals(6,e.getExperience());
//		
//		assertEquals(Gender.FEMALE,e.getGender());
		

		
//		assertTrue(dao.getAll().size()>=1);
//		
		//dao.delete(2);
		
		
		
		
		
		
	}

}
