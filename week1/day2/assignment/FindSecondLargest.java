package week1.day2.assignment;

import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) {

		int[] data = { 3, 2, 11, 4, 6, 15,18,45 };
	
		Arrays.sort(data);
		
		System.out.println("Given input in ascending order");
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		
		System.out.println("Second Largest amongst the given array:");
		for (int i = 0; i < data.length; i++) {

			if (i == (data.length - 2)) {
				System.out.println(data[i]);
			}

		}
	}

}
