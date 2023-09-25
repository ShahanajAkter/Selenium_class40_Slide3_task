package Task_class40_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_5_sel_3_C_b {

	static WebDriver dr;

	public static void main(String[] args) {
		System.setProperty("webdrivwe.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");

		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(5000);

// goto url
			dr.get("https://demoqa.com/alerts");
			Thread.sleep(7000);

	WebElement	first_box=dr.findElement(By.xpath("//button[text()='Click me' and @id='alertButton']"));
	first_box.click();
	Thread.sleep(3000);
		dr.switchTo().alert().accept();
		Thread.sleep(3000);
		WebElement	second_box=dr.findElement(By.xpath("//button[text()='Click me' and @id='timerAlertButton']"));
		second_box.click();
		Thread.sleep(12000);
		dr.switchTo().alert().dismiss();
		Thread.sleep(12000);
		WebElement	third_box=dr.findElement(By.id("confirmButton"));
		third_box.click();
		Thread.sleep(12000);
		dr.switchTo().alert().accept();
		Thread.sleep(12000);
		WebElement	fourth_box=dr.findElement(By.id("promtButton"));
		fourth_box.click();
		Thread.sleep(12000);
		
		dr.switchTo().alert().sendKeys("This is alert box");
		Thread.sleep(5000);
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("problem in try block");
			System.out.println("click add manually");
			System.out.println("scroll down manually after second element");
			
		} 
	        finally { dr.close(); }
			 
}

}
