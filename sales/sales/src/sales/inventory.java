package sales;

import java.util.ArrayList;
import java.util.Scanner;

public class inventory {

static ArrayList<inventinput> user = new ArrayList<inventinput>();
public void addinventory() {
	int pid, pri, dis, q,t=0,op;String pname,d[],inv [];
	d=new String [3];
	Scanner sc = new Scanner(System.in);
	System.out.println("ProductId ProductName Price Discount Quantity ");
	pname=sc.nextLine();
	inv=pname.split(" ");
	pid = Integer.parseInt(inv[0]); pri = Integer.parseInt(inv[2]);
	dis = Integer.parseInt(inv[3]);q = Integer.parseInt(inv[4]);pname=inv[1];
	System.out.println("null "+pname+" "+pid);
	for(inventinput i:user) {
		if(i.prodid == pid) {
			i.discount=dis;i.pname=pname;i.price=pri;i.quantity+=q;
			t=1;
			break;
		}
	}
	if(t ==0) {
		inventinput o =new inventinput(pid, pname,pri, dis, q);
	user.add(o);
	}

	d[0]=Integer.toString(pid);	
	d[1]="ADD";
	audit a= new audit();
	a.addt(d);
	while(true) {
		System.out.println("1.Continue\n2.Go Back\n");
		op = sc.nextInt();
		if(op ==1) {
			inventory cc = new inventory();
			cc.addinventory();
		}
		break;
	}
	
}
public void viewinventory() {
	System.out.println("ProductId ProductName Price Quantity Discount ");
	for(inventinput i:user) {
		System.out.println(i.prodid+" "+i.pname+" "+i.price+" "+i.quantity+" "+i.discount);
	}
}
public int reminventory(int id) {
	String d[]=new String[2];
	int t=0;
	for(inventinput i:user) {
		if(i.prodid == id) {
			d[0]=Integer.toString(i.prodid);	
			d[1]="REMOVE";
			audit a= new audit();
			a.addt(d);
		user.remove(i);t=1;
			break;
		}
	}
	if(t == 0)
	return 0;
	else return 1;
}
}
class inventinput {
	int prodid,price,discount,quantity;
String pname;
 inventinput(int pid,String pname,int pri,int dis,int q) {
	this.prodid=pid;this.pname=pname;
	this.price=pri;this.discount=dis;this.quantity=q;
}
 inventinput(){}
}