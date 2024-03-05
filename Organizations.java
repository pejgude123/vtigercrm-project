package vtigercrm;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common_utils.ExcelUtil;
import common_utils.JavaUtil;
import common_utils.Lister_Implimentation;
import common_utils.PropertyFileUtil;
import common_utils.WebDriverUtil;
@Listeners(Lister_Implimentation.class)
public class Organizations {
	
	
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	PropertyFileUtil putil=new PropertyFileUtil();
	
	@Test
	public void OrganizationTest() throws IOException, InterruptedException {
		
		
	WebDriver drive = new ChromeDriver();	
	//To maximize the window
	//wutil.maximize(driver);
	//To apply wait for findelement()
	//wutil.implicitwait(driver);
	
	//To read data from Property File
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME =putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	//To read data from Excel File
	String ORGNAME = eutil.getDataFromExcel("organizations", 0, 1);
	String GROUP = eutil.getDataFromExcel("organizations", 1, 1);
	
	
	//To launch the application
	drive.get(URL);
	
	// Login to application 
	drive.findElement(By.name("user_name")).sendKeys(USERNAME);
	drive.findElement(By.name("user_password")).sendKeys(PASSWORD);
	drive.findElement(By.id("submitButton")).click();
	
	//Click on Organization
	drive.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Click on Create Organization..(+)
	drive.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//Enter Organization Name
	drive.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//In AssignedTo Click on Group
	drive.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select Support group
	WebElement dropdown = drive.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(dropdown, GROUP);
	
	//Click on Save Button
	drive.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	Thread.sleep(2000);
	
	//Mousehover on image
	WebElement image = drive.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	wutil.mousehover(drive, image);
	
	//Click on Signout
	drive.findElement(By.xpath("//a[text()='Sign Out']")).click();

}
}
