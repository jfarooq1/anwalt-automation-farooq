package com.anwaltde.automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.HomePage;
import resources.Base;

public class GenerateCounterStringTest extends Base {

	private static Logger log = LogManager.getLogger(GenerateCounterStringTest.class.getName());
	
	@Test
	public void generateCounterString() throws IOException {

		driver = initializeDriver();
		log.info("Waiting for web...");

		Properties prop = getProperty();

		HomePage hp = new HomePage(driver);
		log.debug("Removing Default Length Value");
		hp.getlengthField().clear();

		log.debug("Entering Length Value");
		hp.getlengthField().sendKeys(prop.getProperty("length"));

		log.debug("Clicking Generate Counterstring Button");
		hp.getgenerateButton().click();

		log.debug("Validating Message Response");
		Assert.assertTrue(hp.getstatusMessage().getText().equalsIgnoreCase("Generated - Ready to Copy"),
				"Generate Counter String Message");

		log.debug("Validating Generated Stringlength is equal to the provided input");
		AssertJUnit.assertEquals(hp.getcopyTextArea().getText().length(), Integer.parseInt(prop.getProperty("length")));
		driver.quit();
	}

}
