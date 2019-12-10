package Tools;
import java.util.*;

import PIM.*;

//用于创建各种PIM的实例
public class createPIM {
	
	public static PIMEntity toDo(){
		Scanner sc=new Scanner(System.in);
		String content;
		String date;
		String priority;
		System.out.println("Enter todo text:");
		content=sc.nextLine();
		System.out.println("Enter date for todo item:yyyy-mm-dd");
		date=sc.nextLine();
		System.out.println("Enter todo priority:? Y/N");
		priority=sc.nextLine();
		if(priority.equals("Y") || priority.equals("y")) {
			System.out.println("Enter todo priority: normal/important/urgent");
			priority=sc.nextLine();			
		}
		else {
			priority="normal";
		}
		System.out.println("Done");
		return new PIMTodo(priority, content, date);
	}
	
	public static PIMEntity Note(){
		Scanner sc=new Scanner(System.in);
		String content;
		String priority;
		System.out.println("Enter note text:");
		content=sc.nextLine();
		System.out.println("Enter note priority:? Y/N");
		priority=sc.nextLine();
		if(priority.equals("Y") || priority.equals("y")) {
			System.out.println("Enter note priority:normal/important/urgent");
			priority=sc.nextLine();		
		}
		else {
			priority="normal";
		}
		System.out.println("Done");
		return new PIMNote(priority, content);
	}
	
	public static PIMEntity Appointment(){
		Scanner sc=new Scanner(System.in);
		String description;
		String date;
		String priority;
		System.out.println("Enter appointment text:");
		description=sc.nextLine();
		System.out.println("enter date：yyyy-mm-dd");
		date=sc.nextLine();
		System.out.println("Enter appointment priority:? Y/N");
		priority=sc.nextLine();
		if(priority.equals("Y") || priority.equals("y")) {
			System.out.println("Enter appointment priority:normal/important/urgent");
			priority=sc.nextLine();
		}
		else {
			priority="normal";
		}
		System.out.println("Done");
		return new PIMAppointment(priority,description, date);
	}
	
	public static PIMEntity Contact(){
		Scanner sc=new Scanner(System.in);
		String firstName;
		String lastName;
		String email;
		String priority;
		System.out.println("Enter first name:");
		lastName=sc.nextLine();
		System.out.println("Enter last name:");
		firstName=sc.nextLine();
		System.out.println("Enter email:");
		email=sc.nextLine();
		System.out.println("Enter contact priority:? Y/N");
		priority=sc.nextLine();
		if(priority.equals("Y") || priority.equals("y")) {
			System.out.println("Enter contact priority:normal/important/urgent");
			priority=sc.nextLine();
		}
		else {
			priority="normal";
		}
		System.out.println("Done");
		return new PIMContact(priority, firstName, lastName, email);
	}
}
