package testScripts;

import java.io.FileInputStream;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class loginPageTest {
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void setUp() throws IOException {
		
		String path = System.getProperty("user.dir")+ "//src//resource//configure.properties";
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
	
	@Test(dataProvider = "loginData")
	public void ValidLogin(String strusername , String strPassword) {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(strusername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean idsp = driver.findElement(By.xpath("//div[@class='flash success']")).isDisplayed();
		Assert.assertTrue(idsp);
		
		
		
	}
	
	@DataProvider(name = "loginData")
	 public Object[][] getData() throws CsvValidationException, IOException
	{
		String path = System.getProperty("user.dir")+"src//resource//testData//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String arr[];
		ArrayList<Object> dataList = new ArrayList<Object>();
		while((arr=reader.readNext()) != null ) {
			Object [] record = {arr[0], arr[1]};
			dataList.add(record);
						
		}
				
		return dataList.toArray(new Object[dataList.size()][]);
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		
		
	}

}
