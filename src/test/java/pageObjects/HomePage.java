package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelDataFile;

public class HomePage extends BasePage {
//	WebDriver driver;
	List<String> allHeaderNameList = new ArrayList<>();

	// passing driver to parent class BasePage
	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div/button[contains(@aria-label,'Account manager')]//img")
	WebElement profileLogoLink;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']")
	WebElement profileNameLink;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_secondary']")
	WebElement profileEmailLink;
	@FindBy(xpath = "//div[@class='global-nav']/descendant::span/span/span[not(text()='be.cognizant')]")
	List<WebElement> mainHeaderLink;

	// div[@class=\"global-nav\"]/descendant::span/span/span[not(text()='be.cognizant')]
//	@FindBy(xpath = "//div[contains(@class,'ms-Layer ms-Layer--fixed')][3]/descendant::li") WebElement 

	public void clickProfileLogoLink() {
//		profileLogoLink.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", profileLogoLink);
	}

	public void clickNormalProfileLogoLink() {
		profileLogoLink.click();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", profileLogoLink);
	}

	public String getProfileName() {
		return profileNameLink.getText();
	}

	public String getProfileEmail() {
		return profileEmailLink.getText();
	}

	public void clickHeader(String str) {
		for (WebElement w : mainHeaderLink) {
			if (w.getText().equalsIgnoreCase(str)) {
				w.click();
			}
		}
	}

	public boolean verifySubHeader(int i, String str) throws InterruptedException {
		Actions act = new Actions(driver);
		int j = i;
		List<WebElement> onlyElementList = driver.findElements(By.xpath(getOnlySubHeaderXpath(j)));
		int count = 0;
		for (WebElement w : driver.findElements(By.xpath(getSubHeaderXpath(j)))) {
			timeUnitSleepMili(800);
			String str1 = onlyElementList.get(count).getText();
//			System.out.println(str1);
			if (str1.contains(str)) {
				return true;
			}
			count += 1;
			if (w.getText().contains("")) {
				act.moveToElement(w).build().perform();
				timeUnitSleepMili(800);
				j += 1;
				boolean result = verifySubHeader(j, str);
				if (result) {
					return true;
				}
				j -= 1;
			}
		}
		return false;
	}

	public WebElement returnSubHeaderElement(int i, String str) throws InterruptedException {
		Actions act = new Actions(driver);
		int j = i;
		List<WebElement> onlyElementList = driver.findElements(By.xpath(getOnlySubHeaderXpath(j)));
		int count = 0;
		for (WebElement w : driver.findElements(By.xpath(getSubHeaderXpath(j)))) {
			timeUnitSleepMili(800);
			String str1 = onlyElementList.get(count).getText();
//			System.out.println(str1);
			if (str1.contains(str)) {
				return onlyElementList.get(count);
			}
			count += 1;
			if (w.getText().contains("")) {
				act.moveToElement(w).build().perform();
				timeUnitSleepMili(800);
				j += 1;
				WebElement result = returnSubHeaderElement(j, str);
				if (result != null) {
					return result;
				}
				j -= 1;
			}
		}
		return null;
	}

	public void clickSubHeader(String str) throws InterruptedException {
		WebElement click = returnSubHeaderElement(1, str);
		if (click != null) {
			click.click();
		}

	}



	public void getAllHeaderSubheader() throws InterruptedException {
		for (WebElement w : mainHeaderLink) {
			System.out.println(w.getText());
			allHeaderNameList.add(w.getText());
			w.click();
//			System.out.println(driver);
			getAllSubHeader(1);
		}
	}


	public void getAllSubHeader(int i) throws InterruptedException {
		Actions act = new Actions(driver);

		int j = i;
		List<WebElement> onlyElementList = driver.findElements(By.xpath(getOnlySubHeaderXpath(j)));
//		int size = onlyElementList.size();
		int count = 0;
		for (WebElement w : driver.findElements(By.xpath(getSubHeaderXpath(j)))) {
			timeUnitSleepMili(800);
//			changeColorOnHover(w);
//			System.out.println(w.getText());
			allHeaderNameList.add(onlyElementList.get(count).getText());
			System.out.println(j + " " + count + " " + onlyElementList.get(count).getText());
			count += 1;
			if (w.getText().contains("")) {
				act.moveToElement(w).build().perform();
				timeUnitSleepMili(800);
				j += 1;
				getAllSubHeader(j);
				j -= 1;
			}

		}

	}

	public void extractHeaderDataToExcel(String sheetName) {
		ExcelDataFile excelfile = new ExcelDataFile(System.getProperty("user.dir") + "\\testData\\BeCognizantUserInformation.xlsx");

		if (excelfile.isSheetExist(sheetName)) {
			excelfile.removeSheet(sheetName);
		}
		excelfile.addSheet(sheetName);
//		System.out.println("allHeaderNameList.size()"+allHeaderNameList.size());
		for (int i = 0; i < allHeaderNameList.size(); i++) {
//			System.out.println(".");
			excelfile.setCellData( sheetName,1,i+1,allHeaderNameList.get(i));
		}
	}

	public String getSubHeaderXpath(int i) {
		String str = "//div[contains(@class,'ms-Layer ms-Layer--fixed')][" + i + "]/descendant::li";
		return str;
	}

	public String getOnlySubHeaderXpath(int i) {
		String str = "//div[contains(@class,'ms-Layer ms-Layer--fixed')][" + i + "]/descendant::li/descendant::span";
		return str;
	}

}
