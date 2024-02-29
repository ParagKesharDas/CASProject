package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EthicsandCompliancePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_EthicsandCompliancePageTest extends BaseClass {

	@Test(priority = 10 , dataProvider = "SecoundPageValidationData", dataProviderClass = DataProviders.class)
	public void verifyPage(String title) {
		try {
			EthicsandCompliancePage ecPage = new EthicsandCompliancePage(driver);
			System.out.println("Page Opened : "+ecPage.getPageTitle());
			String original = ecPage.getPageTitle();
			String replaced = original.replace("&amp;", "&");
			if (replaced.equalsIgnoreCase(title.replace("and", "&"))) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test(priority = 11, dependsOnMethods = { "verifyPage" })
	public void getAllContent() {
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
			Assert.fail();
		}
	}
}
