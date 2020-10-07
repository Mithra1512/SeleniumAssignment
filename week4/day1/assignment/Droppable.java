package week4.day1.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");

		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement draggable = driver.findElementById("draggable");
		
		WebElement droppable = driver.findElementById("droppable");
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(draggable,droppable).perform();
	}

}
