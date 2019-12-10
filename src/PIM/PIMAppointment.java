package PIM;

//约会
public class PIMAppointment extends PIMEntity implements PIMDate{
	
	private String description;
	private String date;
	
	public PIMAppointment(String description,String date) {
		// TODO Auto-generated constructor stub
		super();
		this.description=description;
		this.date=date;
	}
	
	public PIMAppointment(String description,String priority,String date) {
		// TODO Auto-generated constructor stub
		super(priority);
		this.description=description;
		this.date=date;
	}
	
	@Override
	public void fromString(String s) {
		// TODO Auto-generated method stub
		description=s;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return date+" "+description;
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
