package stepDefinitions;


import resources.base;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.Assert;

import PageObjects.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(io.cucumber.junit.Cucumber.class)
public class stepDefinition extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	 
	 @Given("^Initialize the browser with chrome$")
	 public void initialize_the_browser_with_chrome() throws Throwable {
		 driver = initializeDriver();
		 driver.manage().window().maximize();
		 log.info("Driver is initialized");
		 		
	    }
	 
	  @When("^the user clicks on search icon$")
	  public void the_user_clicks_on_search_icon() throws Throwable {
		 	
	        LandingPage l = new LandingPage(driver);
	        l.search().click();
	    }

	    
	   @Then("^the user is navigated to (.+) page and verify the text displayed on that page$")
	    public void the_user_is_navigated_to_page_and_verify_the_text_displayed_on_that_page(String searchitem) throws Throwable {
	        LandingPage l = new LandingPage(driver);
	        String title = l.pageText().getText();
	        Assert.assertTrue(title.contains(searchitem));
	    }
	    
	    @And("^enters the (.+) in the search bar$")
	    public void enters_the_in_the_search_bar(String searchitem) throws Throwable {
	        LandingPage l = new LandingPage(driver);
	        l.searchItem().sendKeys(searchitem);
	        l.clickSearch().click();
	    }
	 
	 @When("^the user clicks on Terms and Conditions in the footer section$")
	    public void the_user_clicks_on_terms_and_conditions_in_the_footer_section() throws Throwable {
		
		 	LandingPage l = new LandingPage(driver);
		 	l.selectTermsAndConditions().click();
		 	log.info("Navigated to Terms and Conditions Page");
		 
	        
	    }

	    @Then("^the user is navigated to terms and conditions page and verify the code of conduct$")
	    public void the_user_is_navigated_to_terms_and_conditions_page_and_verify_the_code_of_conduct() throws Throwable {
	    	Set<String> ids = driver.getWindowHandles();
			Iterator <String> it = ids.iterator();
			String parentId = it.next();
			String childId = it.next();
			driver.switchTo().window(childId);
			System.out.println("Moved to child window successfully");
			log.info("Moved to child window successfully");
			
	    	LandingPage l = new LandingPage(driver);
	    	String title = l.page().getText();
	    	Assert.assertTrue(title.contains("Code of Conduct"));
	    	
	    	driver.switchTo().window(parentId);
			System.out.println("Switched back to parent window");
			log.info("Switched back to parent window");
	        
	    }

	    @And("^Navigate to url site$")
	    public void navigate_to_url_site() throws Throwable {
	    	driver.get(prop.getProperty("url"));
	        log.info("Navigated to Home Page");
	        
	    }

	 
	    @And("^close the browser$")
	    public void close_the_browser() throws Throwable {
	    	driver.close();
			driver = null;
			
			log.info("Driver is closed successfully");
	    }
	}
	
	

