package suite2;
//test
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;

public class TestCase2 extends BaseClass{
	SoftAssert sa=new SoftAssert();
	
	@Test
	public void verificationOftestingWorld()
	{
		try
		{
			loadProperties();
			InvokeApplication();
		getElementbyXpath("xpathTestingLink").click();
String strActual=getElementbyXpath("xpathTestingLabel").getText();
System.out.println(strActual);
String strExpected="Welcome To My Testing Words";
		//assertEquals(strActual, strExpected);

sa.assertEquals(strActual, strExpected);
Thread.sleep(3000);
sa.assertAll();



		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	@AfterSuite
	public void tearDown()
	{
	
		
		driver.quit();
	}
}