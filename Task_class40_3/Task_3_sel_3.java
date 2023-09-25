package Task_class40_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_3_sel_3 {
	// div[@class='container']/child::label[text()='First Name ']
	// locate three parent element with help of child element

	static WebDriver dr;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");
		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			dr.navigate().refresh();
			Thread.sleep(5000);

			dr.get("https://www.expedia.com/Flights");
			dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 WebElement leaving = dr.findElement(By.xpath("//button[contains(@aria-label,'Leaving from')]"));
			
			leaving.click();
			Thread.sleep(15000);
			leaving.sendKeys("Jfk");
			Thread.sleep(15000);
		 WebElement going_to = dr
			 .findElement(By.xpath("//button[contains(@aria-label,'Going to')]"));
			
			going_to.click();
			
			Thread.sleep(12000);
			going_to.sendKeys("Atlanta");
			Thread.sleep(7000);

		} catch (Exception e) {
			System.out.println("problem in try block");
			e.printStackTrace();
		} finally {
			dr.close();
		}
	}

}
