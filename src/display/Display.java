package display;

import java.util.List;

import PIM.PIMCollection;
import PIM.PIMEntity;

//为主界面提供显示的文本内容
public class Display {
	public static void Welcome() {
		System.out.println("------------------");
		System.out.println("| Welcome to PIM |");
		System.out.println("|-----1.List-----|");
		System.out.println("|----2.Create----|");
		System.out.println("|-----3.Save-----|");
		System.out.println("|-----4.Load-----|");
		System.out.println("|-----5.Quit-----|");
		System.out.println("------------------");
	}
	public static void createList() {
		System.out.println("Enter an item type");
		System.out.println("----1.To do----");
		System.out.println("-----2.Note----");
		System.out.println("-3.Appointment-");
		System.out.println("---4.Contact---");
		System.out.println("-----5.Quit----");
		
	}	
//	public static void showList(List<PIMEntity> list) {
//		if(!list.isEmpty()) {
//			System.out.println("There are "+list.size()+" items.");
//			for(PIMEntity temp:list)
//				System.out.println(temp.toString());
//		}
//		else
//			System.out.println("There are 0 items.");
//	}
	
	public static void showList(PIMCollection pc) {
		if(pc==null)
			System.out.println("There are 0 items.");
		else {
			System.out.println("There are "+pc.size()+" items.");
			for(PIMEntity pe:pc) {
				System.out.println(pe.toString());
			}
		}
	}
}
