package task_class38_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Task_3_sel_2 {
	static WebDriver dr;

	public static void main(String[] args) {
		System.setProperty("webdrivwe.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");

		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(2000);

// goto url
			dr.get("https://www.ebay.com/");
			Thread.sleep(2000);
// navigate back
			dr.navigate().back();
			Thread.sleep(500);
			dr.navigate().forward();
			Thread.sleep(500);
// compare URL/verify***********
			String actualURL = dr.getCurrentUrl();
			System.out.println("*********" + actualURL + "******");
			String expectedURL = "https://www.ebay.com/";

			if (actualURL.equalsIgnoreCase(expectedURL)) {
				System.out.println("URL match");
			} else {
				System.out.println("URL doesn't match");
				System.out.println("This is expected URL " + expectedURL);
				System.out.println("This is actual URL " + actualURL);
			}
			Thread.sleep(2000);
// hoverOver on my ebay
			WebElement myebay = dr.findElement(By.xpath("//a[@title='My eBay' and text()='My eBay']"));
			Actions act = new Actions(dr);
			act.moveToElement(myebay).build().perform();
			Thread.sleep(1000);

// click summary
			WebElement summary = dr.findElement(By.xpath("//a[text()=' Summary' and @class='gh-eb-oa thrd']"));
			act.moveToElement(summary).click().build().perform();
			Thread.sleep(1000);
// get url
			String current_url = dr.getCurrentUrl();
			System.out.println(current_url);
			Thread.sleep(1000);
			dr.navigate().back();
// click all categories
			WebElement all_categories = dr.findElement(By.xpath("//select[@name='_sacat' and @class='gh-sb ']"));
			all_categories.click();
			Thread.sleep(1000);
			Select books = new Select(all_categories);
			books.selectByVisibleText("Books");
			Thread.sleep(1000);
// type in seARCH
			WebElement search = dr
					.findElement(By.xpath("//input[@name='_nkw' and @class='gh-tb ui-autocomplete-input']"));
			search.sendKeys("QA testing Books");
			WebElement search_enter = dr
					.findElement(By.xpath("//input[@class='btn btn-prim gh-spr' and @value='Search']"));
			search_enter.click();
			Thread.sleep(2000);
// get url
			String page_url = dr.getCurrentUrl();
			System.out.println(page_url);
			Thread.sleep(1000);
// click category
			WebElement shop_by_cate = dr.findElement(By.xpath("//button[contains(text(),' Shop by category')]"));
			shop_by_cate.click();
			Thread.sleep(1000);
// click motors
			WebElement motors = dr.findElement(By.xpath("//a[contains(text(),'Motors')]"));
			motors.click();
			Thread.sleep(1000);
// click register
			WebElement register = dr.findElement(By.xpath("//a[contains(text(),'register')]"));
			register.click();
			Thread.sleep(500);
// click personal
			WebElement personal = dr.findElement(By.xpath("//label[@class='segmentActive' and text()='Personal']"));
			personal.click();
			Thread.sleep(1000);
// type first name
			WebElement first_name = dr.findElement(By.xpath("//input[@id='firstname' and @name='firstname']"));
			first_name.clear();
			first_name.sendKeys("shahanaj");
			Thread.sleep(1000);
// type last name
			WebElement last_name = dr.findElement(By.xpath("//input[@id='lastname' and @name='lastname']"));
			last_name.sendKeys("shanu");
			Thread.sleep(1000);
// email
			WebElement email = dr.findElement(By.xpath("//input[@id='Email' and @name='Email']"));
			email.sendKeys("aktershanu22@gmail.com");
			Thread.sleep(1000);
// password
			WebElement password = dr.findElement(By.xpath("//input[@id='password' and @name='password']"));
			password.sendKeys("asdf@1234");
			Thread.sleep(1000);
// show password
			WebElement show_pass = dr.findElement(By.xpath("//input[@type='checkbox' and @id='showpassword']"));
			show_pass.click();
			Thread.sleep(1000);
// create account
			WebElement create_account = dr.findElement(
					By.xpath("//button[@name='EMAIL_REG_FORM_SUBMIT' and @id='EMAIL_REG_FORM_SUBMIT']"));
			create_account.click();
			Thread.sleep(1000);
//session id
		String session_id=dr.getWindowHandle();
		System.out.println(session_id);
		Thread.sleep(1000);
		dr.navigate().refresh();
	String page_title=	dr.getTitle();
	Thread.sleep(500);
	System.out.println(page_title);
	Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("problem in try block");
			e.printStackTrace();

		}finally {
			dr.close();
		}
	}
}