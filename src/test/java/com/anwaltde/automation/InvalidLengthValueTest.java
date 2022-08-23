package com.anwaltde.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import resources.Base;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.HomePage;

public class InvalidLengthValueTest extends Base {

	private static Logger log = LogManager.getLogger(InvalidLengthValueTest.class.getName());

	@Test
	public void invalidLength() throws IOException {

		driver = initializeDriver();
		log.debug("Waiting for web...");

		HomePage hp = new HomePage(driver);
		log.debug("Removing Default Length Value");
		hp.getlengthField().clear();

		log.debug("Entering Characters in length Field.");
		hp.getlengthField().sendKeys("farooq");

		log.debug("Clicking Generate CounterString Button");
		hp.getgenerateButton().click();

		log.debug("Validating String Generation Response should not show up for invalid length value");
		Assert.assertFalse(hp.getstatusMessage().getText().equalsIgnoreCase("Generated - Ready to Copy"),
				"Generate Counter String Message");

	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
