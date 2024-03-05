package common_utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Base {
	
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil=new PropertyFileUtil();
	public WebDriver driver;
	
@BeforeSuite
public void bs()
{
	System.out.println("connect to the datatbase");
}
@BeforeClass
public void Bc() throws IOException
{
	String URL = putil.getDataFromPropertyFile("Url");
	WebDriver drive = new ChromeDriver();
	wutil.maximize(driver);
	//wutil.implicitwait(driver);
	drive.get(URL);
	
}
@BeforeMethod
public void BM() throws IOException
{
	//@it is used to login to the application
	String USERNAME =putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	
	
}
@AfterSuite
public void AfterMethod()
{
	//@after method is used to signout from the application
	//Mousehover on image
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
		
		//Click on Signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}
@AfterMethod
public void AfterClass()
{
driver.quit();	
}
public void AfterSuit()
{
	System.out.println("disconnect from the database");
	}

}
