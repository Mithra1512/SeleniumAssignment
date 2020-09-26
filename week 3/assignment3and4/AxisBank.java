package assignment3and4;

public class AxisBank extends BankInfo {
	
	public void deposit() {
		System.out.println("Deposit account in axisbank");

	}

	public static void main(String[] args) {
		
		AxisBank ab = new AxisBank();
		
		ab.saving();
		ab.fixed();
		ab.deposit();
		

	}

}
