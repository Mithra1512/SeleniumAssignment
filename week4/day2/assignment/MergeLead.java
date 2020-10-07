package week4.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		WebElement username = driver.findElementByXPath("//input[@name='USERNAME' and @size='50']");

		username.sendKeys("demosalesmanager");

		WebElement password = driver.findElementByXPath("(//input[contains(@class,'input')])[2]");

		password.sendKeys("crmsfa");

		driver.findElementByXPath("//input[@class = 'decorativeSubmit' and @type = 'submit']").click();

		driver.findElementByXPath("//a[contains(text(),'CRM')]").click();

		driver.findElementByLinkText("Leads").click();
		
		
//	Creating two leads to merge
		List<String> leadID = new ArrayList<String>();
		
		for (int i = 0; i < 2; i++) {
			driver.findElementByLinkText("Create Lead").click();

			driver.findElementById("createLeadForm_companyName").sendKeys("Testing Tech");

			driver.findElementById("createLeadForm_firstName").sendKeys("Automation");

			driver.findElementById("createLeadForm_lastName").sendKeys("Merge Lead "+(i+1));

			driver.findElementByName("submitButton").click();
			
			String compNameLeadID = driver.findElementById("viewLead_companyName_sp").getText();
			
			leadID.add(compNameLeadID.substring(compNameLeadID.indexOf("(")+1,compNameLeadID.indexOf(")")));
		}
		
//	Merging two leads
		driver.findElementByXPath("//a[text()='Merge Leads']").click();

		driver.findElementByXPath("//img[@alt='Lookup']").click();

//	For From Lead look up window 
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windowHandlesList = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowHandlesList.get(1));

		driver.findElementByXPath("//label[contains(text(),'Lead ID')]/following-sibling::div/input").sendKeys(leadID.get(0));

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(3000);

		driver.findElementByXPath("//a[@class='linktext'][contains(@href,'"+leadID.get(0)+"')]").click();

		driver.switchTo().window(windowHandlesList.get(0));

		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		
//	For To Lead look up window
		windowHandles = driver.getWindowHandles();

		windowHandlesList = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowHandlesList.get(1));

		driver.findElementByXPath("//label[contains(text(),'Lead ID')]/following-sibling::div/input").sendKeys(leadID.get(1));

		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(3000);

		driver.findElementByXPath("//a[@class='linktext'][contains(@href,'"+leadID.get(1)+"')]").click();
		
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.findElementByXPath("//a[text()='Merge']").click();

//	Accepting the alert
		Alert alert = driver.switchTo().alert();
		
		alert.accept();		
		
//	Searching again to check merging
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		driver.findElementByXPath("//label[contains(text(),'Lead ID')]/following-sibling::div/input").sendKeys(leadID.get(0));

		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		String displayMsg = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		
		if (displayMsg.contains("No records to display")) {

			System.out.println("Lead " + leadID.get(0) + " is merged successfully into "+leadID.get(1));

		}

		else {

			System.out.println("Merging not successful");

		}

		driver.close();

	}

}
