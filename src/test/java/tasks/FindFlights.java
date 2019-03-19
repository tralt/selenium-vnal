package tasks;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ui.HomePage;

public class FindFlights {
	WebDriver driver;
	HomePage tra;
	
	@Before
	public void init()
	{
//		System.setProperty("webdriver.chrome.driver", "G:\\SEDriver\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "G:\\SEDriver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies(); // delete all the cookie

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage tra = new HomePage(driver);
		tra.navigateHomePage();
	}
	
	@Test
	public void userFindFlights()
	{
		HomePage tra = new HomePage(driver);
		tra.selectAroundTrip();
		
//		tra.selectToDerpartCity("Ha Noi");
//		
//		tra.selectToReturnCity("Ho Chi Minh");
		
		tra.selectDepartCity("Hà Nội");
		
		tra.selectReyurnCity("Hồ Chí Minh");
		
		tra.selectStartDate("22-3-2019");
		
		tra.selectEndDate("20-4-2019");
		
		tra.selectNumberAdult("3");
		
		tra.selectNumberChild("1");
		
		tra.selectFind();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		Assert.assertEquals("Tìm vé trực tuyến | Vietnam Airlines", driver.getTitle());
	}
	
	@After
	public void finish()
	{
		driver.quit();
	}
}
