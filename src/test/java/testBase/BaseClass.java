package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;

//	@BeforeClass
	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String br) throws InterruptedException, IOException {

		// loading properties file
		FileInputStream file = new FileInputStream(".//src/test/resources/application.properties");
		p = new Properties();
		p.load(file);

		// Loading log4j2 file
		logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser...");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		timeUnitSleep(35);
		implicitWait(5);
	}

//	@AfterClass
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public void timeUnitSleep(int time) throws InterruptedException {
		TimeUnit.SECONDS.sleep(time);
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		// rename the existing file
		sourceFile.renameTo(targetFile);

		// return the string path
		return targetFilePath;

	}

}
