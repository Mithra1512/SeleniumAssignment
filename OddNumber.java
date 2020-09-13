package week1.day1;

public class OddNumber {

	public static void main(String[] args) {
		
		int range = 20;
		
		System.out.println("Odd numbers between 1 and "+range+" are");
		
		for (int i = 1; i <=20; i++) {
			
			if (i%2!=0) {
				System.out.println(i);
			}
		}

	}

}
