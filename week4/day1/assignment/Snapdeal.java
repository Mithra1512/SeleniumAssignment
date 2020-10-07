package week4.day1.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();
		
		WebElement menFashion = driver.findElementByXPath("//span[@class='catText'][contains(text(),'Men')]");
		
		WebElement shirts = driver.findElementByXPath("//a[@href='https://www.snapdeal.com/products/men-apparel-shirts']/span");

		Actions builder = new Actions(driver);
		
		builder.moveToElement(menFashion).moveToElement(shirts).click().perform();
		
		WebElement firstShirt = driver.findElementByXPath("//div[@class='product-tuple-image ']");
		
		builder.moveToElement(firstShirt).perform();
		
		WebElement quickView = driver.findElementByXPath("//div[contains(text(),'Quick View')]");
		
		quickView.click(); 
		
	}

}
