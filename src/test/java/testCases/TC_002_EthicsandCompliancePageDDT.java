package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EthicsandCompliancePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_EthicsandCompliancePageDDT extends BaseClass {

	@Test(priority = 10 , dataProvider = "SecoundPageValidationData", dataProviderClass = DataProviders.class)
	public void verifyPage(String title) {
		System.out.println("******Page Validation is Executing*******");
		logger.info("verifyPage is Executing");
		try {
			EthicsandCompliancePage ecPage = new EthicsandCompliancePage(driver);
			
			System.out.println("Page Opened : "+ecPage.getPageTitle());
			
			String original = ecPage.getPageTitle();
			String replaced = original.replace("&amp;", "&");
			logger.info("Page title is Verifying");
			if (replaced.equalsIgnoreCase(title.replace("and", "&"))) {
				logger.info("Page Verification is successful");
				Assert.assertTrue(true);
				
			} else {
				logger.info("Page Verification failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println("******Page Validation failed*******");
			Assert.fail();
		}

	}

	@Test(priority = 11, dependsOnMethods = { "verifyPage" })
	public void getAllContent() {
		System.out.println("******Page Details printing is Executing*******");
		logger.info("getAllContent is Executing");
		try {
			EthicsandCompliancePage ecPage = new EthicsandCompliancePage(driver);
			
			ecPage.getTopicName();
			ecPage.getWriterName();
			ecPage.getResourcesLinks();
			ecPage.getContent();
			ecPage.getFocusAreasLinks();
			ecPage.clickEthicsComplianceRisksLink();
			ecPage.getEthicsComplianceRisksContent();
			Assert.assertTrue(true);

		} catch (Exception e) {
			System.out.println("******Page Details printing is failed*******");
			logger.info("getAllContent failed");
			Assert.fail();
		}
	}
}
