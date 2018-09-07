package MyGroup.MavenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static WebDriver driver;
public WebDriver InitialiseDriver(String browser) throws IOException
{
	
	Properties prop=new Properties();
	
	FileInputStream fis=new FileInputStream("C:\\Users\\SAMSUNG\\workspace\\MavenDemo\\src\\main\\java\\MyGroup\\MavenDemo\\config.properties");
	
	prop.load(fis); 
	
	if(browser.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromePath") );
	
	driver= new ChromeDriver();
	
	}
	else if(browser.equals("firefox"))
	{
	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAMSUNG\\Desktop\\Selenium_downloads\\chromedriver_win32\\chromedriver.exe");
	
		System.setProperty("webdriver.gecko.driver",prop.getProperty("FirefoxPath") );
	
		driver= new FirefoxDriver();
	
	}
	return driver;


}
public void SetText(WebElement obj, String value)
	{
	obj.sendKeys(value);
	}
public void performclick(WebElement obj)
	{
	obj.click();
	}
public static void captureScreenShot(String filename)
{
	 
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try 
	{
	FileUtils.copyFile(src, new File("./Screenshot/"+filename+".png"));
	} 
	catch (IOException e)
	{
	System.out.println(e.getMessage());
	}
}

}

