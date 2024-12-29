
package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {

	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected  Page page;
	
	

	// Initialize Playwright and Browser
	public void initializePlaywright(String browserType, boolean headless) 
	{
		playwright = Playwright.create();

		switch (browserType.toLowerCase()) 
		{
			case "firefox":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
				break;
			case "webkit":
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
				break;
			default:
				browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
		}

		context = browser.newContext();
		page = context.newPage();
	}

	
	// Navigate to a URL
	public void navigateTo(String url) 
	{
		page.navigate(url);
		System.out.println("Navigated to: " + url);
	}

	// Capture Screenshot
	public void takeScreenshot(String filePath) 
	{
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));
		System.out.println("Screenshot saved to: " + filePath);
	}

	
	
	// Cleanup
	public void tearDown() {
		if (context != null)
			context.close();
		if (browser != null)
			browser.close();
		if (playwright != null)
			playwright.close();
		System.out.println("Teardown completed.");
	}


	
	
	public void OpenAdvanceBrowser() {

		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
	
		// set browser profile +  normal mode instead of incognito + headed
	BrowserContext	browserContext = playwright.chromium().launchPersistentContext(Paths.get("C:\\Users\\ASing\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2"), new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
		
	// set browser window
		BrowserContext browserC = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(null));

		page = browserContext.newPage();
		page.navigate("https://www.google.com");
		
		
		
	}

}
