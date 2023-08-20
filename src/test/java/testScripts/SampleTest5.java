package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;

public class SampleTest5 {
	WebDriver driver;
	
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setUpExtenetReport() {
	extentReports = new ExtentReports();
	spark = new ExtentSparkReporter("test-output/SparkReport.html");
	extentReports.attachReporter(spark);
	
	}
	
	@BeforeMethod
	public void launchGoogle() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test()
	public void searchJava() {
		extentTest = extentReports.createTest("Serach Java");
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(),"Google");
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Java Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		softassert.assertEquals(driver.getTitle(), "Java Tutorials - Google Search");
		softassert.assertAll();
	}
	@Test
	public void searchAppium() {
		extentTest = extentReports.createTest("Serach Appium");
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(),"Google");
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Appium Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		softassert.assertEquals(driver.getTitle(), "Appium Tutorials - Google Search");
		softassert.assertAll();
	}
	@Test
	public void searchCucumber() {
		extentTest = extentReports.createTest("Serach Cucumber");
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(),"Google");
		WebElement srcBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		srcBox.clear();
		srcBox.sendKeys("Cucumber Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		softassert.assertEquals(driver.getTitle(), "Cucumber Tutorials - Google Search Page");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus())
			extentTest.fail(result.getThrowable().getMessage());
			String path = Utility.getScreenshotPath(driver);
			extentTest.addScreenCaptureFromPath(path);
		driver.close();
	}
	@AfterTest
	public void finishExtenet() {
		extentReports.flush();
	}

}
