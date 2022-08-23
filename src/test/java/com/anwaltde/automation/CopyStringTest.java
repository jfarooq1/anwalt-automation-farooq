package com.anwaltde.automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageObjects.HomePage;
import resources.Base;

public class CopyStringTest extends Base {

	private static Logger log = LogManager.getLogger(CopyStringTest.class.getName());

	@Test
	public void copyString() throws IOException {

		driver = initializeDriver();
		log.debug("Waiting for web...");

		Properties prop = getProperty();

		HomePage hp = new HomePage(driver);
		log.debug("Clearing Default Length Value");
		hp.getlengthField().clear();

		log.debug("Entering Length Value");
		hp.getlengthField().sendKeys(prop.getProperty("length"));

		log.debug("Clicking Generate Counterstring Button");
		hp.getgenerateButton().click();

		log.debug("Copying Generated String Value");
		String copiedString = hp.getcopyTextArea().getText();

		log.debug("Clicking Copy Button");
		hp.getcopyButton().click();

		log.debug("Validating Copy Response Message");
		Assert.assertTrue(hp.getstatusMessage().getText().equalsIgnoreCase("Copied To Clipboard"),
				"Copied to Clipboard Message Validation");

		log.debug("Pasting Copied text into Text Area for comparision");
		hp.getcopyTextArea().sendKeys(Keys.COMMAND, "v");
		String pastedString = hp.getcopyTextArea().getText();

		log.debug("Validating Copied String is correct.");
		AssertJUnit.assertEquals(copiedString, pastedString);

		driver.quit();
	}
}
