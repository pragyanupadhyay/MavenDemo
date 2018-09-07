package ObjRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login
{
	@FindBy(id="email")
	public WebElement user_name;
	
	//driver.findElement(By.id("pass")).sendKeys("aBc@123");
	@FindBy(id="pass")
	public WebElement Password;
	@FindBy(linkText= "Forgotten account?")
	public WebElement forgot;
	@FindBy (how=How.CSS, using= "input[value='Log In']")
	public WebElement Login;
	
}
