package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_DDT extends BaseClass {
	
	@Test(priority = 0)
	public void click() throws InterruptedException {
		HomePage home = new HomePage(driver);
		timeUnitSleep(2);
		home.clickProfileLogoLink();
		timeUnitSleep(2);
	}
	@Test(priority = 1, dataProvider = "userVerificationData", dataProviderClass = DataProviders.class)

	
	//dataProvider will pass data in method arguments
	public void profileValidation(String name, String email) {
		try {
			HomePage home = new HomePage(driver);
			System.out.println("Run..");
			timeUnitSleep(2);
			logger.info("Clicked on Profile Logo");
			String proName = home.getProfileName();
			String proEmail = home.getProfileEmail();
			System.out.println(proName);
			System.out.println(proEmail);
			logger.info("Profile Name: " + name);
			logger.info("Profile Email: " + email);
			if (proEmail.equalsIgnoreCase(email) && proName.equalsIgnoreCase(name)) {
				logger.info("Profile validation passed for Username : " + name + "Email : " + email);
				Assert.assertTrue(true);
				
			} else {
				logger.info("Profile validation failed for Username : " + name + "Email : " + email);
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.error("Exception in profileValidation: " + e);
			Assert.fail();

		}

	}
}
