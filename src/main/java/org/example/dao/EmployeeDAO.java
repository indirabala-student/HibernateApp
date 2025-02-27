package org.example.dao;

import org.example.Employee;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    public void saveEmployee(String nameToBe, String departmentToBe){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Employee emp=new Employee();
        Transaction transaction= session.beginTransaction();

        emp.setName(nameToBe);
        emp.setDepartment(departmentToBe);

        session.persist(emp);

        System.out.println("Employee saved successfully!");

        transaction.commit();
        session.close();
    }

    public Employee getEmployeeDetails(Long id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Employee emp=session.get(Employee.class, id);
        session.close();
        return emp;
    }

    public List<Employee> getEmployeeList(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        List<Employee> employeeList=session.createQuery("from Employee", Employee.class).list();
        session.close();
        return employeeList;
    }

    public List<Employee> getEmployeeListByDepartment(String dept){
        Session session=HibernateUtil.getSessionFactory().openSession();
        List<Employee> employeeList=session.createQuery("from Employee where department=: dept", Employee.class).setParameter("dept",dept).list();
        session.close();
        return employeeList;
    }

    public void updateEmployee(Long id,String nameToBeSet,String departmentToBeSet){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Employee emp=session.get(Employee.class, id);
        Transaction transaction=session.beginTransaction();

        if(emp!=null){
            emp.setName(nameToBeSet);
            emp.setDepartment(departmentToBeSet);

            session.merge(emp);

            transaction.commit();
            System.out.println("Employee updated successfully!");
        }else{
            System.out.println("Employee not found!");
        }
        session.close();
    }

    public void deleteEmployeeById(Long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Employee emp=session.get(Employee.class, id);
        Transaction transaction=session.beginTransaction();

        if (emp!=null){
            session.remove(emp);
            System.out.println("Employee deleted successfully!");
        }else{
            System.out.println("Employee not found!");
        }

        transaction.commit();
        session.close();
    }
}
