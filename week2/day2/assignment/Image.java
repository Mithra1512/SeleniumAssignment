package week2.day2.assignment;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Image.html");

		driver.manage().window().maximize();

//	Click on this image to go home page

		driver.findElementByXPath("//label[@for='home']/following-sibling::img").click();

		driver.navigate().back();

//	Am I Broken Image?
		String brokenImage = driver.findElementByXPath("//label[@for='position']/following-sibling::img")
				.getAttribute("onclick");

		if (brokenImage == null) {
			System.out.println("Image is broken");
		}

	}

}
