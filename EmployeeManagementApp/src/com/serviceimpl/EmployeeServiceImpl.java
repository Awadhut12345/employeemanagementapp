package com.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Employee;
import com.services.EmployeeServiceI;

public class EmployeeServiceImpl implements EmployeeServiceI {
	
	Scanner sc=new Scanner(System.in);
	
	
	@Override
	public void addEmployee() {
		Employee e=new Employee();
		
		System.out.println("Enter Id");
		int eid=sc.nextInt();
		e.setEid(eid);
		
		System.out.println("Enter Name");
		String ename=sc.next();
		e.setEname(ename);
		
		System.out.println("Enter Designation");
		String designation=sc.next();
		e.setDesignation(designation);
		
		System.out.println("Enter Salery");
		double salery=sc.nextDouble();
		e.setSalary(salery);
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(e);
		tx.commit();
		
	}

	@Override
	public void viewEmployee() {

		System.out.println("Enter Employee Id");
		int eid=sc.nextInt();
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		Employee e=session.get(Employee.class, eid);
		if(e!=null) {
			System.out.println(e.getEid());
			System.out.println(e.getEname());
			System.out.println(e.getDesignation());
			System.out.println(e.getSalary());
		}else {
			System.out.println("Invalid Employee ID");
		}
	}

	@Override
	public void updateEmployee() {
		System.out.println("Update Employee Details");

		Employee e=new Employee();
		
		System.out.println("Enter Id");
		int eid=sc.nextInt();
		e.setEid(eid);
		
		System.out.println("Enter Name");
		String ename=sc.next();
		e.setEname(ename);
		
		System.out.println("Enter Desigantion");
		String designation=sc.next();
		e.setDesignation(designation);
		
		System.out.println("Enter Salery");
		double esalery=sc.nextDouble();
		e.setSalary(esalery);
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		session.update(e);
		tx.commit();
		
	}

	@Override
	public void removeEmployee() {
		
		System.out.println("Enter Employee Id");
		
		int eid=sc.nextInt();
	//	Employee e=new Employee();
	//	e.setEid(eid);
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		Employee e2=session.get(Employee.class, eid);
		
		if(e2!=null) {
			session.delete(e2);
			tx.commit();
		}else {
			System.out.println("Invalid Employee Id");
		}
		

	}

	

	

}
