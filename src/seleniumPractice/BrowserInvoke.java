package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInvoke {

	public static void main(String[] args) throws InterruptedException {

		//setting system properties
		System.setProperty("webdriver.chrome.driver", "/home/sesidharn/Downloads/chromedriver_linux64 (1)/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String url=driver.getCurrentUrl();
		System.out.println(url); 
		System.out.println(driver.getTitle().charAt(3));
		System.out.println(driver.getTitle());
		int r=driver.getTitle().indexOf("l");//index of l
		System.out.println(r);
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(1000);
		driver.findElement(By.className("sbtc")).click();
		System.out.println(driver.getTitle());
		driver.close();
	
	}

}
