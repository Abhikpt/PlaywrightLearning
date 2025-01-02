package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class MainClass extends  BaseClass  
{	
	
	public void setup() 
	{
       // initializePlaywright("chromium", false); // Replace "chromium" with "firefox" or "webkit" for other browsers
		OpenAdvanceBrowser();
    }
	
	 
	 
	public static void main(String[] args) throws InterruptedException
	{

		
		MainClass obj = new MainClass();
		
		obj.setup();
		
		obj.navigateTo("http://www.way2automation.com");
		obj.takeScreenshot("/src/test/resources/Screen01.jpg");		
				
		/*
		 * TestMethods test = new TestMethods(obj.page); test.VerifyNavigations();
		 * test.VerifyFormfill();
		 */
		
		TestLocators tl = new TestLocators(obj.page);
		
	//	tl.TestLearningWithAbhiLogin();
	//	tl.FormsElementLocator()	;
	//	tl.DropdownSelection();
		tl.TestResizable();
	//	tl.LocatingLinkinABlock();
	//	tl.CheckBoxSelections();
		tl.ShadowDomElements();
		
		
	//	tl.AlertHandeling();
	//	tl.IframeHandeling();
	//	tl.HandlingTabsAndPopups();
	//	tl.AddTocart();

		
		HandlingComplexUserGestures HCG = new HandlingComplexUserGestures(obj.page);
		
//		HCG.HandelMouseHoverMenu();
//		HCG.HandelSliders();
//		HCG.HandelDragDrop();
		
		
		
		
		obj.page.close();
		obj.playwright.close();
				

	}

}
