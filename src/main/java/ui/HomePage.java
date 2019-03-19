package ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='loaive_r']")
	WebElement AROUND_TRIP;
	
	@FindBy(xpath="//input[@id='departCity']")
	WebElement FROM;
	
	@FindBy(xpath="//div[@aria-labelledby='ui-id-1']")
	WebElement DIALOG_FROM;
	
	@FindBy(xpath="//input[@id='returnCity']")
	WebElement TO;
	
	@FindBy(xpath="//div[@aria-labelledby='ui-id-2']")
	WebElement DIALOG_TO;
	
	@FindBy(xpath="//input[@id='flights-checkin']")
	WebElement START_DATE;
	
	@FindBy(xpath="//input[@id='flights-checkout']")
	WebElement END_DATE;
	
	
	@FindBy(xpath="//select[@id='adult']")
	WebElement NUMBER_ADULT;
	
	@FindBy(xpath="//select[@id='child']")
	WebElement NUMBER_CHILD;
	
	@FindBy(xpath="//input[@id='cmdsearch']")
	WebElement FIND_FLIGHTS;
	
	
	
	public void navigateHomePage()
	{
		driver.get("https://vietnamairslines.com/");
	}
	
	public void selectAroundTrip()
	{
		AROUND_TRIP.click();
	}
	
//	public void selectToDerpartCity(String city)
//	{
//		WebElement SUGGESTION = driver.findElement(By.xpath("//ul[@id='ui-id-3']"));
//		WebElement SEARCH_BOX = driver.findElement(By.xpath("//input[@id='airport']"));
//		FROM.click();
//		driver.switchTo().activeElement();
//		
//		SEARCH_BOX.sendKeys(city);
//		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//		driver.switchTo().frame(SUGGESTION);
//		SEARCH_BOX.sendKeys(Keys.ARROW_DOWN);
//		SEARCH_BOX.sendKeys(Keys.ENTER);
//	}
//	
//	
//	public void selectToReturnCity(String city)
//	{
//		WebElement SUGGESTION = driver.findElement(By.xpath("//ul[@id='ui-id-4']"));
//		WebElement SEARCH_BOX = driver.findElement(By.xpath("//input[@id='airportres']"));
//		FROM.click();
//		driver.switchTo().activeElement();
//		
//		SEARCH_BOX.sendKeys(city);
//		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//		driver.switchTo().frame(SUGGESTION);
//		SEARCH_BOX.sendKeys(Keys.ARROW_DOWN);
//		SEARCH_BOX.sendKeys(Keys.ENTER);
//	}
	
	public void selectDepartCity(String cityName)
	{
		FROM.click();
			List<WebElement> cityList = DIALOG_FROM.findElements(By.xpath("//*[@id=\"sbquocnoi\"]/ul/li/a/b"));
			for(WebElement city : cityList)
			{
				if(city.getText().equals(cityName))
				{
					city.click();
					break;
				}
			}
	}
	
	public void selectReyurnCity(String cityName)
	{
		List<WebElement> noidiaList = DIALOG_TO.findElements(By.xpath("//div[@id='sbquocnoi']/ul[@class='alignleft']"));
		FROM.click();
		for(WebElement area : noidiaList)
		{
			List<WebElement> cityList = DIALOG_TO.findElements(By.xpath("//*[@id=\"sbquocnoi\"]/ul/li/a/b"));
			for(WebElement city : cityList)
			{
				if(city.getText().equals(cityName))
				{
					city.click();
					break;
				}
			}
		}
	}
	
	
	public void selectDateByJS(WebDriver driver, WebElement element, String dateVal)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value, '"+dateVal+"');", element);
		
	}
	
	public void selectStartDate(String date)
	{
		String dateVal = date;
		selectDateByJS(driver, START_DATE, dateVal);
	}
	
	public void selectEndDate(String date)
	{
		String dateVal = date;
		selectDateByJS(driver, END_DATE, dateVal);
	}
	
	public void selectNumberAdult(String num)
	{
		Select drpNumber = new Select(NUMBER_ADULT);
		drpNumber.selectByValue(num);
	}
	
	public void selectNumberChild(String num)
	{
		Select drpNumber = new Select(NUMBER_CHILD);
		drpNumber.selectByValue(num);
	}
	
	public void selectFind()
	{
		FIND_FLIGHTS.submit();
		
	}

}
