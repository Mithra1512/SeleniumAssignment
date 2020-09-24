package week2.day2.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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

//	Creating lead with email address

		driver.findElementByLinkText("Create Lead").click();

		driver.findElementById("createLeadForm_companyName").sendKeys("Mithra Sridhar");

		driver.findElementById("createLeadForm_firstName").sendKeys("Mithra");

		driver.findElementById("createLeadForm_lastName").sendKeys("Sridhar");

		driver.findElementById("createLeadForm_primaryEmail").sendKeys("mithrasridhar@gmail.com");

		driver.findElementByName("submitButton").click();

//	Searching for lead with given mail address
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Email']").click();

		driver.findElementByName("emailAddress").sendKeys("mithrasridhar@gmail.com");

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(3000);

		String leadFirstName = driver.findElementByXPath("(//a[@class='linktext'][contains(@href,'viewLead')])[3]")
				.getText();

		String leadLastName = driver.findElementByXPath("(//a[@class='linktext'][contains(@href,'viewLead')])[4]")
				.getText();

		driver.findElementByXPath("//a[@class='linktext'][contains(@href,'viewLead')]").click();

//	Duplicating the given lead and checking the name with the original lead
		
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();

		String pageTitle = driver.getTitle();

		if (pageTitle.contains("Duplicate Lead")) {

			System.out.println("Page title is correct");
		}

		driver.findElementByName("submitButton").click();

		Thread.sleep(2000);

		String dupLeadFirstName = driver.findElementById("viewLead_firstName_sp").getText();

		String dupLeadLastName = driver.findElementById("viewLead_lastName_sp").getText();

		if (leadFirstName.equals(dupLeadFirstName)) {

			System.out.println("Original Lead First name matches with Duplicate Lead First name");
		}

		if (leadLastName.equals(dupLeadLastName)) {

			System.out.println("Original Lead Last name matches with Duplicate Lead Last name");
		}

		driver.close();
	}

}
