package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class EmployeeDAOImpl implements EmployeeDAO {

//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


	private ServletContext sce;
	private Properties p;

    public EmployeeDAOImpl(ServletContext sce) {
		this.sce=sce;
		this.p=p;
	}
    

	public ServletContext getSce() {
		return sce;
	}


	public void setSce(ServletContext sce) {
		this.sce = sce;
	}


	public Properties getP() {
		return p;
	}


	public void setP(Properties p) {
		this.p = p;
	}
	
	


	private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "postgres");
//    
		System.out.println(sce.getAttribute("db.password"));
		String pass=(String)sce.getAttribute("db.password");
		System.out.println(pass);
		return DriverManager.getConnection((String)sce.getAttribute("db.url"),(String)sce.getAttribute("db.username"),(String)sce.getAttribute("db.password"));
	
	}

    @Override
    public void save(Employee e) {
        String query = "INSERT INTO EMPLOYEE (ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            setValuesToPreparedStatement(e, ps);
            int rowAffected = ps.executeUpdate();
            System.out.println("Rows Inserted = " + rowAffected);
        } catch (Exception ex) {
            throw new RuntimeException("Error inserting employee: " + ex.getMessage(), ex);
        }
    }

    private Employee populateEmployee(ResultSet rs) throws SQLException {
        return Employee.builder()
            .id(rs.getInt("ID"))
            .name(rs.getString("NAME"))
            .age(rs.getInt("AGE"))
            .gender(Employee.Gender.valueOf(rs.getString("GENDER").toUpperCase()))
            .salary(rs.getFloat("SALARY"))
            .experience(rs.getInt("EXPERIENCE"))
            .level(rs.getInt("LEVEL"))
            .build();
    }

    private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
        ps.setLong(1, e.getId());
        ps.setString(2, e.getName());
        ps.setInt(3, e.getAge());
        ps.setString(4, e.getGender().name());
        ps.setFloat(5, e.getSalary());
        ps.setInt(6, e.getExperience());
        ps.setInt(7, e.getLevel());
    }

    @Override
    public void update(Employee e) {
        String query = "UPDATE EMPLOYEE SET NAME=?, AGE=?, GENDER=?, SALARY=?, EXPERIENCE=?, LEVEL=? WHERE ID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            setValuesToPreparedStatement(e, ps);
            ps.setLong(7, e.getId());

            int rowAffected = ps.executeUpdate();
            System.out.println("Rows Updated = " + rowAffected);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating employee: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM EMPLOYEE WHERE ID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " deleted successfully.");
            } else {
                throw new RuntimeException("No employee with ID " + id + " found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting employee: " + e.getMessage(), e);
        }
    }

    @Override
    public Employee get(int id) {
        String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return populateEmployee(rs);
            } else {
                return null; // No employee found with the given ID
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching employee by ID: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEE";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                employees.add(populateEmployee(rs));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching all employees: " + ex.getMessage(), ex);
        }

        return employees;
    }

    @Override
    public List<Employee> searchEmployees(String searchBy, String searchValue, String comparison) {
        List<Employee> emps = new ArrayList<>();
        if (searchValue == null || searchValue.trim().isEmpty()) {
            return getAll(); // Return all employees if no search value is provided
        }

        String query = "SELECT * FROM EMPLOYEE WHERE ";
        
        switch (searchBy) {
            case "id":
            case "age":
            case "level":
            case "experience":
            case "salary":
                if ("greater".equals(comparison)) {
                    query += searchBy.toUpperCase() + " > ?";
                } else if ("less".equals(comparison)) {
                    query += searchBy.toUpperCase() + " < ?";
                } else {
                    query += searchBy.toUpperCase() + " = ?";
                }
                break;
            case "name":
                query += "LOWER(NAME) LIKE LOWER(?)";
                searchValue = "%" + searchValue + "%"; // Allow partial matches
                break;
            case "gender":
                query += "UPPER(GENDER) = ?";
                searchValue = searchValue.toUpperCase(); // Normalize gender input
                break;
            default:
                throw new IllegalArgumentException("Invalid search parameter: " + searchBy);
        }

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Set parameter values correctly
            if (searchBy.matches("id|age|level|experience|salary")) {
                try {
                    ps.setInt(1, Integer.parseInt(searchValue));  // Convert String to Integer safely
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid numeric value for " + searchBy + ": " + searchValue);
                }
            } else {
                ps.setString(1, searchValue); // Keep String for Name & Gender
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emps.add(populateEmployee(rs));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Database error: " + ex.getMessage(), ex);
        }

        return emps;
    }
    
    
    @Override
    public List<Employee> sortEmployees(String sortBy, String sortOrder) {
        List<Employee> employees = new ArrayList<>();

        // List of valid columns to prevent SQL injection
        List<String> validColumns = List.of("id", "name", "age", "gender", "salary", "experience", "level");

        if (!validColumns.contains(sortBy.toLowerCase())) {
            throw new IllegalArgumentException("Invalid sorting parameter: " + sortBy);
        }

        String query = "SELECT * FROM EMPLOYEE ORDER BY " + sortBy + " " + ("desc".equalsIgnoreCase(sortOrder) ? "DESC" : "ASC");

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                employees.add(populateEmployee(rs));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Database error while sorting: " + ex.getMessage(), ex);
        }

        return employees;
    }


}
