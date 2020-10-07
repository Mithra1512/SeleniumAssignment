package week4.day1.assignment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOddItem {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/selectable/");

		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		Actions builder = new Actions(driver);
		
		for (int i = 1; i <= 7; i=i+2) {
			
			driver.findElementByXPath("//ol[@id='selectable']/li["+i+"]").click();
			
			builder.keyDown(Keys.CONTROL).perform();
			
		}
		
		builder.keyUp(Keys.CONTROL).perform();
		

	}

}
