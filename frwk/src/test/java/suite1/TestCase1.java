package suite1;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class TestCase1 extends BaseClass{


	@Test
	public void TestCase11()
	{
		try
		{
		loadProperties();
		InvokeApplication();
	getElementbyID("username").sendKeys(Keys.SHIFT,"Hello Done");
	getElementbyXpath("password1").sendKeys("hnmmnm");
			Thread.sleep(3000);
		getElementbyID("chkTester").click();
		Thread.sleep(3000);	
		driver.quit();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		}
	
}
