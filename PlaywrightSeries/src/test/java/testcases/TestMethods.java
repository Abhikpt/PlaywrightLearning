package testcases;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;


public class TestMethods {
	
	private Page _page;
	
	public TestMethods(Page page)
	{			
			_page = page;	 
		
	}
	
		
	public void  VerifyNavigations() throws InterruptedException
	{
		
	System.out.println();
	_page.navigate("https://google.com");
	System.out.println("title of page is " + _page.title());
	
	
	_page.goBack(new GoBackOptions().setTimeout(5000));
	
	Thread.sleep(2000);
    _page.goForward(new GoForwardOptions());
	Thread.sleep(2000);	
	_page.reload();			

		
	}
	
	 public void testPageTitle() 
	 {
	        _page.navigate("https://abhikpt.github.io/LearningwithAbhi/");
	        PlaywrightAssertions.assertThat(_page).hasTitle("LearningwithAbhi");
	        System.out.println("Verified page title.");
	 }
	
	
	 
	public void  VerifyFormfill() throws InterruptedException
	{	
		_page.navigate("https://abhikpt.github.io/LearningwithAbhi");		
		System.out.println("LearningwithAbhi web app is open");
		
		
		_page.click("#navbarNavAltMarkup > div > a:nth-child(4)");
		
		_page.click("");
		
		
		
		
		
		
		System.out.println("form is submitted");
	

		
	}	
	
	public void closePage()
	{
		_page.close();
		
	}
	

}
