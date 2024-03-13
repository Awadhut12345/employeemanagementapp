package com.client;

import java.util.Scanner;

import com.serviceimpl.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		EmployeeServiceImpl esi=new EmployeeServiceImpl();
		
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("**********MENEU************");
		
		System.out.println("1.ADDEMPLOYEE");
		System.out.println("2.ViewEMPLOYEE");
		System.out.println("3.UpdateEMPLOYEE");
		System.out.println("4.RemoveEMPLOYEE");
		
		
		System.out.println("Enter Your Choice");
		
		int ch=sc.nextInt();
		
		switch(ch){
		case 1:
			esi.addEmployee();
		break;
		
		case 2:
			esi.viewEmployee();
		break;	
		
		case 3:
			esi.updateEmployee();
		break;	
			
		case 4:
			esi.removeEmployee();
		break;	
		
		default:
			System.out.println("Wrong Choice");
			
	    break;
			
		}
		
		}
		
	}

}
