package Task_class40_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_5_sel_3_C_a  extends Commom_methods{
	static WebDriver dr;

	public static void main(String[] args) {
		System.setProperty("webdrivwe.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");

			dr = new ChromeDriver();
			dr.manage().window().maximize();
			

// goto url
			dr.get("https://www.hyrtutorials.com/");
			dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//hoverOver on selenium practice
		WebElement selenium_prac=dr.findElement(By.xpath("//a[contains(text(),'Selenium Practice')]"));
		Actions act=new Actions(dr);
		act.moveToElement(selenium_prac).build().perform();
		
//click Alert
	WebElement alarts=	dr.findElement(By.xpath("//a[text()='Alerts']"));
		act.moveToElement(alarts).click().build().perform();
	
		//for handling add question
		//dr.findElement(By.xpath("//span[text()='Close']")).click();
		
	WebElement	first_box=dr.findElement(By.xpath("//button[text()='Click me' and @id='alertBox']"));
	//JavascriptExecutor js=	(JavascriptExecutor)dr;
	//js.executeScript("arguments[0].click()", first_box);
	first_box.click();

		dr.switchTo().alert().accept();
		
		WebElement	second_box=dr.findElement(By.xpath("//button[text()='Click me' and @id='confirmBox']"));
		second_box.click();
		
		dr.switchTo().alert().dismiss();
		WebElement	third_box=dr.findElement(By.xpath("//button[text()='Click me' and @id='promptBox']"));
		third_box.click();
		//explecit_wait(third_box);
		
		dr.switchTo().alert().sendKeys("This is alert box");
		
		dr.switchTo().alert().accept();
		

		
			dr.close(); 
			 
}

}
