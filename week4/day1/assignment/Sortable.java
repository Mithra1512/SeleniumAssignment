package week4.day1.assignment;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");

		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		
		Point item4Location = driver.findElementByXPath("//li[text()='Item 4']").getLocation();
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDropBy(item1,item4Location.x,item4Location.y).perform();

	}

}
