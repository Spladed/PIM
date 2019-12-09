package PIM;

//联系人
public class PIMContact extends PIMEntity{
	
	private String firstName;
	private String lastName;
	private String email;
	
	public PIMContact(String fn,String ln,String e) {
		// TODO Auto-generated constructor stub
		super();
		firstName=fn;
		lastName=ln;
		email=e;
	}
	
	public PIMContact(String priority,String fn,String ln,String e){
		super(priority);
		firstName=fn;
		lastName=ln;
		email=e;
	}
	
	@Override
	public void fromString(String s) {
		// TODO Auto-generated method stub
		String[] temp=s.split(" ");
		firstName=temp[0];
		lastName=temp[1];
		email=temp[2];
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName+" "+email;
	}

}
