package testcases;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HandlingComplexUserGestures {
	
	
	protected Page _page;
	
	public HandlingComplexUserGestures(Page page) {
		
		_page = page;
		
	}
	
	
	
	public void HandelMouseHoverMenu()
	{
		_page.navigate("https://www.way2automation.com/");
		
		_page.hover("#menu-item-27617 > a > span.menu-text");		
		
		_page.locator("#menu-item-27619 > a > span.menu-text").click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		System.out.println("Mousehove check pass");
			
	}
	
	
	
	public void HandelSliders() throws InterruptedException
	{
		_page.navigate("https://practice-automation.com/slider/");
		
		Locator slider = _page.locator("input#slideMe");
		
		Thread.sleep(5000);
		
		// sliding in left direction
		_page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2, slider.boundingBox().y+slider.boundingBox().height/2);		
		_page.mouse().down();		
		_page.mouse().move(slider.boundingBox().x - 400, slider.boundingBox().y+slider.boundingBox().height/2);		
		_page.mouse().up();
				
		
		// sliding in right direction
		_page.mouse().move(slider.boundingBox().x +  slider.boundingBox().width/2 , slider.boundingBox().y+slider.boundingBox().height/2);	
		_page.mouse().down();		
		_page.mouse().move(slider.boundingBox().x + 700, slider.boundingBox().y+slider.boundingBox().height/2);		
		_page.mouse().up();		
		

		Thread.sleep(5000);		
		
		System.out.println("Slider check pass");
		
	}
	
	
	public void HandelDragDrop()
	{
		_page.navigate("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");		
		
		FrameLocator frame = _page.frameLocator(".demo-frame[src=\"droppable/default.html\"]") ;
		
		Locator draggable = frame.locator("#draggable");
		Locator droppable = _page.frameLocator(".demo-frame[src=\"droppable/default.html\"]").locator("#droppable");
		
		
		// select the draggable
		_page.mouse().move(draggable.boundingBox().x +  draggable.boundingBox().width/2 , draggable.boundingBox().y+draggable.boundingBox().height/2);	
		_page.mouse().down();
		
		// drop the draggable
		_page.mouse().move(droppable.boundingBox().x + droppable.boundingBox().width / 2 , droppable.boundingBox().y+droppable.boundingBox().height/2);		
		_page.mouse().up();	
		
		
		System.out.println("drag and drop  check pass"); 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
				
	}

}
