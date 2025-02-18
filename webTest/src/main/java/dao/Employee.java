package dao;


import java.util.*;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee> {
	
	public enum Gender{
		MALE,FEMALE,OTHER;
	}
	
	private String name;
	private long id;
	private int age;
	private int level;
	private float salary;
	private int experience;
	
	private Gender gender;
	
	
	
	
	private static List<Employee> allEmp=new ArrayList<Employee>();
	private static Map<Gender,List<Employee>> getEmpoyeeMap=new HashMap<Gender,List<Employee>>();
	
	public static Map<Gender,List<Employee>> getEmployeeByGender(){
		return allEmp.stream().collect(Collectors.groupingBy(e->e.gender));
	}
	
	
	public static double getEmployeeByLevel(int level) {
		List<Employee> emp=allEmp.stream().filter(e->e.level==level).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.level==level).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	public static double getEmployeeByGender(Gender gender) {
		List<Employee> emp=allEmp.stream().filter(e->e.gender.equals(gender)).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.gender.equals(gender)).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	public static double getEmployeeByName(String name) {
		List<Employee> emp=allEmp.stream().filter(e->e.name.equals(name)).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.name.equals(name)).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	public static double getEmployeeByGenderLevel(int level,Gender gender) {
		List<Employee> emp=allEmp.stream().filter(e->e.gender.equals(gender) && e.level==level).collect(Collectors.toList());
		System.out.println(emp);
		return allEmp.stream().filter(e->e.gender.equals(gender) && e.level==level).mapToDouble(Employee::getSalary).sum()	;
		}	
	
	
	
	
	
	public Employee() {
		
	}



	public Employee(String name, long id, int age, int level, float salary, int experience, Gender gender) {
	
		this.name = name;
		this.id = id;
		this.age = age;
		this.level = level;
		this.salary = salary;
		this.experience = experience;
		this.gender = gender;
	}
	
	
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public float getSalary() {
		return salary;
	}



	public void setSalary(double d) {
		this.salary = (float) d;
	}



	public int getExperience() {
		return experience;
	}



	public void setExperience(int experience) {
		this.experience = experience;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	
	


	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", age=" + age + ", level=" + level + ", salary=" + salary
				+ ", experience=" + experience + ", gender=" + gender + "]";
	}


	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}


	
	  public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
		  
		  
	  }
	  
	  public static class EmployeeBuilder{
		  private Employee employee;
		  
		  public EmployeeBuilder(Employee employee) {
			this.employee=employee;
			
		}
		  public Employee build() {
			  return employee;
		  }
		  
		  public EmployeeBuilder id(long id) {
			  employee.setId(id);
			  
			  return this;
		  }
		  public EmployeeBuilder name( String name) {
			  employee.setName(name);
			  
			  return this;
		  }
		  public EmployeeBuilder age(int age) {
			  employee.setAge(age);
			  
			  return this;
		  }
		  public EmployeeBuilder salary(double d) {
			  employee.setSalary(d);
			  
			  return this;
		  } public EmployeeBuilder level(int level) {
			  employee.setLevel(level);
			  
			  return this;
		  }
		  public EmployeeBuilder experience(int experience) {
			  employee.setExperience(experience);
			  
			  return this;
		  }
		  public EmployeeBuilder gender(Gender gender) {
			  employee.setGender(gender);
			  
			  return this;
		  }
		

		
	  }

	@Override
	public int compareTo(Employee o) {
		
		if(this.level != o.level) {
			return level-o.level;
			
		}
		else if(this.experience != o.experience) {
			return experience-o.experience;
		}
		
		int genderComparable=this.gender.compareTo(o.gender);
		if(genderComparable != 0) return genderComparable;
		
		else
			return (int) (salary-o.salary);
	}
	
	
	public static void main(String[] args) {
		Employee obj=new Employee("badal",7,22,2,30000,5,Gender.MALE);
		System.out.println(obj.toString());
	}
	
 

	
	
	
	
	
	
	
		
	
	
	
	

}
