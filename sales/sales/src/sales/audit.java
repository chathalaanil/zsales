package sales;

import java.util.ArrayList;
import java.util.Scanner;

public class audit {
	static int tid=0;
	String pid, ctype,ttype,usname;int ttid;
	static ArrayList<audit> user = new ArrayList<audit>();
	public void  addt(String d[]) {
		audit i = new audit();
		i.pid=d[0];
		i.ttype=d[1];i.usname=sales.uname;i.ttid=++tid;i.ctype=sales.utype;
		user.add(i);
	}
public void showall(){
	int op=0;String name;boolean tr=true;

		
	Scanner sc = new Scanner(System.in);
	System.out.println("SalesAudit\n"+"1. Print all\n"+"2. printby Username\n"+"3. PrintbyProductId");
	op = sc.nextInt();
	if(op == 1)
	{
		System.out.println("Transactionid ProductId CustomerType Ttype  Cname");
		for(audit a:user) {
			System.out.println(a.ttid+" "+a.pid+" "+a.ctype+" "+a.ttype+" "+a.usname);
		}
	}
	else if(op == 2) {
		System.out.println("Enter Username");
		name=sc.nextLine();
		namequery(name);
		}
	else {
		System.out.println("Enter productId");
		op=sc.nextInt();
		idquery(op);
		
	}			
}
public void namequery(String op) {
	System.out.println("Transactionid ProductId CustomerType Ttype  Cname");
	for(audit a: user) {
		if(a.usname.equals(op)) {
			System.out.println(a.ttid+" "+a.pid+" "+a.ctype+" "+a.ttype+" "+a.usname);
		}
	}
}
public void idquery(int op) {
	System.out.println("Transactionid ProductId CustomerType Ttype  Cname");
	for(audit a: user) {
		if(a.pid.equals(Integer.toString(op))) {
			System.out.println(a.ttid+" "+a.pid+" "+a.ctype+" "+a.ttype+" "+a.usname);
		}
	}
}

}
