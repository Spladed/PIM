package display;

import java.io.*;
import java.util.*;
import Tools.*;
import PIM.*;
import db.*;

//存储数据
public class PIMData implements Serializable{
	private static final long serialVersionUID=1L;
	private PIMCollection pc;
	public PIMData() {
		pc=new PIMCollection();
	}
	//用于将各个事项列出
	public void List() {
		System.out.println("To do list");	Display.showList(pc.getTodos());
		System.out.println("Note list");	Display.showList(pc.getNotes());
		System.out.println("Appointment list");		Display.showList(pc.getAppointments());	
		System.out.println("Contact list");		Display.showList(pc.getContact());
	}
	//用于创建事项
	public void Create() {
		Scanner sc=new Scanner(System.in);
		String ch;
		Display.createList();
		ch=sc.nextLine();
		while(!(ch.equals("Quit") || ch.equals("5"))) {
			switch (InputJudgment.choose2(ch)) {
				case 1:pc.add(createPIM.toDo());Display.createList();break;
				case 2:pc.add(createPIM.Note());Display.createList();break;
				case 3:pc.add(createPIM.Appointment());Display.createList();break;
				case 4:pc.add(createPIM.Contact());Display.createList();break;
				default:System.out.println("Please input again!");break;
			}
			ch=sc.nextLine();
		}
	}
	//用于保存数据
	public void Save(){	
		for(PIMEntity pe:pc) {
			if((pe.getClass().getName()).equals("PIM.PIMTodo")) {
				String[] column= {"content","priority","todo_time"};
				String[] content= {pe.toString(),pe.getPriority(),pe.getDate()};
				insert.insertSet("todo", column, content);
			}
			if((pe.getClass().getName()).equals("PIM.PIMNote")) {
				String[] column= {"content","priority"};
				String[] content= {pe.toString(),pe.getPriority()};
				insert.insertSet("note", column, content);
			}
			if((pe.getClass().getName()).equals("PIM.PIMAppointment")) {
				String[] column= {"content","priority","appointment_time"};
				String[] content= {pe.toString(),pe.getPriority(),pe.getDate()};
				insert.insertSet("appointment", column, content);
			}
			if((pe.getClass().getName()).equals("PIM.PIMContact")) {
				String[] column= {"content","priority","todo_time"};
				String[] content= {pe.toString(),pe.getPriority(),pe.getDate()};
				insert.insertSet("todo", column, content);
			}
		}
		System.out.println("Done!");
	}
	//用于加载数据
	public PIMData Load() {
		//加载todo
		String[] content= {"content","priority","todo_time"};
		List<HashMap<String,Object>> recieve=select.selectSet( "todo", content);
		if(!recieve.isEmpty()) {
			for(HashMap<String,Object> m:recieve) {
				
			}
		}
		//加载note
		//加载appointment
		//加载contact
		return null;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	}
	
}
