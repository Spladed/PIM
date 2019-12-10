package PIM;

//备忘录
public class PIMNote extends PIMEntity{
	String content;
	
	public PIMNote(String content) {
		// TODO Auto-generated constructor stub
		super();
		this.content=content;
	}
	
	public PIMNote(String content,String priority) {
		// TODO Auto-generated constructor stub
		super(priority);
		this.content=content;
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

}
