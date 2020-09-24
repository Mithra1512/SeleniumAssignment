package week2.day2.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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

//	Creating lead with phone number 99

		driver.findElementByLinkText("Create Lead").click();

		driver.findElementById("createLeadForm_companyName").sendKeys("Mithra Sridhar");

		driver.findElementById("createLeadForm_firstName").sendKeys("Mithra");

		driver.findElementById("createLeadForm_lastName").sendKeys("Sridhar");

		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9934234509");

		driver.findElementByName("submitButton").click();

//	Searching using the given phone number and deleting

		driver.findElementByXPath("//a[text()='Find Leads']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Phone']").click();

		driver.findElementByName("phoneNumber").sendKeys("99");

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(3000);

		String leadId = driver.findElementByXPath("//a[@class='linktext'][contains(@href,'partyId')]").getText();

		driver.findElementByXPath("//a[@class='linktext'][contains(@href,'partyId')]").click();

		driver.findElementByXPath("//a[text()='Delete']").click();

//	Searching again to check if the lead is deleted
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();

		driver.findElementByXPath("//input[@name='id']").sendKeys(leadId);

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(4000);

		String displayMsg = driver.findElementByXPath("//div[@class='x-paging-info']").getText();

		System.out.println(displayMsg);

		if (displayMsg.contains("No records to display")) {

			System.out.println("Lead " + leadId + " is deleted successfully");

		}

		else {

			System.out.println("Lead " + leadId + " is not deleted yet");

		}

		driver.close();
	}

}
