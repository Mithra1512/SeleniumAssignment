package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int range = 8;
		int firstNum = 0,secNum = 1;
		int sum;
		
		System.out.println("Fibonaaci Series:");
		
		System.out.println(firstNum);
		
		for (int i = 1; i < range-1; i++) {

			sum=firstNum+secNum;
			System.out.println(sum);
			firstNum = secNum;			
			secNum = sum;
			
		}
		
	}

}
