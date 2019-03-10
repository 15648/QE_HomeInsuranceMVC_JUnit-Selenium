package Selenium.Testing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetQuoteTest {
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
		
		//Get Quote
		WebElement getQuote = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[4]/a[1]/button"));
		getQuote.click();
		
		WebElement dropDownQuote1 = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td[2]/select"));
		Actions actionQuote1 = new Actions(driver);
		actionQuote1.moveToElement(dropDownQuote1).perform();
		WebDriverWait residenceType = new WebDriverWait(driver, 10);
	    WebElement singleFamily = residenceType.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td[2]/select/option[1]")));
	    singleFamily.click();
		
		WebElement address1Input = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/input"));
		address1Input.sendKeys("8013 N Macarthur Blvd");
		
		WebElement address2Input = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td[2]/input"));
		address2Input.sendKeys("Cross st");
		
		WebElement stateInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[4]/td[2]/input"));
		stateInput.sendKeys("TX");
		
		WebElement cityInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[5]/td[2]/input"));
		cityInput.sendKeys("Irving");
		
		WebElement zipInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[6]/td[2]/input"));
		zipInput.sendKeys("75063");
		
		WebElement dropDownQuote2 = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[7]/td[2]/select"));
		Actions actionQuote2 = new Actions(driver);
		actionQuote2.moveToElement(dropDownQuote2).perform();
		WebDriverWait residenceUse = new WebDriverWait(driver, 10);
	    WebElement primary = residenceUse.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[7]/td[2]/select/option[1]")));
	    primary.click();
	    
	    WebElement continueInfo = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[8]/td/input"));
		continueInfo.click();
	    
	    //Homeowner Information
		WebElement firstnameInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td[2]/input"));
		firstnameInput.sendKeys("Bob");
		
		WebElement lastnameInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/input"));
		lastnameInput.sendKeys("Smith");
		
		WebElement dobInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td[2]/input"));
		dobInput.sendKeys("1975-06-02");
		
		WebElement retiredNo = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[4]/td[2]/input[2]"));
		retiredNo.click();
		
		WebElement ssnInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[5]/td[2]/input"));
		ssnInput.sendKeys("123456789");
		
		WebElement emailInput = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[6]/td[2]/input"));
		emailInput.sendKeys("bob@email.com");
		
		WebElement continueDetails = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[7]/td/input"));
		continueDetails.click();
		
		//Property Details
		WebElement marketValueInput = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]/input"));
		marketValueInput.sendKeys("250000");
		
		WebElement yrBuiltInput = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
		yrBuiltInput.sendKeys("1995");
		
		WebElement sqftInput = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[3]/td[2]/input"));
		sqftInput.sendKeys("3000");
		
		WebElement dropDownDetails1 = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[4]/td[2]/select"));
		Actions actionDetails1 = new Actions(driver);
		actionDetails1.moveToElement(dropDownDetails1).perform();
		WebDriverWait dwellingStyle = new WebDriverWait(driver, 10);
	    WebElement story1 = dwellingStyle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[4]/td[2]/select/option[1]")));
	    story1.click();
	    
	    WebElement dropDownDetails2 = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[5]/td[2]/select"));
		Actions actionDetails2 = new Actions(driver);
		actionDetails2.moveToElement(dropDownDetails2).perform();
		WebDriverWait roof = new WebDriverWait(driver, 10);
	    WebElement concrete = roof.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[5]/td[2]/select/option[1]")));
	    concrete.click();
		
	    WebElement dropDownDetails3 = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[6]/td[2]/select"));
		Actions actionDetails3 = new Actions(driver);
		actionDetails3.moveToElement(dropDownDetails3).perform();
		WebDriverWait garage = new WebDriverWait(driver, 10);
	    WebElement detached = garage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[6]/td[2]/select/option[2]")));
	    detached.click();
	    
	    WebElement dropDownDetails4 = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/select"));
		Actions actionDetails4 = new Actions(driver);
		actionDetails4.moveToElement(dropDownDetails4).perform();
		WebDriverWait fullBaths = new WebDriverWait(driver, 10);
	    WebElement threeBaths = fullBaths.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[7]/td[2]/select/option[3]")));
	    threeBaths.click();
	    
	    WebElement dropDownDetails5 = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[8]/td[2]/select"));
		Actions actionDetails5 = new Actions(driver);
		actionDetails5.moveToElement(dropDownDetails5).perform();
		WebDriverWait halfBaths = new WebDriverWait(driver, 10);
	    WebElement oneBath = halfBaths.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[8]/td[2]/select/option[1]")));
	    oneBath.click();
	    
	    WebElement poolNo = driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input[2]"));
		poolNo.click();
	    
		//Coverage Details
		WebElement continueCoverageDetails= driver.findElement(By.xpath("/html/body/div[2]/form/table/tbody/tr/td/table/tbody/tr[10]/td/input"));
		continueCoverageDetails.click();
		
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
