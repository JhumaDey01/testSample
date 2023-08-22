package testScripts;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.codec.binary.Base64;


public class CDPTest {
	ChromeDriver driver;
	DevTools devtools;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		devtools = driver.getDevTools();
		devtools.createSession();
	}
	@Test
	public void viewPortTest() {
		Map deviceMetrices = new HashMap() {{
			put("width", 600);
			put("height", 1000);
			put("deviceScaleFeature", 500);
			put("mobile",true);
		}};
			driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrices);
			driver.get("https://www.selenium.dev/");
		
		
	}
	@Test
	public void basicAuthTest() {
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		Map<String, Object> headers = new HashMap<>();
		String strUser = "admin";
		String strPwd = "admin";
		String basicAuth = "Basic "+new String( new Base64()).encode(String.format("%s:%s", strUser,strPwd).getBytes()));
		
				
	}

}
