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

import junit.framework.Assert;

import org.openqa.selenium.interactions.Actions;

class ReportsTest {

	@Test
	public void RunReport() throws InterruptedException {
		
		int iterations = 2;
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
		driver.findElement(By.xpath("//div[@id='centerViewPort']/div[@class='sapUShellApplicationContainer sapUshellApplicationPage sapUshellDefaultBackground sapUshellViewPortItemSlideFrom']/div[@class='sapUShellApplicationContainer sapUiComponentContainer']//div[@class='sapUiBody sapZenDshDsh']/div[@class='sapbi_snippet_ROOT']/div[@class='designmodeborder sapUiLayoutAbs sapUiLayoutAbsOvrflwXHidden sapUiLayoutAbsOvrflwYHidden zenControl zenborder']/div[1]/div[@class='sapUiLayoutAbs sapUiLayoutAbsOvrflwXHidden sapUiLayoutAbsOvrflwYHidden zenControl zenborder']/div[2]/div[@class='sapUiLayoutAbs sapUiLayoutAbsOvrflwXHidden sapUiLayoutAbsOvrflwYHidden sapbi_body zenControl zenborder']/div[@class='sapUiLayoutAbsPos']//div[@class='sapUiLoSplitter sapUiLoSplitterH zenControl zenborder']/section[1]//div[@class='sapContrastPlus sapMNav zenControl zenNavigationPanelM']/div/section[@class='sapMPageEnableScrolling']/div/section[1]/div/section[@class='sapMPageEnableScrolling']//div[@role='toolbar']/div[@role='heading']/span[.='DIMENSIONS']"));
		driver.navigate().back();
		
		//driver.findElement(By.xpath("//a[@id='backBtn']/span[.='']")).click();
		Thread.sleep(2000);
		}
		driver.close();
	  }

}
