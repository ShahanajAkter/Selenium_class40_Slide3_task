package Task_class40_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_2_sel_3 {
	
	static WebDriver dr;
	public static void main(String[] args) {
		System.setProperty("webdrivwe.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");

		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(2000);

// goto url
			dr.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
			Thread.sleep(2000);
		WebElement password=	dr.findElement(By.xpath("//div[@class='container']/descendant::input[@type='password'][1]"));
        password.sendKeys("asdf@1234");
        
      //with help of parent to child --xpath**d
        WebElement reset=	dr.findElement(By.xpath("(//div/input[@type='password'])[1] "));

        	//with help of ancestors to descendant**e	
        		
        WebElement password1=	dr.findElement(By.xpath("//div[@class='container']/descendant::button[text()='Reset']"));

        //with help of preceding sibling to following sibling --xpath**f

        WebElement password2=	dr.findElement(By.xpath(""));	

        //with help of following sibling to preceding sibling  --xpath**g

        WebElement password3=	dr.findElement(By.xpath(""));

        //with help of descendant to ancestors  **h
        WebElement password4=	dr.findElement(By.xpath("///input[@type='password']/ancestor ::div[@class='container'] "));
        //not possible for reset to locate as grand parents

        //with help of preceding element to following element --xpath**i
        WebElement password5=	dr.findElement(By.xpath("//button[text()='Register']/following::button[text()='Reset']"));

        //with help of following  element to preceding element --xpath**j
        WebElement password6=	dr.findElement(By.xpath("//input[@value='Refresh']/preceding::button[text()='Reset']"));	
        		         
        
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("problem in try block");
	
}finally {
	dr.close();
}
	}
	}
