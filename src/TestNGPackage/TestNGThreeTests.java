package TestNGPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;




public class TestNGThreeTests {
  
	public WebDriver driver;
	
	@BeforeTest
	public void openApplication()
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		  driver = new ChromeDriver();

		  		 String url = "http://newtours.demoaut.com/";
		  	
		  		 	  	driver.manage().window().maximize();
		  		 	  	driver.get(url);
		
	}
	
	

	
	@Test(priority=0)
  public void verifyRegisterLink() {
	  String sExpected ="Register: Mercury Tours";
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		String actualresult = driver.getTitle();
		org.testng.Assert.assertEquals(actualresult, sExpected);
		

		
  }
	@Test(priority=1)
	public void userRegistraion() throws InterruptedException
	{
		driver.findElement(By.name("firstName")).sendKeys("Testfirstname");
 	  	driver.findElement(By.name("lastName")).sendKeys("Testlastname");
 	  	driver.findElement(By.name("phone")).sendKeys("8888888889");
 	  	driver.findElement(By.name("userName")).sendKeys("testusername");
 	  	driver.findElement(By.name("address1")).sendKeys("testaddress");
 	  	driver.findElement(By.name("address2")).sendKeys("testaddress2");
 	  	driver.findElement(By.name("city")).sendKeys("Herndon");
 	  	driver.findElement(By.name("state")).sendKeys("Va");
 	  	driver.findElement(By.name("postalCode")).sendKeys("23456");
 	  	Select drpcountry = new Select(driver.findElement(By.name("country")));
 	    drpcountry.selectByVisibleText("UNITED STATES");
 	   driver.findElement(By.name("email")).sendKeys("Test@test.com");
 	   driver.findElement(By.name("password")).sendKeys("Test1234$");
 	   driver.findElement(By.name("confirmPassword")).sendKeys("Test1234$");
 	   driver.findElement(By.name("register")).click();
 	   Thread.sleep(2000);
 	   
 	//one way to write logic
 	 //  String expectedresult = "Note: Your user name is Test@test.com.";
 	   
 	  // String actualresult = driver.findElement(By.xpath("html>body>div>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>p>a>font>b")).getText();
 	   
 	 // org.testng.Assert.assertEquals(actualresult, expectedresult);
 	
 	  
 // another way 
 	 String expectedresult = "Your user name is Test1@test.com.";
 	  String  sActualValue=driver.findElement(By.tagName("Body")).getText();
 	  System.out.println(sActualValue);
 	  org.testng.Assert.assertTrue(sActualValue.contains(expectedresult));
 	  
 	  
 	  
 	 //  System.out.println( "check user registrion:"+sActualValue.contains(sExpected));
 	 	 	  
 	  // driver.findElement(By.linkText("SIGN-OFF")).click();
 	   Thread.sleep(2000);
	}

	@Test(timeOut=5000)
	public void bookflight()
	{
	driver.findElement(By.linkText("Flights")).click();
	}
	
	@AfterTest
	public void closeApplication()
	{
		driver.close();
		   driver.quit();
	}
	}
	


