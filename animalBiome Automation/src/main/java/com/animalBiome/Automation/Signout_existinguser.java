package com.animalBiome.Automation;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.animalbiome.PropertiesFile;

public class Signout_existinguser {
	Logger logger = LogManager.getLogger(Signout_existinguser.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Signout_existinguser.properties");
	
	@Test(priority=3, enabled=true)
	public void signout() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(prop.getProperty("baseURL"));
		Thread.sleep(5000);
		driver.switchTo(); //switching to pop-up
		driver.findElement(By.xpath(prop.getProperty("Accesscode"))).sendKeys(prop.getProperty("Authkey"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("Acessbutton"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(prop.getProperty("emailid"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(prop.getProperty("pswd"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("signIn"))).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("My_Account"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("SignOut"))).click();
		Thread.sleep(5000);
		System.out.println("signedout successfully");
		logger.info("Existing user is sucessfully Successfully SignedOut");
		driver.quit();
	}
}
