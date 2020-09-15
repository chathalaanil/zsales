package sales;

import java.util.Scanner;

public class Menu {
	
public void admin() {
	boolean i=true;
	int c;
	Scanner sc =new Scanner(System.in);
	while(i) {
		System.out.println("Choose From Admin Menu\n"
				+ "1.Add or Update Inventory\n"
				+ "2.View Inventory\n"
				+ "3.Remove Inventory\n"
				+ "4.Billing\n"
				+ "5.Audit Sale\n"
				+ "6.Logout\n ");
		
		c= sc.nextInt();
		inventory in = new inventory();
		int rid,res;
		switch(c) {		
		case 1: 
			in.addinventory();
			break;
		case 2:	
			in.viewinventory();
			break;
		case 3:	
			while(true) {
			System.out.println("Enter ProductId to remove");
			rid=sc.nextInt();
			res = in.reminventory(rid);
			if(res == 0)
			{
				System.out.println("Enter Valid Product id");
			}
			else
			break;
			}
			break;
		case 4:	
			billing bb = new billing();
			bb.bill();
			break;
		case 5:	
			audit aa = new audit();
			aa.showall();
			break;
		case 6:	
			i=false;
			break;
		default:	
			System.out.println("Choose the correct Option");
			break;
		}
	
	}
	
}
public void biller() {
	boolean i=true;
	int c;
	Scanner sc =new Scanner(System.in);
	while(i) {
		System.out.println("Choose From Biller Menu\n"
				+ "1.View Inventory\n"
				+ "2.Billing\n"
				+ "3.Logout\n");
		c= sc.nextInt();
		c= sc.nextInt();
		inventory in = new inventory();
		switch(c) {
		case 1: 
			in.viewinventory();
			break;
		case 2:	
			billing bb = new billing();
			bb.bill();
			break;
		case 3:	
			i=false;
			break;
		default:	
			System.out.println("Choose the correct Option");
			break;
		}
		
	}
	
}
}
