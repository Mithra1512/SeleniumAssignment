package week1.day2.assignment;

public class SwitchOperator {

	public static void main(String[] args) {

		int num1 = 10, num2 = 5;

		String operation = "add";

		switch (operation) {
		case "add":
			System.out.println("Sum of "+num1+" and "+num2+" is "+(num1 + num2));
			break;
		case "sub":
			System.out.println("Difference between "+num1+" and "+num2+" is "+(num1 - num2));
			break;
		case "mul":
			System.out.println("Product of "+num1+" and "+num2+" is "+(num1 * num2));
			break;
		case "div":
			System.out.println("Quotient of "+num1+" and "+num2+" is "+(num1 / num2));
			break;
		default:
			System.out.println("Not a valid operation");
			break;
		}

	}

}
