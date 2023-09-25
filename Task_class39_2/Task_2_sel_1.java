package Task_class39_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task_2_sel_1 {

	static WebDriver dr;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");
		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(3000);
			dr.get("https://www.facebook.com/");
			Thread.sleep(300);
			dr.navigate().back();
			Thread.sleep(300);
			dr.navigate().forward();
			dr.navigate().refresh();
			Thread.sleep(300);
//click element
			WebElement create_acc = dr.findElement(By.linkText("Create new account"));
			create_acc.click();
			Thread.sleep(2000);
//type an field
			//WebElement first_name = dr.findElement(By.xpath("//input[starts-with(@id,'u_2_b_' )]"));
			WebElement first_name = dr.findElement(By.name("firstname"));
			first_name.clear();
			first_name.sendKeys("Shahanaj");
			Thread.sleep(300);
			//WebElement last_name = dr.findElement(By.xpath("//input[contains(@id,'u_1_d_FM')]"));
			WebElement last_name = dr.findElement(By.name("lastname"));

			last_name.sendKeys("shanu");
			Thread.sleep(300);
			//WebElement email = dr.findElement(By.xpath("//input[@id='u_1_g_1R']"));
			WebElement email= dr.findElement(By.name("reg_email__"));
			email.sendKeys("shahanaj2023@yahoo.com");
			Thread.sleep(1000);
			//WebElement password = dr.findElement(By.xpath("//input[contains(@id,'password_step')]"));
			WebElement password = dr.findElement(By.name("reg_passwd__"));
			password.sendKeys("absdf123");
			Thread.sleep(1000);
// month select by index
			WebElement birthday_month = dr.findElement(By.xpath("//select[contains(@id,'month')]"));

			Select month = new Select(birthday_month);
			month.selectByIndex(9);
			Thread.sleep(1000);
// day select by visible text
			WebElement birthday_Day = dr.findElement(By.xpath("//select[contains(@name,'birthday_day')]"));
			Select Day = new Select(birthday_Day);
			Day.selectByVisibleText("17");
			Thread.sleep(1000);
			WebElement birthday_year = dr.findElement(By.name("birthday_year"));
//year select by value
			Select year = new Select(birthday_year);
			year.selectByValue("1990");
			Thread.sleep(1000);
//redio button female
			WebElement radio_btn_female = dr.findElement(By.xpath("//label[contains(text(),'Female')]"));
			radio_btn_female.click();
			Thread.sleep(1000);
//WebElement radio_btn_male= dr.findElement(By.xpath("//label[contains(text(),'Male')]"));

//WebElement radio_btn_custom= dr.findElement(By.xpath("//label[contains(text(),'Custom')]"));

//click signup
			WebElement signup = dr.findElement(By.xpath("//button[@name='websubmit' and text()='Sign Up']"));
			signup.click();
			Thread.sleep(1000);
//re-enter password
		WebElement re_enter_pass=dr.findElement(By.xpath("//input[contains(@name,'reg_email_confirmation__')]"));
		re_enter_pass.sendKeys("absdf123");
		Thread.sleep(1000);
		signup.click();
		Thread.sleep(1000);
//get title 
			String actual_title = dr.getTitle();
			Thread.sleep(1000);
			dr.navigate().forward();
			Thread.sleep(1000);
			//navigate back
			dr.navigate().back();
	//get session id for browser
			String session_id = dr.getWindowHandle();
			System.out.println(session_id);
			Thread.sleep(1000);
			dr.navigate().refresh();
		} catch (Exception e) {
			System.out.println("problem in try block");
			e.printStackTrace();

		}
		
		  finally { dr.close(); }
		 

	}
}
