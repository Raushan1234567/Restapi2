package com.main;
import java.util.*;

import com.dao.*;
import com.dto.*;
import com.exception.ClassnotFound;
import com.exception.SomeThingWentWrong;

public class Mian {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		
		int c;
		
		do {
			
			System.out.println("1. Add element");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Serch By id Student");
			System.out.println("5. View List of  Student");
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			switch(c) {
			case 1:
				Addui(sc);
				break;
			case 2:
				UpdateUi(sc);
				break;
			case 3:
				Delete(sc);
				break;
			case 4:
				Search(sc);
			
				break;
			case 5:
				ViewUi(sc);
				break;
			case 0:
				System.out.println("Thanks");
				break;
				default :
					System.out.println("Invalid selection");
			}
			
		}while(c!=0);
		sc.close();

	}

	private static void Search(Scanner sc) {
		
		System.out.println("Enter roll");
		int roll =sc.nextInt();
		
		Interface b=new serviceImple();
		
		try {
			Student2 c= b.SerchByid(roll);
			System.out.println(c);
		} catch (ClassnotFound | SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void ViewUi(Scanner sc) {
		
		
		Interface b=new serviceImple();
		
		try {
			List<Student2> d=b.View();
			d.forEach(a->System.out.println(a));
		} catch (ClassnotFound | SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void Delete(Scanner sc) {
		System.out.println("Enter roll");
		int roll=sc.nextInt();
		
		
		Interface b=new serviceImple();
		try {
			int c=b.Delete(roll);
			if(c>0) {
			System.out.println("Deleted successfully");
			}
			else {
				System.out.println("Not Deleted successfully");
			}
			
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void UpdateUi(Scanner sc) {
		System.out.println("Enter roll");
		int roll=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter Address");
		String Address=sc.next();
		
		Student2 a=new Student2(roll, name, Address);
		
		
		Interface b=new serviceImple();
		
		try {
			b.UpdateStudent(a);
			System.out.println("Successfully updated");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void Addui(Scanner sc) {
		System.out.println("Enter roll");
		int roll=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter Address");
		String Address=sc.next();
		
		Student2 a=new Student2(roll, name, Address);
		
		
		Interface b=new serviceImple();
		
		try {
			b.AddStudent(a);
			System.out.println("Successfully added");
		} catch (SomeThingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
