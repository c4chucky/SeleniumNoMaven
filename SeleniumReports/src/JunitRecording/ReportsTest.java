package JunitRecording;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.rules.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class ReportsTest {
	

	public static Stopwatch timer = new Stopwatch();
	
	//@Before
    public static WebDriver initialiseDriver()
    {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        System. setProperty("webdriver.chrome.driver", "D:\\AutomationPractice\\chromedriver_win32\\chromedriver.exe");
        return driver;
    }
	
	@Test
	public void RunReport() throws InterruptedException {
		
		//int iterations = 1;
		boolean run = true;
		
		String[] users = {"SAPPERF28", "SAPPERF29", "SAPPERF27"};
		String password = "5AP-User!";
		
		while (run) {
		 for (String user : users) {
			 String username = user+"@tauranga.govt.nz";
			 WebDriver driver = initialiseDriver();
			 sapLogin(driver, username, password);
			 Thread.sleep(3000);
			 navigateToReport(driver);
		 	}
		 Thread.sleep(9000);
		}
	}
	
	/*
	 * public static WebDriver initialiseDriver() { String path =
	 * System.getProperty("user.dir"); System.setProperty("webdriver.chrome.driver",
	 * path+"/Resources/chromedriver.exe"); WebDriver driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); return
	 * driver; }
	 */
	@Test
	static void sapLogin(WebDriver driver, String username, String password) throws InterruptedException {
		driver.get("https://s4h-qa.tauranga.govt.nz/sap/bc/ui2/flp?sap-client=400&sap-language=EN#Shell-home");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement loginField;
		WebElement nextButton;
		
		loginField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
		loginField.click();
		
		driver.findElement(By.name("loginfmt")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("idSIButton9")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.id("aadTile")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.name("passwd")).sendKeys(password);
		
		Thread.sleep(2000);
		nextButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		nextButton.click();
		
		Thread.sleep(2000);
		nextButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		long startTime = System.currentTimeMillis();
		nextButton.click();
				
		//System.out.println("Login Wait Time is: "+ timer.runtime(TimeUnit.SECONDS));
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shell-header-icon")));
		
		long endTime = System.currentTimeMillis();
		//System.out.println("Login EndTime is: " + endTime);
		long timeToLoad= (System.currentTimeMillis()-startTime);
		System.out.println("Login Load Time is: " + timeToLoad);
		
		try {
			LogLoadTime("ReportLoadTime", timeToLoad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.findElement(By.id("/html//img[@id='shell-header-icon']"));
		
	}
	
	public static void navigateToReport(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.findElement(By.xpath("//div[@id='anchorNavigationBar']//ul[@role='listbox']/li[2]/div[@class='sapUshellAnchorItemInner']")).click();
		
		//for (int i=1; i<=3; i++) {
		WebElement ele = driver.findElement(By.xpath("//div[@id='dashboardGroups']//div[@class='sapUshellEmptyLinksAreaPlaceHolder sapUshellLinksAreaHidden sapUshellTileContainer']//ul[@role='listbox']/li[1]//div[@class='sapUiJSView sapUiView sapUiViewDisplayBlock']/div[@role='button']//span[@class='sapMGTTitle sapMText sapMTextMaxWidth sapUiSelectable']/span[@class='sapMTextLineClamp sapMTextMaxLine']"));
		//Thread.sleep(20000);
		
		long startTime = System.currentTimeMillis();
		ele.click();
		//System.out.println("Login Wait Time is: "+ timer.runtime(TimeUnit.SECONDS));
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shell-header-icon")));
		
		long endTime = System.currentTimeMillis();
		//System.out.println("Login EndTime is: " + endTime);
		long timeToLoad= (System.currentTimeMillis()-startTime);
		System.out.println("Report Load Time is: " + timeToLoad);
		
		try {
			LogLoadTime("ReportLoadTime", timeToLoad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//div[@id='centerViewPort']/div[@class='sapUShellApplicationContainer sapUshellApplicationPage sapUshellDefaultBackground sapUshellViewPortItemSlideFrom']/div[@class='sapUShellApplicationContainer sapUiComponentContainer']//div[@class='sapUiBody sapZenDshDsh']/div[@class='sapbi_snippet_ROOT']/div[@class='designmodeborder sapUiLayoutAbs sapUiLayoutAbsOvrflwXHidden sapUiLayoutAbsOvrflwYHidden zenControl zenborder']/div[1]/div[@class='sapUiLayoutAbs sapUiLayoutAbsOvrflwXHidden sapUiLayoutAbsOvrflwYHidden zenControl zenborder']/div[2]/div[@class='sapUiLayoutAbs sapUiLayoutAbsOvrflwXHidden sapUiLayoutAbsOvrflwYHidden sapbi_body zenControl zenborder']/div[@class='sapUiLayoutAbsPos']//div[@class='sapUiLoSplitter sapUiLoSplitterH zenControl zenborder']/section[1]//div[@class='sapContrastPlus sapMNav zenControl zenNavigationPanelM']/div/section[@class='sapMPageEnableScrolling']/div/section[1]/div/section[@class='sapMPageEnableScrolling']//div[@role='toolbar']/div[@role='heading']/span[.='DIMENSIONS']"));
		Thread.sleep(5000);
		driver.navigate().back();
		//driver.findElement(By.xpath("//a[@id='backBtn']/span[.='']")).click();
		Thread.sleep(20000);
		//}
		driver.close();
	  }
	
	public static long timeTracker(String method) {
		long startTime = System.currentTimeMillis();
		//System.out.println("Login Start time is: " + startTime);
		long endTime = System.currentTimeMillis();
		//System.out.println("Login EndTime is: " + endTime);
		long timeToLoad= (System.currentTimeMillis()-startTime);
		System.out.println(method + "Load Time is: " + timeToLoad);
		return timeToLoad;
	}
	
	public static BufferedWriter LogFile() throws IOException {
		String path = System.getProperty("user.dir");
		BufferedWriter writer = new BufferedWriter(new FileWriter(path+"/Reports/LoadTimeReport_" + DateOfToday() + ".csv"));
		return writer;
	}
	
	public static void LogLoadTime(String method, long loadTime) 
			  throws IOException {
			    String str = method + " , " + loadTime + "ms";
			    String path = System.getProperty("user.dir");
			    BufferedWriter writer = new BufferedWriter(new FileWriter(path+"/Reports/LoadTimeReport_" + DateOfToday() + ".csv"));
			    writer.append(str); 
			    writer.close();
			}
	
	public static String DateOfToday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
		 
		LocalDateTime today = LocalDateTime.now();
		 
		//System.out.println(formatter.format(today));
		return formatter.format(today);
	}

}
