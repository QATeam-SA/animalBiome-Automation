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
		driver.findElement(By.xpath(prop.getProperty("My_Account"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("SignOut"))).click();
		Thread.sleep(5000);
		System.out.println("signedout successfully");
		logger.info("Existing user is sucessfully Successfully SignedOut");
	}
}
