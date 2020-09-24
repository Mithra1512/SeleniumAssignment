package week2.day2.assignment;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.manage().window().maximize();
		
//	Click button to travel home page
		
		driver.findElementByXPath("//button[text()='Go to Home Page']").click();
		
		driver.findElementByXPath("//a[@href='pages/Button.html']").click();
		
//	Find position of button (x,y)
		
		Point location = driver.findElementById("position").getLocation();
		
		System.out.println("Location of Get Position button is "+location);
		
//	Find button color
		
		String colour = driver.findElementByXPath("//button[contains(text(),'What color am I?')]").getAttribute("style");
		
		System.out.println("Colour of button: "+colour);
		
//	Find the height and width
		
		int height = driver.findElementByXPath("//button[text() = 'What is my size?']").getSize().height;
		
		System.out.println("Height of the button is "+height);
		
		int width = driver.findElementByXPath("//button[text() = 'What is my size?']").getSize().width;
		
		System.out.println("Height of the button is "+width);
		
		Thread.sleep(1000);
	}

}
