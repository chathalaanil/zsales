package sales;

import java.util.ArrayList;
import java.util.Scanner;

public class billing {
	int pid,q,pri;boolean tr=true;
	double tpri;static double totalamount=0;
	String pname;double dis;
	static ArrayList<billing> bill = new ArrayList<billing>();
public void	bill() {
	while(tr){
	int pid,q,f=0,op;
	System.out.println("Enter ProductId Quantity");
	Scanner sc = new Scanner(System.in);
	pid = sc.nextInt();q=sc.nextInt();
	
	for(inventinput i: inventory.user) {
		if(i.prodid == pid) {
			f=1;
			if(i.quantity>=q) {
				billing b = new billing();
				b.pid=pid;b.q=q;b.pname=i.pname;b.pri=i.price;
				b.dis=1-(((double)i.discount)/100);b.tpri = b.dis * q * b.pri;totalamount+=b.tpri;
				bill.add(b);
				//System.out.println(b.tpri+" total is "+totalamount);
				break;
			}
			else {
				System.out.println("Insufficient Quantity");
				bill();
			}
			
		}
	}
	if(f ==0) {
		System.out.println("Invalid product Id");
		bill();
	}
	System.out.println("Total Amount is: "+totalamount+
			"\n1. ADD\n2. Checkout\n3. Mainmenu");
	op = sc.nextInt();
	if(op ==1)bill();
	else if(op == 2) {
		checkout();
		tr=false;
		break;
		}
	else if(op == 3) {
		totalamount=0;
		break;
	}
	else {
		System.out.println("Choose Correct Option");
	}
	}
	
}
public void checkout() {
	String d[] = new String[3];
	for(input i: Login.user) {
		if(i.login.equals(sales.uname)) {
			i.total_sales+=totalamount;
			break;
		}
	}
	System.out.println("ProductId ProductName Price Discount Quantity TotalPrice\n");
	for(billing i: bill) {
		System.out.println(i.pid+"  "+i.pname+" "+i.pri+" "+i.dis+" "+i.q+" "+i.tpri);
		for(inventinput j: inventory.user) {
			if(i.pid == j.prodid) {
				j.quantity-=i.q;
				
				d[0]=Integer.toString(i.pid);	
				d[1]="BILLING";
				audit a= new audit();
				a.addt(d);
				break;
			}
			
		}
}
	inventory c = new inventory();
	c.viewinventory();
	bill.removeAll(bill);
}

}
