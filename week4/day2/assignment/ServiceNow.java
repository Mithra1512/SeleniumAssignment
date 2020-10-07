package week4.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dev68594.service-now.com/");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

		driver.manage().window().maximize();
		
		driver.switchTo().frame("gsft_main");

		driver.findElementById("user_name").sendKeys("admin");
		
		driver.findElementById("user_password").sendKeys("India@123");
		
		driver.findElementById("sysverb_login").click();
		
		Thread.sleep(5000);
	
		driver.findElementById("filter").sendKeys("incident");
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("(//div[text()='All'])[2]").click();
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("sysverb_new").click();
		
		driver.findElementById("lookup.incident.caller_id").click();
		
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys("Justina Dragaj");
		
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);
		
		driver.findElementByXPath("//a[text()='Justina Dragaj']").click();
		
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElementById("incident.short_description").sendKeys("Short description 1");
		
		String incidentNumber = driver.findElementById("incident.number").getAttribute("value");
		
		driver.findElementById("sysverb_insert_bottom").click();
		
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(incidentNumber);
		
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(Keys.ENTER);
			
	}

}
