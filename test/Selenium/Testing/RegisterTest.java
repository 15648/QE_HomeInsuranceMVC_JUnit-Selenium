package Selenium.Testing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dulce\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:8080/HomeInsuranceMVC/");
		
		//Login
		WebElement registerHere = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr/td[3]/table/tbody/tr[6]/td/a"));
		registerHere.click();
		
		//Register.jsp form
		WebElement nameInput = driver.findElement(By.name("username"));
		nameInput.sendKeys("Batman");
		
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input"));
		passwordInput.sendKeys("Project123");
		
		WebElement repasswordInput = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[4]/td[2]/input"));
		repasswordInput.sendKeys("Project123");
		
		WebElement register = driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[5]/td[2]/input"));
		register.click();
	}
	
//	@AfterClass
//	public static void tearDown() throws InterruptedException {
//	driver.close();
//	}
	
	@Test
	public void registerTest() {
		Assert.assertEquals("http://localhost:8080/HomeInsuranceMVC/RegisterMe", driver.getCurrentUrl());
	}
	
	
}
