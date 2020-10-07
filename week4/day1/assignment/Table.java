package week4.day1.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {

		String allProgress;

		List<String> allProgressList = new ArrayList<String>();
		
		List<Integer> allProgressListInt = new ArrayList<Integer>();

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");

		driver.manage().window().maximize();
		
//	Get the count of number of columns and rows

		int noOfRows = driver.findElementsByXPath("//table[@id='table_id']//tr/th").size();

		System.out.println("Number of Rows:" + noOfRows);

		int noOfcolumns = driver.findElementsByXPath("//table[@id='table_id']//tr").size();

		System.out.println("Number of Columns:" + noOfcolumns);
		
//	Get the progress value of 'Learn to interact with Elements

		for (int i = 2; i <= noOfcolumns; i++) {

			String learningDetail = driver.findElementByXPath("//table[@id='table_id']//tr[" + i + "]/td").getText();

			if (learningDetail.contains("Learn to interact")) {

				String progress = driver.findElementByXPath("//table[@id='table_id']//tr[" + i + "]/td/following-sibling::td")
						.getText();
				System.out.println(progress);
			}

		}
		
//	Check the vital task for the least completed progress 

		for (int i = 2; i <= noOfcolumns; i++) {

			allProgress = driver.findElementByXPath("//table[@id='table_id']//tr[" + i + "]/td[2]").getText();

			allProgressList.add(allProgress.substring(0, allProgress.length() - 1));

		}

		for (String stringProgress : allProgressList) {
			
			allProgressListInt.add(Integer.parseInt(stringProgress));
			
		}

		Collections.sort(allProgressListInt);
		
		driver.findElementByXPath("//td[contains(text(),'"+allProgressListInt.get(0)+"')]//following-sibling::td/input").click();
		
	}

}
