package page.objects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPage {

	private WebDriver _driver;
	
	@FindBy(how = How.ID, using = "firstHeading")
	private WebElement pageTitle;
	
	public WikipediaPage(WebDriver driver) {
		_driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	public String getPageWikiPageTitle() {
		return pageTitle.getText();
	}
	
	public String getFirstAutomationYear(){
		WebElement pFirstYear = _driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[5]/div[1]/p[28]"));
		Actions scrollDownHistory = new Actions(_driver);
		scrollDownHistory.moveToElement(pFirstYear);
		scrollDownHistory.perform();
		
		return pFirstYear.getText();
	}
	
	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot)_driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(".\\screenshots\\screenshot.png"));
	}
}
