package org.example;

import org.example.dao.EmployeeDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO=new EmployeeDAO();

// ------------------save Employee entry----------(Start)
//        employeeDAO.saveEmployee("Indu","Dev");
//        employeeDAO.saveEmployee("Sahi","Admin");
//        employeeDAO.saveEmployee("Bala","Products");
// ------------------save Employee entry-----------(end)


// ------------------Retrive Employee entry---------(start)
//        Employee emp=employeeDAO.getEmployeeDetails(2L);
//        if(emp!=null){
//            System.out.println("Employee details --------- name: '"+emp.getName()+"' & department: '"+emp.getDepartment()+"'");
//        }else{
//            System.out.println("Employee not found!");
//        }
// ------------------Retrive Employee entry---------(end)


// ------------------Retrive Employee List---------(start)
//        List<Employee> employeeList=employeeDAO.getEmployeeList();
//        System.out.println("Employee list ----------->");
//        for(Employee emp:employeeList){
//            System.out.println("Employee id: "+emp.getId()+" & Name: '"+emp.getName()+"' & Department: '"+emp.getDepartment()+"'");
//        }
// ------------------Retrive Employee List---------(end)


// ------------------Retrive Employee List with filtering---------(start)
//        List<Employee> employeeList=employeeDAO.getEmployeeListByDepartment("DB");
//        System.out.println("List of Employees fall under your required Department----->");
//        for (Employee emp:employeeList){
//            System.out.println("Employee id: "+emp.getId()+" & Name: '"+emp.getName()+"' & Department: '"+emp.getDepartment()+"'");
//        }
// ------------------Retrive Employee List with filtering---------(end)



// ------------------Update employee name by ID ---------(start)
        employeeDAO.updateEmployee(2L,"Mounika","DB");
// ------------------Update employee name by ID ---------(end)


// ------------------Delete employee name by ID ---------(start)
//        employeeDAO.deleteEmployeeById(1L);
// ------------------Delete employee name by ID ---------(end)

    }
}