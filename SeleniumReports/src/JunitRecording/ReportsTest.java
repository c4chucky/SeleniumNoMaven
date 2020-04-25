package JunitRecording;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

class ReportsTest {

	@Test
	public void RunReport() throws InterruptedException {
		
		int iterations = 12;
		String path = System.getProperty("user.dir");
		String[] users = {"SAPPERF28", "SAPPERF29", "SAPPERF27"};
		
		System.setProperty("webdriver.chrome.driver", path+"/Resources/chromedriver.exe");
		 
		for (int i = 1; i < iterations; i++) {
		 for (String user : users) {
			 WebDriver driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			 navigateToReport(driver, user);
		 	}
		 Thread.sleep(30000);
		}
	}
	
	public static void navigateToReport(WebDriver driver, String user) throws InterruptedException {
		String username = user+"@tauranga.govt.nz";
		String password = "5AP-User!";
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		
		driver.get("https://s4h-qa.tauranga.govt.nz/sap/bc/ui2/flp?sap-client=400&sap-language=EN#Shell-home");
		
		WebElement loginField;
		loginField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
		loginField.click();
		
		driver.findElement(By.name("loginfmt")).sendKeys(username);
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.name("passwd")).sendKeys(password);
		Thread.sleep(2000);
		WebElement nextButton;
		nextButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		nextButton.click();
		
		nextButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		nextButton.click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='anchorNavigationBar']//ul[@role='listbox']/li[2]/div[@class='sapUshellAnchorItemInner']")).click();
		
		for (int i=1; i<=3; i++) {
		driver.findElement(By.xpath("//div[@id='dashboardGroups']//div[@class='sapUshellEmptyLinksAreaPlaceHolder sapUshellLinksAreaHidden sapUshellTileContainer']//ul[@role='listbox']/li["+i+"]//div[@class='sapUiJSView sapUiView sapUiViewDisplayBlock']/div[@role='button']//span[@class='sapMGTTitle sapMText sapMTextMaxWidth sapUiSelectable']/span[@class='sapMTextLineClamp sapMTextMaxLine']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='homeBtn']/span[.='']")).click();
		Thread.sleep(2000);
		}
		driver.close();
	  }

}
