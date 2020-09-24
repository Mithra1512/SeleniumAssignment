package week2.day2.assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Dropdown.html");

		driver.manage().window().maximize();

//	Select training program using Index

		WebElement trainingProgInd = driver.findElementById("dropdown1");

		Select trainingProgIndDD = new Select(trainingProgInd);

		trainingProgIndDD.selectByIndex(1);

//	Select training program using Text

		WebElement trainingProgTxt = driver.findElementByName("dropdown2");

		Select trainingProgTxtDD = new Select(trainingProgTxt);

		trainingProgTxtDD.selectByVisibleText("Selenium");

//	Select training program using Text	

		WebElement trainingProgVal = driver.findElementById("dropdown3");

		Select trainingProgValDD = new Select(trainingProgVal);

		trainingProgValDD.selectByValue("1");

//	Get the number of dropdown options

		WebElement NoOfDD = driver.findElementByClassName("dropdown");

		Select totalNoOfDD = new Select(NoOfDD);

		int size = totalNoOfDD.getOptions().size();

		System.out.println("Total number of options in the dropdown:" + size);

//	You can also use sendKeys to select		

		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[5]/select").sendKeys("Selenium");

	}

}
