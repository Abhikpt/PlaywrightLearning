package testcases;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestLocators {
	
	protected Page _page;
	
	public  TestLocators(Page page) {
		
		_page = page;
		
	}
	
	
	
	public void TestLearningWithAbhiLogin()
	{
		
		_page.navigate("https://abhikpt.github.io/LearningwithAbhi/Login");
		
		
		_page.click("#app > div > div:nth-child(2) > div > main > button");    //locating by using css selector		
		
		
		_page.fill("#inputEmail","Abhishek kumar");    //locate using CSS + action			
		_page.locator("[id='inputEmail']").fill("Singh");      //locator using [attribute = value] -> action	     
	    _page.locator("id=inputEmail").fill("abhishek");          // this format work for id locator only
	     
	     
	     _page.fill("[type=\"password\"]", "1996");                    //attribute locator
	     
	     _page.click("//*[@id=\"app\"]/div/div[2]/div/main/div/div/div/button[1]");          //Xpath
	     
	     System.out.println("form submitted "); 
	     
	     
	     Locator HomePageIdentifier =  _page.locator("main.container div div div div  .display-4");    //css selector
	    // Locator LocatUsingXpath = _page.locator("//div[contains(@class,\"bg-primary\")]/ div/div/div/h3");   //xpath
	     
	  //   System.out.println(HomePageIdentifier.innerText() + "\nSecured page got open");  
	     assertThat(HomePageIdentifier).hasText("Welcome to My Blazor Web Tools");	     
	     assertThat(HomePageIdentifier).isVisible();
	     
	}
	
	
	public void FormsElementLocator()
	{
		
		// navigate to form page
		_page.navigate("https://www.way2automation.com/way2auto_jquery/index.php");
		
		   // Hover over the heading
			/*
			 * _page.locator("##menu-item-27617 > a > span.menu-text").hover();
			 * 
			 * // Wait for the submenu or hover element to appear
			 * _page.locator("#menu-item-27578 a").waitFor(new
			 * Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
			 * 
			 * // Click on the submenu item _page.locator("#menu-item-27578 a").click();
			 */
		
		  System.out.println("Navigated on Demo 01"); 
		  
		  // Xpath + AND
		  _page.fill("//input[@name='name'  and @type='text']", "Tester A");
		  
		  
		  // CSS selectors
		  _page.fill("form fieldset input[name=phone]", "9394959697");
		  _page.fill("form fieldset input[name=email]", "abcd@gmail.com");      //using CSS selector
		  _page.fill("fieldset input[name=city]", "Noida");
		
		  // Xpath 
		  _page.fill("//*[@id=\"load_form\"]/fieldset[6]/input", "TEST1234");          
		  _page.fill("//*[@id=\"load_form\"]/fieldset[7]/input", "123456");				
		_page.selectOption("fieldset select[name=country]", "Bhutan");		
		_page.waitForTimeout(4000);
		
		
		
		
		// select all the options from dropdown
		List<ElementHandle> elements = _page.querySelectorAll("fieldset select[name=country] option ");				
		System.out.println(elements.size());    //print all options		
		for(ElementHandle element : elements)
		{
			System.out.println(element.innerText() +"---------"+ element.getAttribute("value"));
		}
		
		
	}
	
	
	
	public void AddTocart()
	{
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://magento.softwaretestingboard.com/");
		      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Tees")).click();
		      page.locator("li").filter(new Locator.FilterOptions().setHasText("Strike Endurance Tee Rating:")).locator("button").click();
		      page.getByLabel("M", new Page.GetByLabelOptions().setExact(true)).click();
		      page.getByLabel("Blue").click();
		      page.getByLabel("Qty").click();
		      page.getByLabel("Qty").fill("23");
		      page.locator(".fieldset > .field > .control").first().click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My Cart 23 23 items")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Checkout")).click();
	}
		
	}
	
	
	

}
