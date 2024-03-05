package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class VVV
{
PropertyFileUtil putil=new PropertyFileUtil();
WebDriverUtil wutil=new WebDriverUtil();
ExcelUtil eutil=new ExcelUtil();
JavaUtil jutil=new JavaUtil();
@Test
	public void mm() throws IOException
	{
WebDriver driver=new ChromeDriver();
		
		String URL = putil.getDataFromPropertyFile("Url");
		String USER = putil.getDataFromPropertyFile("Username");
		String PASS = putil.getDataFromPropertyFile("Password");
		String First = eutil.getDataFromExcel("Contacts", 0, 1);
		String LAST = eutil.getDataFromExcel("Contacts", 1, 1);
		String ORG = eutil.getDataFromExcel("Contacts", 3, 1);
		String GROUP = eutil.getDataFromExcel("Contacts", 2, 1);
        driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USER);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(First);
		driver.findElement(By.name("lastname")).sendKeys(LAST);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		wutil.switchto(driver, URL);
		driver.findElement(By.id("search_txt")).sendKeys(ORG+Keys.ENTER);
		driver.findElement(By.linkText("intel74")).click();
		
		String urlll="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		wutil.switchto(driver, urlll);
		
		driver.findElement(By.cssSelector("input[value='T']")).click();
		driver.findElement(By.name("assigned_group_id")).sendKeys(GROUP);
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		wutil.screenshot(driver);
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
	
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		


		
	}

}
