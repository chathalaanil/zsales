package sales;
import java.util.ArrayList; // import the ArrayList class

 // Create an ArrayList object

 class Login {
	 static int id=0;
static ArrayList<input> user = new ArrayList<input>();
public void add() {
	input a1=new input("adi","1234","admin",100,++id);
	input a2=new input("adi1","1234","biller",100,++id);
	input a3=new input("adi2","1234","admin",100,++id);
	input a4=new input("adi3","1234","biller",100,++id);
	user.add(a1);user.add(a2);user.add(a3);user.add(a4);
} 
public String match(String []d) {
	//System.out.println("yesss");
	for(input i:user) {
		//System.out.println(i.login+" "+i.paswd+" "+d[0].trim()+"  "+);
		if(i.login.trim().equals(d[0].trim()) && i.paswd.trim().equals(d[1].trim())) {
			//System.out.println("yesss12");
			sales.uname=i.login;sales.utype=i.type;
			if(i.type == "admin") {
				return "admin";
			}			
			else return "biller";
		}
	}
	return "invalid";
}	
}
 class input{
	String login;
	String paswd;
	String type;
	int total_sales;
    int id;
	input(String login,String paswd, String type, int total_sales, int id)
	{
		this.login=login;this.paswd=paswd;this.type=type;this.total_sales=total_sales;
		this.id=id;
	}
	public input() {
		// TODO Auto-generated constructor stub
	}
}