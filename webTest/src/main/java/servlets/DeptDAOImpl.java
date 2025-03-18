package servlets;

import java.sql.*;
import java.util.*;
import dao.Employee;
import jakarta.servlet.ServletContext;
public class DeptDAOImpl implements DeptDAO {
    private ServletContext sce;
    private Properties p;

    public DeptDAOImpl(ServletContext sce, Properties p) {
        this.sce = sce;
        this.p = p;
    }
    public ServletContext getSce() {
        return sce;
    }
    public void setSce(ServletContext sce) {
        this.sce = sce;
    }
    private Connection getConnection() throws SQLException {
        System.out.println("DB URL: " + sce.getAttribute("db.url"));
        System.out.println("DB Username: " + sce.getAttribute("db.username"));
        System.out.println("DB Password: " + sce.getAttribute("db.password"));

        return DriverManager.getConnection(
            (String) sce.getAttribute("db.url"),
            (String) sce.getAttribute("db.username"),
            (String) sce.getAttribute("db.password")
        );
    }
    @Override
    public void save(Dept dept) {
        String query = "INSERT INTO depts (deptid, deptname, deptlocation) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, dept.getId());
            stmt.setString(2, dept.getName());
            stmt.setString(3, dept.getLocation());
            stmt.executeUpdate();
            System.out.println("Department Added: " + dept.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Dept dept) {
        String query = "UPDATE depts SET deptname = ?, deptlocation = ? WHERE deptid = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, dept.getName());
            stmt.setString(2, dept.getLocation());
            stmt.setInt(3, dept.getId());
            stmt.executeUpdate();
            System.out.println("Department Updated: " + dept.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        String query = "DELETE FROM depts WHERE deptid = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Department Deleted: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dept getDept(int id) {
        String query = "SELECT deptid, deptname, deptlocation FROM depts WHERE deptid = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Dept(
                    rs.getInt("deptid"), 
                    rs.getString("deptname"), 
                    rs.getString("deptlocation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 // Get all departments
   @Override
    public Set<Dept> getAll() {
        Set<Dept> departments = new HashSet<>();
        String query = "SELECT * FROM depts";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                departments.add(new Dept(rs.getInt("id"), rs.getString("name"), rs.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Dept first() {
        String query = "SELECT deptid, deptname, deptlocation FROM depts ORDER BY deptid ASC LIMIT 1";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                return new Dept(
                    rs.getInt("deptid"), 
                    rs.getString("deptname"), 
                    rs.getString("deptlocation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("No department found in database.");
        return null;
    }

    @Override
    public Dept last() {
       String query = "SELECT deptid, deptname, deptlocation FROM depts ORDER BY deptid DESC LIMIT 1";
        
        Dept dept = null;
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                dept = new Dept(rs.getInt("deptid"), rs.getString("deptname"), rs.getString("deptlocation"));
                System.out.println("Last Department Found: ID=" + dept.getId() + ", Name=" + dept.getName());
            } else {
                System.out.println("No last department found in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
       
    }

    @Override
    public Dept next(int id) {
        String query = "SELECT deptid, deptname, deptlocation FROM depts WHERE deptid > ? ORDER BY deptid ASC LIMIT 1";
        return getDeptFromQueryWithId(id, query);
    }
    @Override
    public Dept previous(int id) {
        String query = "SELECT deptid, deptname, deptlocation FROM depts WHERE deptid < ? ORDER BY deptid DESC LIMIT 1";
        return getDeptFromQueryWithId(id, query);
    }
    @Override
    public List<Employee> getEmployeesByDept(int deptId) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee WHERE deptid = ?";  // Fixed table name!

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, deptId);
            System.out.println("Fetching employees for Department ID: " + deptId);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getString("name"),
                    rs.getLong("id"),
                    rs.getInt("age"),
                    rs.getInt("level"),
                    rs.getFloat("salary"),
                    rs.getInt("experience"),
                    Employee.Gender.valueOf(rs.getString("gender").toUpperCase())
                );

                employees.add(emp);
                System.out.println("Found Employee: " + emp.getName());
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        if (employees.isEmpty()) {
            System.out.println("No employees found for department ID: " + deptId);
        }
        return employees;
    }

 // Helper method to get department from a query using a specific ID
    private Dept getDeptFromQueryWithId(int id, String query) {
        Dept dept = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dept = new Dept(rs.getInt("deptid"), rs.getString("deptname"), rs.getString("deptlocation"));
                System.out.println("Navigated to Department: " + dept.getName());
            } else {
                System.out.println("No next/previous department found for ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
}
