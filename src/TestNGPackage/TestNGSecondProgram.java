package TestNGPackage;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.Reporter;

public class TestNGSecondProgram {
	public WebDriver driver;
    public String baseUrl = "http://newtours.demoaut.com";
   // public String regexpected = "Register: Mercury Tours";
  //   public String actual;
   //  public String userexpected = "Your user name is Test@test.com.";  
   
     @BeforeTest
   
    public void openApplication() throws InterruptedException
    {
    	//***********************************RUNNING IN FIREFOX *************************************************
		   
		   
 		System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
 	 	 driver = new FirefoxDriver();
 		
 	//***********************************************************
 driver.get(baseUrl);
	  Thread.sleep(5000);
    }    

    //@Test(enabled=false) // --  MEANS NO EXECUTION
   
  //  @Test(priority=0,timeOut=5000) // - MEANS 5 SEC
 //@Test(groups={"smoketest"})
   //@Test(priority=0)
   // @Test(priority=0)
    // VERIFYING THE REGISTER LINK
     @Test(priority=0)
     public void SecondTestverifyRegisterLink() throws InterruptedException
    {
    	//regexpected = "Register: Mercury Tours";
    	  driver.findElement(By.linkText("REGISTER")).click();
      	   Thread.sleep(5000);
      	  String actual = driver.getTitle();
      	  String expected="Register: Mercury Tours";
      	 Assert.assertEquals(actual, expected);
   	Reporter.log("Testing the Register link test case sucessfully passed");
    }
 // @Test(dependsOnMethods={"SecondTestverifyRegisterLink"},alwaysRun=true)  
    // MEANS IF DEPENDENT TEST IS PASSED THEN EXECUTE ELSE DON'T EXECUTE
 //   @Test(enabled=false)
  // @Test(priority=1)
 //   @Test
    // VERIFYING THE USER REGISTRATION
 @Test(priority=1)
   public void SecondTestuserRegistration() throws InterruptedException 
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

// 2 ways validating the user registration
 // Validating Logic 1********************************
	 	   
	 //	   String expected= "Note: Your user name is Test@test.com.";	 	    	   
	 //	   String actual = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	 //   Assert.assertEquals(actual, expected);
	 	 //************************************************************  
	 	   
 // Validating Logic 2
	 	   
	 	   String exp ="Your user name is Test@test.com";	 	   
	 	 String  sActualValue=driver.findElement(By.tagName("Body")).getText();	 	 
	 	System.out.println( "check the actual value:"+sActualValue);
	 	// System.out.println( "check user registrion:"+sActualValue.contains(expected));
	 	//  Assert.assertTrue( sActualValue.contains(sExpected), "Checking the User Registration");
	 	   Assert.assertTrue(sActualValue.contains(exp));    	
    }     
    
    @AfterTest
    public void closeApplication()
    {
    	driver.close();
    	driver.quit();
    }
   	  //String expectedTitle = "Register: Mercury Tours";
   	  //String actualTitle = driver.getTitle();
   	  //Assert.assertEquals(actualTitle, expectedTitle);
	
}