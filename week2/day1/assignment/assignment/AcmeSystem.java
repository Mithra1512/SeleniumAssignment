package week2.day1.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://acme-test.uipath.com/login");

		driver.manage().window().maximize();

		WebElement email = driver.findElementById("email");

		email.sendKeys("kumar.testleaf@gmail.com");

		WebElement password = driver.findElementById("password");

		password.sendKeys("leaf@12");
		
		driver.findElementByXPath("//button[@type='submit']").click();

		System.out.println(driver.getTitle());
		
		driver.findElementByPartialLinkText("Log Out").click();
		
		driver.close();
		
	}

}
