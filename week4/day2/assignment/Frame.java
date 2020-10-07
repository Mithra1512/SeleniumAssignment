package week4.day2.assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {

		int count = 0;

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/frame.html");

		driver.manage().window().maximize();

//	I am inside a frame		
		WebElement frame1 = driver.findElementByXPath("//iframe[@src='default.html']");

		driver.switchTo().frame(frame1);

		driver.findElementById("Click").click();

//	I am inside a nested frame
		driver.switchTo().parentFrame();

		WebElement nestedParentFrame = driver.findElementByXPath("//iframe[@src='page.html']");

		driver.switchTo().frame(nestedParentFrame);

		driver.switchTo().frame("frame2");

		driver.findElementById("Click1").click();

//	Find total number of frames

		driver.switchTo().defaultContent();

		List<WebElement> noOfFrames = driver.findElementsByTagName("iframe");

		count = count + noOfFrames.size();

		for (int i = 0; i < noOfFrames.size(); i++) {

			driver.switchTo().frame(noOfFrames.get(i));

			int size = driver.findElementsByTagName("iframe").size();

			if (size != 0) {

				count = count + size;

			}

			driver.switchTo().defaultContent();

		}
		
		System.out.println("Total number of frames: " + count);
	}

}
