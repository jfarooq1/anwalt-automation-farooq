package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#lengthOfCounterString")
	WebElement lengthField;

	@FindBy(name = "validate")
	WebElement generateButton;

	@FindBy(css = "#copybutton")
	WebElement copyButton;

	@FindBy(css = "#counterstring")
	WebElement copyTextArea;
	
	@FindBy(css = "#status")
	WebElement statusMessage;
	
	
	

	public WebElement getlengthField() {
		return lengthField;
	}

	public WebElement getgenerateButton() {
		return generateButton;
	}

	public WebElement getcopyButton() {
		return copyButton;
	}

	public WebElement getcopyTextArea() {
		return copyTextArea;
	}
	
	public WebElement getstatusMessage() {
		return statusMessage;
	}

}
