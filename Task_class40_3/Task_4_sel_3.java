package Task_class40_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_4_sel_3 {
	public static WebDriver dr;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");
		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			dr.navigate().refresh();
			Thread.sleep(2000);
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			dr.manage().deleteAllCookies();
			dr.get("https://www.expedia.com/Flights");
			dr.navigate().refresh();
			Thread.sleep(2000);
			WebElement leaving_from = dr.findElement(
					By.xpath("//button[@aria-label='Leaving from' and @data-stid='origin_select-menu-trigger']"));
			Commom_methods.explecit_wait(dr, leaving_from);
			leaving_from.click();
			WebElement leaving_btn_jfk = dr
					.findElement(By.xpath("//input[@id='origin_select' and @placeholder='Leaving from']"));
			Commom_methods.explecit_wait(dr, leaving_btn_jfk);
			leaving_btn_jfk.sendKeys("jfk");
			WebElement drop_down = dr.findElement(
					By.xpath("//button[contains(@aria-label,'New York (JFK - John F. Kennedy Intl.) New York,')]"));

			Actions act = new Actions(dr);

			act.moveToElement(drop_down).click().build().perform();
			Commom_methods.explecit_wait(dr, drop_down);
			dr.findElement(By.xpath("//div[contains(@data-testid,'simple-separator')]")).click();
			Thread.sleep(500);

			WebElement going_to = dr.findElement(
					By.xpath("//button[@aria-label='Going to' and @data-stid='destination_select-menu-trigger']"));
			Commom_methods.explecit_wait(dr, going_to);
			going_to.click();
			WebElement going_btn = dr
					.findElement(By.xpath("//input[@id='destination_select' and @placeholder='Going to']"));
			Commom_methods.explecit_wait(dr, going_btn);
			going_btn.sendKeys("Atlanta");
			Commom_methods.explecit_wait(dr, going_btn);
			WebElement drop_down_atlanta = dr
					.findElement(By.xpath("//button[contains(@aria-label,'Atlanta (ATL - Hartsfield-Jackson')]"));
			act.moveToElement(drop_down_atlanta).click().build().perform();
			Commom_methods.explecit_wait(dr, drop_down_atlanta);
			Thread.sleep(200);
			WebElement date_btn = dr.findElement(By.xpath("//button[contains(@id,'date_form_')]"));
			Commom_methods.explecit_wait(dr, date_btn);
			date_btn.click();
			WebElement oct_11=dr.findElement(By.xpath("//button[contains(@aria-label,'Oct 11, 2023. -. Pri')]"));
			Commom_methods.explecit_wait(dr, oct_11);
			oct_11.click();
			Thread.sleep(200);
			WebElement nov_28=dr.findElement(By.xpath("//button[contains(@aria-label,'Nov 28, 2023. -. Pri')]"));
			Commom_methods.explecit_wait(dr, nov_28);
			nov_28.click();
			

		} catch (Exception e) {
			System.out.println("problem in try block");
			e.printStackTrace();
		} /*
			 * finally { dr.close(); }
			 */
	}

}
