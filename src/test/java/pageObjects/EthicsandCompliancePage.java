package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EthicsandCompliancePage extends BasePage {
//	WebDriver driver;

	public EthicsandCompliancePage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
	}

	@FindBy(xpath = "//title") WebElement pageTitleLink;
	@FindBy(xpath = "//div[contains(@id, 'title_text')]")
	WebElement topicNameLink;
	@FindBy(xpath = "//div[contains(@data-automation-id, 'personaDetails')]")
	WebElement writerNameLink;
	@FindBy(xpath = "//span[@id=\"CaptionElementView\" and text()='Resources / Links']/ancestor::div[@data-automation-id=\"BaseCollection-FreshData\"]/descendant::div[@id=\"QuicklinksItemTitle\"]")
	List<WebElement> resourcesLinks;
	@FindBy(xpath = "//div[@data-automation-id=\"CanvasZone\"][1]//div[@data-sp-feature-tag=\"Rich Text Editor\"]")
	WebElement contentLink;
	@FindBy(xpath = "//div[@data-automation-id=\"CanvasControl\"][2]//div[@data-automation-id=\"quick-links-item-title\"]")
	List<WebElement> focusAreasLinks;
	@FindBy(xpath = "//*[@id='ethics-compliance-risks']")
	WebElement ethicsComplianceRisksLinks;
	@FindBy(xpath = "//*[@id='ethics-compliance-risks']/ancestor::div[@data-automation-id=\"CanvasZone\"]//div[@data-automation-id=\"CanvasSection\"]")
	WebElement ethicsComplianceRisksContentLinks;
	
	public String getPageTitle() {
		return pageTitleLink.getAttribute("innerHTML");
	}
	
	public void getTopicName() {
		System.out.println("Topic Name: ");
		System.out.println(topicNameLink.getText());
	}

	public void getWriterName() {
		System.out.println("Writer Name: ");
		System.out.println(writerNameLink.getText());
	}

	public void getResourcesLinks() {
		System.out.println("Resources Links: ");
		for (int i = 0; i < resourcesLinks.size(); i++) {
			System.out.println((i + 1) + ". " + resourcesLinks.get(i).getText());
		}
	}

	public void getContent() {
		System.out.println("Content: ");
		System.out.println(contentLink.getText());
	}

	public void getFocusAreasLinks() {
		System.out.println("Focus Areas Links: ");
		for (int i = 0; i < focusAreasLinks.size(); i++) {
			System.out.println((i + 1) + ". " + focusAreasLinks.get(i).getText());
		}
	}

	public void clickEthicsComplianceRisksLink() {
		ethicsComplianceRisksLinks.click();
	}

	public void getEthicsComplianceRisksContent() {
		System.out.println("Ethics Compliance Risks Content : ");
		System.out.println(ethicsComplianceRisksContentLinks.getText());
	}

}
