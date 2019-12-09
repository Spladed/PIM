package PIM;

import java.io.*;
import java.util.*;
import Tools.*;

//存储数据
public class PIMData implements Serializable{
	private static final long serialVersionUID=1L;
//	private List<List<PIMEntity>> list=new LinkedList<>();
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
	public void Save() throws Exception {	
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(".\\data"));
			oos.writeObject(this);
			oos.close();
			System.out.println("Saved!");
	}
	//用于加载数据
	public PIMData Load() throws Exception {
		File file=new File(".\\data");
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
		System.out.println("Loaded!");
		return (PIMData)ois.readObject();
	}
	
}
