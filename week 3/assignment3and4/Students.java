package assignment3and4;

public class Students {

	public void getStudentInfo(int ID) {
		
		System.out.println("Student ID: "+ID);

	}

	public void getStudentInfo(int ID, String name) {
		
		System.out.println("Student ID: "+ID);
		System.out.println("Student name: "+name);

	}
	
	public void getStudentInfo(String email, String phNo) {
		
		System.out.println("Student email address: "+email);
		System.out.println("Student Phone number: "+phNo);

	}
	
	public static void main(String[] args) {
		
		Students stds = new Students();
		stds.getStudentInfo(706133);
		stds.getStudentInfo(706133,"Mithra Sridhar");		
		stds.getStudentInfo("mithrasridhar@sel.com","9954828780");
		
	}

}
