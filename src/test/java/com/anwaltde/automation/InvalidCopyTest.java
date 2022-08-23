package com.anwaltde.automation;

import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class InvalidCopyTest extends Base {

	private static Logger log = LogManager.getLogger(GenerateCounterStringTest.class.getName());

	@Test
	public void invalidcopyString() throws IOException {

		driver = initializeDriver();
		log.debug("Waiting for web...");

		Properties prop = getProperty();

		HomePage hp = new HomePage(driver);
		log.debug("Removing Default Generated String");
		hp.getcopyTextArea().clear();

		log.debug("Entering Length Value");
		hp.getlengthField().clear();
		hp.getlengthField().sendKeys(prop.getProperty("length"));

		log.debug("Clicking Generate String Button");
		hp.getgenerateButton().click();

		log.debug("Validating Generated String length should be equal to the provided length input.");
		Assert.assertEquals(hp.getcopyTextArea().getText().length(), prop.getProperty("length"));

		log.debug("Storing Generated String Value Manually in a variable.");
		String copiedString = hp.getcopyTextArea().getText();

		log.debug("Clicking Copy button");
		hp.getcopyButton().click();

		log.debug("Pasting the Copied String in text area. ");
		hp.getcopyTextArea().sendKeys(Keys.COMMAND, "v");
		String pastedString = hp.getcopyTextArea().getText();

		log.debug("Validating Copied String");
		Assert.assertEquals(copiedString, pastedString);

		driver.quit();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
