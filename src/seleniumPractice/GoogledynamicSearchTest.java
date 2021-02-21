package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogledynamicSearchTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/home/sesidharn/Downloads/chromedriver_linux64 (1)/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		String keyword = "testing";
		driver.findElement(By.name("q")).sendKeys(keyword);

		List<WebElement> suggestlinks = driver
				.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='sbl1']"));

		System.out.println("Available suggestion list based on entry keyword" + " '" + keyword + "' " + "-->"
				+ suggestlinks.size());
		
		for (int i = 0; i < suggestlinks.size(); i++) {
			
			if (suggestlinks.get(i).getText().equalsIgnoreCase("testing life cycle")) {
				suggestlinks.get(i).click();
				break;
			}
		}
		System.out.println(driver.getTitle());
		driver.close();
	}

}
