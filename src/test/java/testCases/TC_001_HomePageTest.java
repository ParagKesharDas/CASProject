package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_HomePageTest extends BaseClass {
	@Test(priority = 0)
	public void profileValidation() {
		try {
			HomePage home = new HomePage(driver);

			home.clickProfileLogoLink();
			logger.info("Clicked on Profile Logo");
			timeUnitSleep(2);
			String proName = home.getProfileName();
			String proEmail = home.getProfileEmail();
			System.out.println(proName);
			System.out.println(proEmail);
			logger.info("Profile Name: " + proName);
			logger.info("Profile Email: " + proEmail);
			if (proEmail.equalsIgnoreCase("2308358@cognizant.com")
					&& proName.equalsIgnoreCase("Das, Parag (Cognizant)")) {
				Assert.assertTrue(true);
				logger.info("Profile validation passed");
			} else {
				Assert.assertTrue(false);
				logger.info("Profile validation failed");
			}

		} catch (Exception e) {
			logger.error("Exception in profileValidation: " + e);
			Assert.fail();

		}

	}

	@Test(priority = 1)
	public void headerPrint() {
		try {
			logger.info("Getting all header subheaders");
			HomePage home = new HomePage(driver);
			home.getAllHeaderSubheader();
			home.extractHeaderDataToExcel("HeaderSubHeader");
			Assert.assertTrue(true);
		} catch (Exception e) {
			logger.error("Exception in headerPrint: " + e);
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void checkSubHeaderValidity() throws InterruptedException {

		try {

			HomePage home = new HomePage(driver);
			logger.info("Clicking on 'Corporate Functions' header");
			home.clickHeader("Corporate Functions");
			boolean verify = home.verifySubHeader(1, "Legal & Corporate Affairs");
			logger.info("Verifying 'Legal & Corporate Affairs' subheader");
			Assert.assertEquals(verify, true);
			if(verify) {
	            logger.info("'Legal & Corporate Affairs' subheader is valid");
	        } else {
	            logger.info("'Legal & Corporate Affairs' subheader is not valid");
	        }
		} catch (Exception e) {
			logger.error("Exception in checkSubHeaderValidity: " + e);
			Assert.fail();
		}
	}

	@Test(priority = 4)
	public void clickSubHeaderValidity() throws InterruptedException {

		try {
//			driver.navigate().refresh();
			HomePage home = new HomePage(driver);
			logger.info("Verifying 'Ethics and Compliance' subheader");
			boolean verify = home.verifySubHeader(1, "Ethics and Compliance");
			if (verify) {
				logger.info("'Ethics and Compliance' subheader is valid");
	            logger.info("Clicking on 'Ethics and Compliance' subheader");
				home.clickSubHeader("Ethics and Compliance");
				timeUnitSleep(15);
				Assert.assertTrue(true);

			} else {
				logger.info("'Ethics and Compliance' subheader is not valid");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			logger.error("Exception in clickSubHeaderValidity: " + e);
			Assert.fail();
		}
	}

}
