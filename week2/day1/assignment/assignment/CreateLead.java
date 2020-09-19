package week2.day1.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();

		WebElement username = driver.findElementById("username");

		username.sendKeys("demosalesmanager");

		WebElement password = driver.findElementById("password");

		password.sendKeys("crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();

		driver.findElementByLinkText("Leads").click();

		driver.findElementByLinkText("Create Lead").click();

		driver.findElementById("createLeadForm_companyName").sendKeys("Mithra Sridhar");

		driver.findElementById("createLeadForm_firstName").sendKeys("Mithra");

		driver.findElementById("createLeadForm_lastName").sendKeys("Sridhar");

//		Source

		WebElement source = driver.findElementById("createLeadForm_dataSourceId");

		Select dropdownSource = new Select(source);

		dropdownSource.selectByVisibleText("Employee");

//		Marketing Campaign ID

		WebElement marketingCampaignId = driver.findElementById("createLeadForm_marketingCampaignId");

		Select dropdownCampaignId = new Select(marketingCampaignId);

		dropdownCampaignId.selectByValue("9001");

//		Industry

		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");

		Select dropdownIndustry = new Select(industry);

		int industrySize = dropdownIndustry.getOptions().size();

		dropdownIndustry.selectByIndex(industrySize - 2);

//		Ownership
		WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");

		Select dropdownOwnership = new Select(ownership);

		int ownershipSize = dropdownOwnership.getOptions().size();

		dropdownOwnership.selectByIndex(ownershipSize - 2);

//		Country

		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");

		Select dropdownCountry = new Select(country);

		dropdownCountry.selectByVisibleText("India");

		driver.findElementByName("submitButton").click();

		System.out.println(driver.getTitle());

	}

}
