package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.Employee;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlet extends HttpServlet {
    private DeptDAO deptDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);  // Ensures ServletConfig is initialized properly
        ServletContext context = getServletContext();
        Properties properties = new Properties();
        
        try (InputStream input = context.getResourceAsStream("/WEB-INF/classes/db.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new ServletException("Could not load database properties file.");
            }
        } catch (IOException e) {
            throw new ServletException("Error loading properties", e);
        }

        deptDAO = new DeptDAOImpl(context, properties);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept currentDept = deptDAO.first();

        if (currentDept == null) {
            resp.getWriter().println("No departments found in the database.");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("current", currentDept);

        List<Employee> employees = deptDAO.getEmployeesByDept(currentDept.getId());
        req.setAttribute("dept", currentDept);
        req.setAttribute("employees", employees);

        req.getRequestDispatcher("dept.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        HttpSession session = req.getSession();
        Dept current = (Dept) session.getAttribute("current");

        if ("First".equals(operation)) {
            current = deptDAO.first();
        } else if ("Last".equals(operation)) {
            current = deptDAO.last();
        } else if ("Previous".equals(operation)) {
            Dept previousDept = deptDAO.previous(current.getId());
            if (previousDept != null) {
                current = previousDept;
            }
            
        } else if ("Next".equals(operation)) {
            Dept nextDept = deptDAO.next(current.getId());
            if (nextDept != null) {
                current = nextDept;
            }
            
        } else if ("DeleteDept".equals(operation)) {
            if (current != null) {
                deptDAO.delete(current.getId());
                System.out.println("Deleted department: " + current.getName());
                current = deptDAO.first(); // Go to first dept after delete
            }
            
        } else if ("AddDept".equals(operation)) {
            int id = Integer.parseInt(req.getParameter("deptid"));
            String name = req.getParameter("deptname");
            String location = req.getParameter("deptlocation");
            Dept newDept = new Dept(id, name, location);
            deptDAO.save(newDept);
            System.out.println("Added new department: " + name);
            current = newDept;      // Show newly added dept
            
        } else if ("UpdateDept".equals(operation)) {
            int id = Integer.parseInt(req.getParameter("deptid"));
            String name = req.getParameter("deptname");
            String location = req.getParameter("deptlocation");
            Dept updatedDept = new Dept(id, name, location);
            deptDAO.update(updatedDept);
            System.out.println("Updated department: " + name);
            current = updatedDept; // Show updated dept
        }

        session.setAttribute("current", current);
        List<Employee> employees = (current != null) ? deptDAO.getEmployeesByDept(current.getId()) : new ArrayList<>();

        req.setAttribute("dept", current);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("dept.jsp").forward(req, resp);
    }



}
