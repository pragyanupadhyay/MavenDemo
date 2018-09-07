package MyGroup.MavenDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ObjRepository.Login;

public class LoginTest extends BaseClass {
	
	@Test
	public void launch() throws IOException {
		
		BaseClass obj= new BaseClass();
		
		Properties prop=new Properties(); 
		
		FileInputStream fis=new FileInputStream("C:\\Users\\SAMSUNG\\workspace\\MavenDemo\\src\\main\\java\\MyGroup\\MavenDemo\\config.properties");
		
		prop.load(fis); 
		Xls_Reader excel= new Xls_Reader(prop.getProperty("ExeclPath"));
		
		driver=obj.InitialiseDriver(prop.getProperty("Browser"));
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("URL"));
	
		Login pg= PageFactory.initElements(driver, Login.class);
		
		//SetText(pg.user_name, prop.getProperty("UserName"));
		
		
		SetText(pg.user_name,excel.getCellData("TestData", "LoginID", 3));
		
		SetText(pg.Password,excel.getCellData("TestData", "Password", 3));
		
		captureScreenShot("facebook");
		
		excel.setCellData("TestData", "Status", 3, "Pass");
		
		
		
		//SetText(pg.Password, prop.getProperty("Password"));
		
		//performclick(pg.forgot);
		//performclick(pg.Login);
		
	}
	
	
}
