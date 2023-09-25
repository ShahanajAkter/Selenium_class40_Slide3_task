package Task_class40_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_1_sele_3 {
	static WebDriver dr;

	public static void main(String[] args) {
		System.setProperty("webdrivwe.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");

		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(2000);

// goto url
			dr.get("https://www.hyrtutorials.com/");
			Thread.sleep(2000);
//hoverOver on selenium practice
		WebElement selenium_prac=dr.findElement(By.xpath("//a[contains(text(),'Selenium Practice')]"));
		Actions act=new Actions(dr);
		act.moveToElement(selenium_prac).build().perform();
		Thread.sleep(1000);
//click xpath practice
	WebElement xpath_prac=	dr.findElement(By.xpath("//a[contains(text(),'XPath Practice')]"));
		act.moveToElement(xpath_prac).click().build().perform();
		Thread.sleep(1000);

	//with help of parent to child --xpath**d
WebElement reset=	dr.findElement(By.xpath("//div[@class='buttons']/child::button[text()='Reset']"));

	//with help of ancestors to descendant**e	
		
WebElement reset1=	dr.findElement(By.xpath("//div[@class='container']/descendant::button[text()='Reset']"));

//with help of preceding sibling to following sibling --xpath**f

WebElement reset2=	dr.findElement(By.xpath("//button[text()='Clear']/following-sibling::button[text()='Reset']"));	

//with help of following sibling to preceding sibling  --xpath**g

WebElement reset3=	dr.findElement(By.xpath("//input[@name='refreshbtn']/preceding-sibling::button[text()='Reset']"));

//with help of descendant to ancestors  **h
WebElement reset4=	dr.findElement(By.xpath("//button[text()='Reset']/ancestor::div[@class='container']"));
//not possible for reset to locate as grand parents

//with help of preceding element to following element --xpath**i
WebElement reset5=	dr.findElement(By.xpath("//button[text()='Register']/following::button[text()='Reset']"));

//with help of following  element to preceding element --xpath**j
WebElement reset6=	dr.findElement(By.xpath("//input[@value='Refresh']/preceding::button[text()='Reset']"));	
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("problem in try block");
			
		}finally {
			dr.close();
		}
}
}