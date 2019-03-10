package Selenium.Testing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewPolicyTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeInsuranceMVC/");
		
		//Login
		WebElement nameInput = driver.findElement(By.name("username"));
		nameInput.sendKeys("Batman");
		
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr/td[3]/table/tbody/tr[4]/td[2]/input"));
		passwordInput.sendKeys("Project123");
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr/td[3]/table/tbody/tr[5]/td/p/input"));
		login.click();
		
		//View Policy
		WebElement policy = driver.findElement(By.xpath("//*[@id=\"header\"]/p/a[4]"));
		policy.click();
		
		//Logout
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"header\"]/p/a[5]"));
		logout.click();
		
	}
	
//	@AfterClass
//	public static void tearDown() throws InterruptedException {
//	driver.close();
//	}
	
	@Test
	public void logoutTest() {
		Assert.assertEquals("http://localhost:8080/HomeInsuranceMVC/Logout", driver.getCurrentUrl());
	}
	
}
