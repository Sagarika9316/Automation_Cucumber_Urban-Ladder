package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.xpath("/html/body/header/div[2]/div[4]/ul/li[2]/a");
	By searchItems = By.xpath("//*[@id=\"search_query\"]");
	By clickSearch = By.xpath("//*[@id=\"quickSearch\"]/div/form/fieldset/div/button");
	By text = By.xpath("/html/body/main/div[1]/div/h1");
	
	By terms = By.xpath("/html/body/footer/div[1]/div/div[2]/div/div[1]/div[2]/ul/li[2]/a");
	By page = By.xpath("//*[@id=\"__next\"]/div/main/div/div");
	
	public WebElement search() {
		return driver.findElement(search);
	}
	public WebElement searchItem() {
		return driver.findElement(searchItems);
	}
	public WebElement clickSearch() {
		return driver.findElement(clickSearch);
	}
	public WebElement pageText() {
		return driver.findElement(text);
	}
	
	public WebElement selectTermsAndConditions() {
		return driver.findElement(terms);
	}
	public WebElement page() {
		return driver.findElement(page);
	}
	
	
}
