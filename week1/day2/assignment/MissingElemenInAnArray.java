package week1.day2.assignment;

import java.util.Arrays;

public class MissingElemenInAnArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,7,6,8};
		
		Arrays.sort(arr);
		
		System.out.println("Given array after sorting");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			
		}		
		
		for (int i = 0; i < arr.length; i++) {

			int j = i+1;
			
			if ( j != arr[i]){
				
				System.out.println("Missing element is:");
				System.out.println(j);
				break;
			}
		}

	}

}
