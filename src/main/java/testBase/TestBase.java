package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.LandingPage;
import pageObjects.WhitePaperseBooks;
import reusableMethods.ActionMethods;
import reusableMethods.ExcelDataSheet;
import reusableMethods.PropertiesFile;

public class TestBase extends ActionMethods{
	BrowserFactory BF = new  BrowserFactory();
	

	

	@BeforeMethod
	public void LuanchBrowser() throws Exception {
		String broswer = PropertiesFile.getPropertyValue("browser");
		String url = PropertiesFile.getPropertyValue("url");
		DriverFactory.getInstance().setDriver(BF.creatrBrowserInstance(broswer));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(url);
		
		
		

	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}

}
