package week2.day2.assignment;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Edit.html");

//	Enter your email address

		driver.findElementById("email").sendKeys("mithrasridhar@gmail.com");

//	Append a text and press keyboard tab

		driver.findElementByXPath("//input[contains(@value,'Append')]").sendKeys("Hi");

//	Get default text entered

		String defText = driver.findElementByXPath("//input[@name='username' and @value='TestLeaf']")
				.getAttribute("value");

		System.out.println(defText);

//	Clear the text

		driver.findElementByXPath("(//input[@name='username'])[2]").clear();

//	Confirm that edit field is disabled

		boolean disabled = driver.findElementByXPath("(//input[@type='text'])[5]").isEnabled();

		if (disabled == false) {
			System.out.println("Field is disabled");
		}

		Thread.sleep(1000);

	}

}
