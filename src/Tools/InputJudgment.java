package Tools;

public class InputJudgment {
	public static int choose(String str) {
		if(str.equals("List") || str.equals("1"))			return 1;
		else if(str.equals("Create") || str.equals("2"))	return 2;
		else if(str.equals("Save") || str.equals("3"))		return 3;
		else if(str.equals("Load") || str.equals("4"))		return 4;
		return 0;
	}
	
	public static int choose2(String str) {
		if(str.equals("To do") || str.equals("1"))			return 1;
		else if(str.equals("Note") || str.equals("2"))	return 2;
		else if(str.equals("Appointment") || str.equals("3"))		return 3;
		else if(str.equals("Contact") || str.equals("4"))		return 4;
		return 0;
	}
}
