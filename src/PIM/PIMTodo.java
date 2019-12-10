package PIM;

//待办事项
public class PIMTodo extends PIMEntity implements PIMDate{
	private String content;
	private String date;
	
	public PIMTodo(String content,String date) {
		// TODO Auto-generated constructor stub
		super();
		this.content=content;
		this.date=date;
	}
	
	public PIMTodo(String content,String priority,String date) {
		// TODO Auto-generated constructor stub
		super(priority);
		this.content=content;
		this.date=date;
	}
	

	@Override
	public void fromString(String s) {
		// TODO Auto-generated method stub
		content=s;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return content;
	}
	
	@Override
	public void setDate(String str) {
		// TODO Auto-generated method stub
		date=str;
	}

	public String getDate() {
		return date;
	}
}
