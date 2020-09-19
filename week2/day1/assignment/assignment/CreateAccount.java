package week2.day1.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		
		WebElement username = driver.findElementById("username");

		username.sendKeys("demosalesmanager");

		WebElement password = driver.findElementById("password");

		password.sendKeys("crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Accounts").click();
		
		driver.findElementByLinkText("Create Account").click();
		
		driver.findElementByXPath("//*[@id=\"accountName\"]").sendKeys("Debit Limited Account");
		
		driver.findElementByName("description").sendKeys("Selenium Automation Tester");
		
		driver.findElementById("groupNameLocal").sendKeys("Automation Tester");
		
		driver.findElementById("officeSiteName").sendKeys("Automation Tester");
		
		driver.findElementById("annualRevenue").sendKeys("10000");

		WebElement industry = driver.findElementByName("industryEnumId");

		Select dropdownIndustry = new Select(industry);

		dropdownIndustry.selectByVisibleText("Computer Software");
		
		WebElement ownership = driver.findElementByName("ownershipEnumId");

		Select dropdownOwnership = new Select(ownership);

		dropdownOwnership.selectByVisibleText("S-Corporation");
		
		WebElement source = driver.findElementById("dataSourceId");

		Select dropdownSource = new Select(source);

		dropdownSource.selectByValue("LEAD_EMPLOYEE");
		
		WebElement marketingCampaignId = driver.findElementById("marketingCampaignId");

		Select dropdownCampaignId = new Select(marketingCampaignId);

		int campaignIdSize = dropdownCampaignId.getOptions().size();

		dropdownCampaignId.selectByIndex(campaignIdSize - 3);
		
		WebElement state = driver.findElementByName("generalStateProvinceGeoId");

		Select dropdownState = new Select(state);

		dropdownState.selectByValue("TX");
		
		driver.findElementByClassName("smallSubmit").click();

	}

}
