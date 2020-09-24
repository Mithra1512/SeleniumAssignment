package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Link.html");

		driver.manage().window().maximize();

//	Go to Home Page

		driver.findElementByXPath("(//a[@href='../home.html'])[2]").click();

		driver.findElementByXPath("//a[@href='pages/Link.html']").click();

//	Find where am supposed to go without clicking me?

		String attributeValue = driver
				.findElementByXPath("//a[contains(text(),'Find where am supposed to go without clicking me?')]")
				.getAttribute("href");

		System.out.println(attributeValue);

//	Verify am I broken?

		driver.findElementByXPath("//a[contains(text(),'Verify am I broken?')]").click();

		String errorPageTitle = driver.getTitle();

		if (errorPageTitle.contains("Not Found")) {
			System.out.println("Given link is broken");
		}

		driver.navigate().back();

//	Go to Home Page (Interact with same link name)

		driver.findElementByXPath("//label[text()='(Interact with same link name)']/preceding-sibling::a").click();

		driver.navigate().back();
//	How many links are available in this page?

//		List<WebElement> links = driver.findElements(By.tagName("a"));

//		System.out.println("Number of links in page: " + links.size());

	}

}
