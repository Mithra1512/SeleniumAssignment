package week2.day2.assignment;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/radio.html");

		driver.manage().window().maximize();
		
//	Are you enjoying the classes?

		driver.findElementById("yes").click();
		
//	Find default selected radio button

		if (driver.findElementByXPath("//label[@for='Unchecked']/input").isSelected()) {

			System.out.println("Unchecked radio button is default");

		}

		if (driver.findElementByXPath("//label[@for='Checked']/input").isSelected()) {

			System.out.println("Checked radio button is default");

		}

//	Select your age group (Only if choice wasn't selected)
		
		boolean selectedOption = driver.findElementByXPath("//input[@value='1'][@name='age']").isSelected();

		if (selectedOption) {
			System.out.println("My age group option is already selected");
		}

	}

}
