package week4.day2.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Alert.html");

		driver.manage().window().maximize();

//	Click the button to display a alert box		
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
//	Click the button to display a confirm box.
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
		
		driver.switchTo().alert();
		
		alert.accept();
		
//	Click the button to display a prompt box.
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
		
		driver.switchTo().alert();
		
		alert.sendKeys("Wipro Tech");
		
		alert.accept();
		
//	Click the button to learn line-breaks in an alert
		
		driver.findElementByXPath("//button[text()='Line Breaks?']").click();
		
		driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
//	Click the below button and click OK.
		
		driver.findElementByXPath("//button[text()='Sweet Alert']").click();
		
		driver.findElementByXPath("//button[text()='OK']").click();		
		
		
	}

}
