package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/employees")
public class EmployeesServlet extends HttpServlet {
	private EmployeeDAO dao;

	
	@Override
	public void init() throws ServletException {
	    ServletContext context = getServletContext(); 
	    Properties properties = new Properties();
	    try (InputStream input = context.getResourceAsStream("/WEB-INF/classes/db.properties")) {
	        if (input != null) {
	            properties.load(input);
	        } else {
	            throw new ServletException("Could not load properties file.");
	        }
	    } catch (IOException e) {
	        throw new ServletException("Error loading properties", e);
	    }

	    dao = new EmployeeDAOImpl(context, properties);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String operation=req.getParameter("operation");
		if("cancel".equals(operation)) {
			req.setAttribute("emps",dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;	
		}
		Employee emp=Employee.builder().id(Integer.parseInt(req.getParameter("id")))
				.name(req.getParameter("name"))
				//.age(Integer.parseInt(req.getParameter("age")))
				 .age(Integer.parseInt(req.getParameter("age")))
				.gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
                .salary(Integer.parseInt(req.getParameter("salary")))
                .experience(Integer.parseInt(req.getParameter("experience")))
                .level(Integer.parseInt(req.getParameter("level"))).build();
		if("Save".equals(operation)) {
			dao.save(emp);
              req.setAttribute("emps",dao.getAll());
       	      req.getRequestDispatcher("employees.jsp").forward(req, resp);
       		  return;       
		}
		if("Update".equals(operation)) {
            dao.update(emp);
            req.setAttribute("emps",dao.getAll());
			   req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;      
	   }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String operation = req.getParameter("operation");

	    if ("Update".equals(operation)) {
	        int id = Integer.parseInt(req.getParameter("id"));
	        Employee e = dao.get(id);
	        req.setAttribute("emp", e);
	        req.setAttribute("mode", "Update");
	        req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
	        return;
	    }
	    
	   
	    if ("Delete".equals(operation)) {
	        int id = Integer.parseInt(req.getParameter("id"));
	        dao.delete(id);
	        req.setAttribute("emps", dao.getAll());
	        req.getRequestDispatcher("employees.jsp").forward(req, resp);
	        return;
	    }
	    if ("new".equals(operation)) {
	        req.setAttribute("mode", "Save");
	        req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
	        return;
	    }
	    String searchBy = req.getParameter("searchBy");
	    String searchValue = req.getParameter("searchValue");
	    String comparison = req.getParameter("comparison");

	    List<Employee> employees;

	    if (searchBy != null && searchValue != null) {
	        employees = dao.searchEmployees(searchBy, searchValue, comparison);
	    } else {
	        employees = dao.getAll();
	    }
	    String sortBy = req.getParameter("sortBy");
	    String sortOrder = req.getParameter("sortOrder"); 

	    if (sortBy != null && sortOrder != null) {
	        employees = dao.sortEmployees(sortBy, sortOrder);
	    }
	    req.setAttribute("emps", employees);
	    req.setAttribute("sortBy", sortBy);
	    req.setAttribute("sortOrder", sortOrder);

	    req.getRequestDispatcher("employees.jsp").forward(req, resp);
	}

}



