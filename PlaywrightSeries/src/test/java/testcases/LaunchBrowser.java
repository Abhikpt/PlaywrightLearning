package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {


		Playwright playwright =  Playwright.create();
//		Browser browser = playwright.chromium().launch();       //headless mode 
		
		Browser browser = playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();           //open browser in blank mode
		page.navigate("http://way2automation.com");
		System.out.println(page.title() );
		Thread.sleep(2000);
		page.close();
		playwright.close();
	
	}

}