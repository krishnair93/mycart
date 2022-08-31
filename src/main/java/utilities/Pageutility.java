package utilities;

import org.openqa.selenium.WebElement;

public class Pageutility {

	
	public void clickonwebelement(WebElement element) {
		
		element.click();
		
	}
	
	

	public void entertext(WebElement element, String text) {
		
		element.sendKeys(text);
		
	}
}
