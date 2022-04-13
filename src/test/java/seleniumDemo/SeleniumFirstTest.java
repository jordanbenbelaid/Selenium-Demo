package seleniumDemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumFirstTest {

	private static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		// Identifies which driver we will be using
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		ChromeOptions cOptions = new ChromeOptions();

		//Sets our driver window to headless
		cOptions.setHeadless(false);
		
		//Config for cookie management, where 2=true, and 1=false
		cOptions.setCapability("profile.default_content_setting_values.cookies", true);
		cOptions.setCapability("network.cookie.cookieBehaviour", true);
		cOptions.setCapability("profile.block_third_party_cookies", false);
		
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		try {
				driver.get("http://www.google.com");
		} catch(TimeoutException e) {
			System.out.println("Page:  google.com did not load within 30 seconds");
		}
	}
	
	@Test
	public void findKittens() {
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
	}

}
