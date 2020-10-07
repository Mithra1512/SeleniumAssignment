package week4.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Window.html");

		driver.manage().window().maximize();
		
//	Click button to open home page in New Window		
		driver.findElementByXPath("//button[text()='Open Home Page']").click();
		
//	Find the number of opened windows
		driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		
		Set<String> noOfWindows = driver.getWindowHandles();

		List<String> noOfWindowsList = new ArrayList<String>(noOfWindows);
		
		System.out.println("Number of open windows:"+noOfWindowsList.size());

//	Close all except this window
		for (int i = 1; i < noOfWindowsList.size(); i++) {
			
			driver.switchTo().window(noOfWindowsList.get(i));
			driver.close();
		}
		
//	Wait for 2 new Windows to open
		driver.switchTo().window(noOfWindowsList.get(0));
		
		driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
