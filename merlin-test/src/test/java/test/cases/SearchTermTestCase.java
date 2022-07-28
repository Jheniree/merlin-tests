package test.cases;

import java.io.IOException;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.objects.GooglePage;
import page.objects.WikipediaPage;

public class SearchTermTestCase {

	private WebDriver driver;	
	private GooglePage googlePage;
	private WikipediaPage wikiPage;
	
	@Before
	public void setUp() {	
		WebDriverManager.chromedriver().version("76.0.3809.12").setup();
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options); 
		   
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com");
        googlePage = new GooglePage(driver);
        wikiPage = new WikipediaPage(driver);
	}
	
	@Test
	public void searchByKeyword() throws IOException {
		googlePage.acceptCookies();
		googlePage.searchByTerm("automatización");
		
		googlePage.goToWikipediaSite();
		
		Assert.assertEquals(wikiPage.getPageWikiPageTitle(), "Automatización");
		Assert.assertTrue(wikiPage.getFirstAutomationYear().contains("270 a.C."));
		
		wikiPage.takeScreenshot();
	}

	@After
	public void tearDown() {
		driver.close();
	}	
}
