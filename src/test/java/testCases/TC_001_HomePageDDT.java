package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_HomePageDDT extends BaseClass{
	
	
	
	@Test(priority = 0, dataProvider = "userVerificationData", dataProviderClass = DataProviders.class)
	public void profileValidation(String name,String email) {
		System.out.println("******profile Validation is Executing*******");
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
			if (proEmail.equalsIgnoreCase(email)
					&& proName.equalsIgnoreCase(name)) {
				Assert.assertTrue(true);
				logger.info("Profile validation passed");
				System.out.println("Profile validation passed");
			} else {
				Assert.assertTrue(false);
				logger.info("Profile validation failed");
				System.out.println("Profile validation failed");
			}

		} catch (Exception e) {
			System.out.println("******profile Validation failed*******");
			logger.error("Exception in profileValidation: " + e);
			Assert.fail();

		}

	}

	@Test(priority = 1)
	public void headerPrint() {
		System.out.println("******Header Printing*******");
		try {
			logger.info("Getting all header subheaders");
			HomePage home = new HomePage(driver);
			home.getAllHeaderSubheader();
			home.extractHeaderDataToExcel("HeaderSubHeader");
			Assert.assertTrue(true);
		} catch (Exception e) {
			logger.error("Exception in headerPrint: " + e);
			System.out.println("******Header Printing failed*******");
			Assert.fail();
		}
	}

	@Test(priority = 2, dataProvider = "headerDataCheckingData", dataProviderClass = DataProviders.class)
	public void checkSubHeaderValidity(String header,String subHeader) throws InterruptedException {
		System.out.println("******checking SubHeader Validity *******");
		try {

			HomePage home = new HomePage(driver);
			logger.info("Clicking on '"+ header+"' header");
			home.clickHeader(header);
			boolean verify = home.verifySubHeader(1, subHeader);
			logger.info("Verifying '"+ subHeader+"' subheader");
//			Assert.assertEquals(verify, true);
			if(verify) {
	            logger.info(header+" subheader is valid");
	            
	            System.out.println(header+" subheader is valid");
	            Assert.assertTrue(true);
	        } else {
	            logger.info(header+" subheader is not valid");
	            System.out.println(header+" subheader is not valid");
	            Assert.assertTrue(false);
	        }
		} catch (Exception e) {
			System.out.println("*****checking SubHeader Validity failed*******");
			logger.error("Exception in checkSubHeaderValidity: " + e);
			Assert.fail();
		}
	}

	@Test(priority = 4,dataProvider = "headerDataClickingData", dataProviderClass = DataProviders.class)
	public void clickSubHeaderValidity(String subHeader) throws InterruptedException {
		System.out.println("******clicking on a  SubHeader *******");
		try {
//			driver.navigate().refresh();
			HomePage home = new HomePage(driver);
			logger.info("Verifying "+subHeader+" subheader");
			boolean verify = home.verifySubHeader(1, subHeader);
			if (verify) {
				logger.info(" "+subHeader+" subheader is valid");
	            logger.info("Clicking on "+subHeader+" subheader");
				home.clickSubHeader(subHeader);
				timeUnitSleep(15);
				Assert.assertTrue(true);

			} else {
				logger.info("'Ethics and Compliance' subheader is not valid");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println("******clicking on a  SubHeader failed*******");
			logger.error("Exception in clickSubHeaderValidity: " + e);
			Assert.fail();
		}
	}
}
