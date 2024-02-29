package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void timeUnitSleepMili(int time) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(time);
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
}
