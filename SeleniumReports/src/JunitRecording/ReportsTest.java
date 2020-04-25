package JunitRecording;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class ReportsTest {

	@Test
	public void RunReport() throws InterruptedException {
		
		String path = System.getProperty("user.dir");
		/*
		 * String URL =
		 * "https://s4h-qa.tauranga.govt.nz/sap/bc/ui2/flp?sap-client=400&sap-language=EN#Shell-home";
		 * String username = "SAPPERF28@tauranga.govt.nz"; String password =
		 * "5AP-User!";
		 */
		
		System.setProperty("webdriver.chrome.driver", path+"/Resources/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		 
			/*
			 * driver.get(URL); //Thread.sleep(2000);
			 * driver.findElement(By.name("loginfmt")).sendKeys(username);
			 * driver.findElement(By.id("idSIButton9")).click();
			 * driver.findElement(By.name("passwd")).sendKeys(password);
			 * driver.findElement(By.id("idSIButton9")).click();
			 */
		
			navigateToReport(driver);
		
	}
	
	public static void navigateToReport(WebDriver driver) throws InterruptedException {
		String username = "SAPPERF28@tauranga.govt.nz";
		String password = "5AP-User!";
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://s4h-qa.tauranga.govt.nz/sap/bc/ui2/flp?sap-client=400&sap-language=EN#Shell-home");
	    driver.wait();
	    Thread.sleep(2000);
		driver.findElement(By.name("loginfmt")).sendKeys(username);
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.id("idSIButton9")).click();
	    //driver.manage().window().setSize(new Dimension(1440, 828));
	    {
	      WebElement element = driver.findElement(By.id("__tile7-title-inner"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    
	    driver.findElement(By.id("sapUshellAnchorBarOverflowButton-img")).click();
	    driver.findElement(By.cssSelector("#\\__item4-__list1-13-content .sapMSLITitleOnly")).click();
	    driver.findElement(By.id("__tile37-subHdr-text")).click();
	    driver.findElement(By.id("fin_acc_query_analyze_2CZBIFIGLQ002sapbi_snippet_ROOT")).click();
	    driver.findElement(By.id("fin_acc_query_analyze_2CZBIFIGLQ002VARSCREEN_filterpanel1")).click();
	    driver.findElement(By.id("fin_acc_query_analyze_2CZBIFIGLQ002OK-inner")).click();
	  }

}
