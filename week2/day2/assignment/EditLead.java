package week2.day2.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

//	Searching for lead by giving First name

		driver.findElementByXPath("//a[text()='Find Leads']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Mithra");

		Thread.sleep(2000);

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(3000);

		driver.findElementByXPath("//a[@class='linktext'][contains(@href,'partyId')]").click();

		Thread.sleep(1000);

		String title = driver.getTitle();

		if (title.equals("View Lead | opentaps CRM")) {

			System.out.println("Title is valid");

		}

//	Editing the Company name
		driver.findElementByXPath("//a[text()='Edit']").click();

		String compNameToBeEdited = "Wipro Tech";

		driver.findElementById("updateLeadForm_companyName").clear();
	
		driver.findElementById("updateLeadForm_companyName").sendKeys(compNameToBeEdited);

		driver.findElementByXPath("//input[@value='Update']").click();

		String editedCompanyName = driver.findElementById("viewLead_companyName_sp").getText();

		if (editedCompanyName.contains(compNameToBeEdited)) {

			System.out.println("Company name is valid");
		}

		driver.close();

	}

}
