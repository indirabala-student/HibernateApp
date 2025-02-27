package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSessionFactory().openSession();

// ------------------save Employee entry----------(Start)
//        Transaction transaction=session.beginTransaction();
//
//        Employee emp=new Employee();
//        emp.setName("Bala");
//        emp.setDepartment("Admin");
//
//        session.persist(emp);
//        transaction.commit();
//        System.out.println("Employee saved successfully!");
// ------------------save Employee entry-----------(end)


// ------------------Retrive Employee entry---------(start)
//        Employee empRead=session.get(Employee.class, 4L);
//        if(empRead!=null){
//            System.out.println("Employee found:"+empRead.getName()+"-"+empRead.getDepartment());
//        }else{
//            System.out.println("Employee not found");
//        }
// ------------------Retrive Employee entry---------(end)


// ------------------Retrive Employee List---------(start)
//        List<Employee> employeeList=session.createQuery("from Employee",Employee.class).list();
//
//        for (Employee emp: employeeList){
//            System.out.println("Employee ---"+emp.getId()+": "+emp.getName()+"-"+emp.getDepartment());
//        }
// ------------------Retrive Employee List---------(end)


// ------------------Retrive Employee List with filtering---------(start)
//        String dept="IT";
//        List<Employee> employeesIT=session.createQuery("from Employee where department= :dept", Employee.class).setParameter("dept",dept).list();
//
//        System.out.println("Employees from IT department-------->");
//        for (Employee emp: employeesIT){
//            System.out.println("ID: "+emp.getId()+"---- Name: "+emp.getName());
//        }
// ------------------Retrive Employee List with filtering---------(end)



// ------------------Update employee name by ID ---------(start)
//        Transaction transaction= session.beginTransaction();
//
//        Employee emp=session.get(Employee.class, 1L);
//        String empCurrentName = emp.getName();
//        String empFutureName= "Indira";
//
//        if(emp!=null && !empCurrentName.equals(empFutureName)){
//            emp.setName(empFutureName);
//            session.merge(emp);
//            transaction.commit();
//            System.out.println("------ Employee name has been updated from '"+ empCurrentName +"' to '"+empFutureName+"' -------");
//        } else if (empCurrentName.equals(empFutureName)) {
//            System.out.println("------Employee name is same as you wished------");
//        } else{
//            System.out.println("------Employee not found!------");
//        }
// ------------------Update employee name by ID ---------(end)


// ------------------Delete employee name by ID ---------(start)
//        Transaction transaction= session.beginTransaction();
//
//        Employee emp=session.get(Employee.class, 2L);
//        if(emp!=null){
//            session.remove(emp);
//            transaction.commit();
//            System.out.println("Employee deleted successfully!");
//        }else{
//            System.out.println("Employee not found!");
//        }
// ------------------Delete employee name by ID ---------(end)

        session.close();
    }
}