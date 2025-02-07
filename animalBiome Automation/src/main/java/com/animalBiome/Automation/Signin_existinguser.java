package com.animalBiome.Automation;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.animalbiome.PropertiesFile;

public class Signin_existinguser {
	Logger logger = LogManager.getLogger(Signin_existinguser.class);
	WebDriver driver = Instance.getInstance();
	Properties prop = PropertiesFile.readPropertyFile("Signin_existinguser.properties");
	
	@Test(priority=2, enabled=true)
	public void signin() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(prop.getProperty("emailid"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(prop.getProperty("pswd"));
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("signIn"))).click();
		Thread.sleep(5000);
		System.out.println("SignedIn Successfull");
		logger.info("Existing user is sucessfully Successfully SignedIn");	
	}

}
