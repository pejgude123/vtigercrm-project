package common_utils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class WebDriverUtil {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handledropdown(WebElement element,String targetedelement) {
		
		Select s = new Select(element);
		s.selectByVisibleText(targetedelement);
	}
	
	public void mousehover(WebDriver driver,WebElement element) {
		
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	
	public void switchto(WebDriver driver,String targetedUrl)
	{
		Set<String> ids = driver.getWindowHandles();
		
		for (String a : ids) 
		{
			String actualurl = driver.switchTo().window(a).getCurrentUrl();
			
			 targetedUrl="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
			 if (actualurl.contains(targetedUrl))
			 {
				 break;
				
			}
			
		}
	}
	public File screenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		File destination=new File("./contact/cedit.png");
		FileUtils.copyFile(temp, destination);
		
		return destination;
	}

	
	}
	


