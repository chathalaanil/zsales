package sales;

import java.util.Scanner;

public class sales {
	static String[] details;
	static String uname,utype;

public static void main(String[] args) {
	try {
	String r;
	while(true) {
	System.out.println("Enter login Details");
	Login l=new Login();
	l.add();
	Scanner sc =new Scanner(System.in);
	uname=sc.nextLine();
	details=uname.split(" ");
	//System.out.println(details[0]+" "+details[1]);
r=l.match(details);
if(r == "invalid") {
	System.out.println("Enter valid credentials");
}
else {
	break;
}
sc.close();
}
	Menu call = new Menu();
	if(r == "admin") {
		call.admin();
	}
	else {
		call.biller();
	}
	}
	catch(Exception e) {
		System.out.println("exception happened at"+e);
	}
}

}
