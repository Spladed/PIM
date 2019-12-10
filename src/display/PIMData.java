package display;

import java.util.*;
import Tools.*;
import PIM.*;
import db.*;

//处理主界面的各个功能
public class PIMData{
	private PIMCollection pc;
	public PIMData() {
		pc=new PIMCollection();
	}
	public PIMData(PIMCollection pc) {
		this.pc=pc;
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
				String[] content= {pe.toString().split(" ")[1],pe.getPriority(),pe.getDate()};
				insert.insertSet("appointment", column, content);
			}
			if((pe.getClass().getName()).equals("PIM.PIMContact")) {				
				String[] result=(pe.toString()).split(" ");
				String[] column= {"firstname","lastname","email","priority"};
				String[] content= {result[0],result[1],result[2],pe.getPriority()};
				insert.insertSet("contact", column, content);
			}
		}
		System.out.println("Done!");
	}
	//用于加载数据
	public PIMData Load() {
		//加载todo
		PIMCollection newPC=new PIMCollection();
		String[] todoContent= {"content","priority","todo_time"};
		List<HashMap<String,Object>> recieve=select.selectSet( "todo", todoContent);
		if(!recieve.isEmpty()) {
			for(HashMap<String,Object> m:recieve) {
				newPC.add(new PIMTodo((String)m.get(todoContent[0]), (String)m.get(todoContent[1]), String.valueOf(m.get(todoContent[2]))));
			}
		}
		//加载note
		String[] noteContent= {"content","priority"};
		recieve=select.selectSet( "note", noteContent);
		if(!recieve.isEmpty()) {
			for(HashMap<String,Object> m:recieve) {
				newPC.add(new PIMNote((String)m.get(noteContent[0]), (String)m.get(noteContent[1])));
			}
		}
		//加载appointment
		String[] appointmentContent= {"content","priority","appointment_time"};
		recieve=select.selectSet( "appointment", appointmentContent);
		if(!recieve.isEmpty()) {
			for(HashMap<String,Object> m:recieve) {
				newPC.add(new PIMAppointment((String)m.get(appointmentContent[0]), (String)m.get(appointmentContent[1]), String.valueOf(m.get(appointmentContent[2]))));
			}
		}
		//加载contact
		String[] contactContent= {"firstname","lastname","email","priority"};
		recieve=select.selectSet( "contact", contactContent);
		if(!recieve.isEmpty()) {
			for(HashMap<String,Object> m:recieve) {
				newPC.add(new PIMContact((String)m.get(contactContent[0]), (String)m.get(contactContent[1]), (String)m.get(contactContent[2]),(String)m.get(contactContent[3])));
			}
		}
		return new PIMData(newPC);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	}
	
}
