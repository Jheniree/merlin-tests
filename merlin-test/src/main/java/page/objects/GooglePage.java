package page.objects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	private WebDriver _driver;
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement inputSearch;
	
	@FindBy(how = How.CLASS_NAME, using = "lnXdpd")
	private WebElement imgGoogle;
	
	@FindBy(how = How.ID, using = "L2AGLb")
	private WebElement buttonCookies;
	
	
	public GooglePage(WebDriver driver) {
		_driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void acceptCookies() {
		buttonCookies.click();
	}
	
	public void searchByTerm(String searchTerm) {
		inputSearch.sendKeys(searchTerm);
		inputSearch.submit();
	}	
	
	public void goToWikipediaSite() {
		WebElement linkToWikipedia = _driver.findElement(By.xpath("//a[contains(text(),'Wikipedia')]"));
		linkToWikipedia.click();
	}
}
