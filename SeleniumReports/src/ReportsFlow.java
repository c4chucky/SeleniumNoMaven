import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportsFlow {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		
		System.setProperty("webdriver.chrome.driver", path+"/Resources/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.seleniumhq.org");
		 System.out.println("Chrome Browser Launch Selenium Site"); 

	}

}
