package org.example.dao;

import org.example.Employee;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class EmployeeDAO {

    public void saveEmployee(String nameToBe, String departmentToBe){
        Transaction transaction=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try{
            Employee emp=new Employee();
            transaction= session.beginTransaction();
            emp.setName(nameToBe);
            emp.setDepartment(departmentToBe);
            session.persist(emp);
            transaction.commit();
            System.out.println("Employee saved successfully!");
        }
        catch (ConstraintViolationException e){
            if (transaction!=null)
                transaction.rollback();
            System.out.println("Error: Employee already exists! ");
        }
        catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
    }

    public Employee getEmployeeDetails(Long id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Employee emp=null;
        try{
            emp=session.get(Employee.class, id);
        }catch (Exception e){
            System.out.println("Error: Unexpected issue occured in the process of fetching Employee details..........!");
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return emp;
    }

    public List<Employee> getEmployeeList(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        List<Employee> employeeList=null;
        try {
            employeeList=session.createQuery("from Employee", Employee.class).list();
        }
        catch (Exception e){
            System.out.println("Error: Unexpected issue occured in the process of fetching Employee List..........!");
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return employeeList;
    }

    public List<Employee> getEmployeeListByDepartment(String dept){
        Session session=HibernateUtil.getSessionFactory().openSession();
        List<Employee> employeeList=null;
        try {
            employeeList=session.createQuery("from Employee where department=: dept", Employee.class).setParameter("dept",dept).list();
        }
        catch (Exception e){
            System.out.println("Error: Unexpected issue occured in the process of fetching Employee List in department..........!");
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
        return employeeList;
    }

    public void updateEmployee(Long id,String nameToBeSet,String departmentToBeSet){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Employee emp=session.get(Employee.class, id);
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            if(emp!=null){
                emp.setName(nameToBeSet);
                emp.setDepartment(departmentToBeSet);
                session.merge(emp);
                transaction.commit();
                System.out.println("Employee updated successfully!");
            }else{
                System.out.println("Employee not found!");
            }
        }
        catch (ConstraintViolationException e){
            if (transaction!=null)
                transaction.rollback();
            System.out.println("Error: Employee name and department already exist! ");
        }
        catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            System.out.println("Error: Unexpected issue occured in the process of Updating Employee..........!");
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
    }

    public void deleteEmployeeById(Long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Employee emp=session.get(Employee.class, id);
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            if (emp!=null){
                session.remove(emp);
                transaction.commit();
                System.out.println("Employee deleted successfully!");
            }else{
                System.out.println("Employee not found!");
            }
        }
        catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            System.out.println("Error: Unexpected issue occured in Deleting Employee...........!");
        }
        finally {
            if (session!=null && session.isOpen())
                session.close();
        }
    }
}
