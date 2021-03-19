package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.model.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestLoginProduct {
public static void main(String[] args) {
	
LoginService ls=new LoginServiceImpl();
ProductService ps=new ProductServiceImpl();
int n=ls.validateUserPass();
if(n!=-1) {
	System.out.println("successfull");
	Scanner sc=new Scanner(System.in);
	int choice=0;
	do {
		System.out.println("1.Add Product\n2.delete Product\n3.Modify Product price\n4.Display By Id\n5.Display All\n6.Exit");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			int s=ps.addProduct();
			if(s!=-1) {
				System.out.println("insertion Done");
			}
			else {
				System.out.println("insertion not Done");
			}
			break;
		case 2:
			System.out.println("enter the id");
			int id=sc.nextInt();
			s=ps.deleteProduct(id); 
			if(s!=-1) {
				System.out.println("deletion done");
			}
			else {
				System.out.println("deletion not done");
			}
			break;
		case 3:
			System.out.println("enter id");
			id=sc.nextInt();
			System.out.println("enter price");
			int price=sc.nextInt();
			s=ps.modifyByPrice(id,price);
			if(s!=-1) {
				System.out.println("Updation Done");
			}
			else {
				System.out.println("Updation not Done");
			}
			break;
		case 4:
			System.out.println("enter id");
			id=sc.nextInt();
			Product p=ps.displayById(id);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("no Product found");
			}
			break;
		case 5:
			List<Product> lst=ps.displayAll();
			//System.out.println(lst.toString());
			if(lst!=null) {
				lst.stream().forEach(System.out::println);
			}else {
				System.out.println("no Product found");
			}
			break;
		case 6:
			sc.close();
		}
	}while(choice!=6);
}
else {
	System.out.println(" a/c is blocked and contact admin ");
}
}

}