package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createUser {
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void setUp() throws IOException {
		
		String path = System.getProperty("user.dir")+ "//src//resource//newSite//config.properties";
		prop = new Properties();
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		String strBrowser = prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		
	}
	@Test
	public void validLogin() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jhuma.dey.happylife@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Jhuma@88");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	}
	
	@Test
	public void createUser() {
		driver.findElement(By.xpath("//i[@class='users icon']")).click();
		driver.findElement(By.xpath("//button[@class='ui linkedin button' and contains(text(),'Create')]"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
