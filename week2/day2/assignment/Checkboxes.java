package week2.day2.assignment;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/checkbox.html");

		driver.manage().window().maximize();

//	Select the languages that you know?
		driver.findElementByXPath("//div[text()='Java']/input").click();

		driver.findElementByXPath("//div[text()='C++']/input").click();

		driver.findElementByXPath("//div[text()='SQL']/input").click();

//	Confirm Selenium is checked	
		boolean selSelected = driver.findElementByXPath("//div[text()='Selenium']/input").isSelected();

		if (selSelected) {

			System.out.println("Selenium checkbox is selected");
		}
		
//	DeSelect only checked
		boolean notSelected = driver.findElementByXPath("//div[text()='Not Selected']/input").isSelected();
		
		boolean selected = driver.findElementByXPath("//div[text()='I am Selected']/input").isSelected();
		
		if (selected) {
			System.out.println("'I am selected' Checkbox is selected");
		}
		
		if(notSelected) {
			
			System.out.println("'Not selected' Checkbox is selected");
		}
	
//	Select all below checkboxes
		
		for (int i = 1; i <= 5; i++) {
			
			driver.findElementByXPath(("(//div[contains(text(),'Option')]/input)["+i+"]")).click();
		}
		
	}

}
