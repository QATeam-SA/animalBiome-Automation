package propertiesFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFile {
	public WebDriver driver;
	public Properties prop = new Properties();
	public FileReader input;
	
	@BeforeTest
	public void setUp()throws IOException, InterruptedException {
		if(driver== null) {	
			 {
				FileReader input = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\aB_datafile.properties");
				prop.load(input);
			}
			 if(prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get(prop.getProperty("baseUrl"));
					
				}
				else if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.get(prop.getProperty("baseUrl"));
					
				}
			 }
	}
	@AfterTest	
	public void tearDown() {
			System.out.println("Browser Opened Successfully");
}
	}
