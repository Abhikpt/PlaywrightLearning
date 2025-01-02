package testcases;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
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
		  
		  
		  
		  // dropdown selection
		_page.selectOption("fieldset select[name=country]", "Bhutan");		// select the one value from select dropdown
		_page.waitForTimeout(4000);
				
		
		// querySelectorAll select all the options from dropdown
		List<ElementHandle> elements = _page.querySelectorAll("fieldset select[name=country] option ");				
		System.out.println(elements.size());    //print all options		
		for(ElementHandle element : elements)
		{
			System.out.println(element.innerText() +"---------"+ element.getAttribute("value"));
		}
		
		System.out.println("formfill check pass");
	}
	
	
	public void DropdownSelection() throws InterruptedException
	{
		_page.navigate("https://www.globalsqa.com/demo-site/select-dropdown-menu/");	
		
		
		//select by value
		_page.selectOption("#post-2646 > div.twelve.columns > div > div > div > p > select", "ALA");		
		Thread.sleep(2000);
		
		
		// select by index
		_page.selectOption(" p > select", new SelectOption().setIndex(3));		
		Thread.sleep(2000);
		
		// select by text
		_page.selectOption(" p > select", new SelectOption().setLabel("Aruba"));		
		Thread.sleep(2000);	
		
		System.out.println("DropdownSelection check pass");
		
	}
	
	
	
	public void CheckBoxSelections()
	{
		_page.navigate("https://www.globalsqa.com/samplepagetest/");
		
		
		// selecting checkbox
		Locator checkbox = _page.locator("//*[@id=\"contact-form-2599\"]/form/div[5]/label/input[@type=\"checkbox\"]");		
		for(int i=0 ; i< checkbox.count(); i++)
		{
			checkbox.nth(i).click();
		}	
			
		// selecting radio
		Locator radiolevel = _page.locator("//*[@id=\"contact-form-2599\"]/form/div[6]/label[3]");
		radiolevel.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
		
		System.out.println("checkbox selection check pass");		
	}
	
	
	
	
	public void TestResizable()
	{
		_page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");
		Locator slider = _page.locator("//*[@id=\"resizable\"]/div[3]");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		_page.mouse().move(slider.boundingBox().x + slider.boundingBox().width / 2,
				slider.boundingBox().y + slider.boundingBox().height / 2);
		_page.mouse().down();
		_page.mouse().move(slider.boundingBox().x + 400, slider.boundingBox().y + 400);
		_page.mouse().up();

	}
	
	
	public void ShadowDomElements()
	{
		
		_page.navigate("chrome://downloads/");		
		_page.locator("#searchInput").fill("Testing shadow elements");
		
		System.out.println("ShadowDomElements selection check pass");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	
	
	public void AlertHandeling() throws InterruptedException
	{
		_page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
		
		// it will trigger when an dialog appear
			_page.onDialog(dialog -> {
			
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				dialog.accept();			
				System.out.println(dialog.message());
				
			});
			
			_page.locator("[type='submit']").click();
			
			System.out.println("AlertHandling check pass");
			
	}
	
	
	
	
	public void IframeHandeling()
	{
		_page.navigate("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
		
	   		
		// locating frame -> then internal elements -> 		
	FrameLocator frm =	_page.frameLocator("div#example-1-tab-3 iframe[class=\"demo-frame\"]");
	Locator FrametoElement = frm.locator("div.farme_window a");	
	System.out.println(FrametoElement.innerText());
	
	Locator	 frames = _page.locator("iframe");		
	System.out.println("frame count on the page is: "+ frames.count() );	
	for(int i = 0 ; i< frames.count()-1 ; i++ )
	{
		System.out.println("farame c is: " + frames.nth(i).getAttribute("class"));
	}
	
	
	System.out.println("Iframe handling check pass");
	}
	
	
	
	public void LocatingLinkinABlock()
	{		
		
		_page.navigate("https://www.globalsqa.com/demo-site/select-dropdown-menu/");		
		
		Locator block = _page.locator("div#nav_menu-6");		
		
		// get all the link inside the block element
		Locator linksInBlock = block.locator("a");		
		for(int i = 0; i< linksInBlock.count(); i++)
		{
			System.out.println (linksInBlock.nth(i).innerText() + "-- URL is -->" + linksInBlock.nth(i).getAttribute("href"));			
		}
		
	
		System.out.println("Locate link check pass");
	}
	
	
	public void HandlingTabsAndPopups()
	{
		_page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/otp");		
		
		Page popup = _page.waitForPopup( () ->
				{
						_page.locator("[aria-label='Privacy']").nth(0).click();					
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {							
							e.printStackTrace();
						}
					
				});
		
		popup.locator("a#header-sign-up-btn").click();		
		popup.locator("input#name").fill("ABC Tester");		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		
		popup.close();
		_page.close();		
		
		System.out.println("popup and tab handling check pass");
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
