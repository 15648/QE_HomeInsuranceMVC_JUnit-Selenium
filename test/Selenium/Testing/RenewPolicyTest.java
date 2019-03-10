package Selenium.Testing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RenewPolicyTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeInsuranceMVC/");
		
		//Login
		WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr/td[3]/table/tbody/tr[7]/td/a"));
		login.click();
		
		//Admin Login
		WebElement nameInput = driver.findElement(By.name("username"));
		nameInput.sendKeys("John");
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/form/p/input[2]"));
		passwordInput.sendKeys("john1234");
		
		WebElement loginAdmin = driver.findElement(By.xpath("/html/body/form/p/input[3]"));
		loginAdmin.click();
		
		//Search User
		WebElement searchInput = driver.findElement(By.xpath("/html/body/center/form/input[1]"));
		searchInput.sendKeys("Batman");
		
		WebElement search = driver.findElement(By.xpath("/html/body/center/form/input[2]"));
		search.click();
		
		//Renew Policy
		WebElement renew= driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[8]/a[2]/button"));
		renew.click();
		
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
