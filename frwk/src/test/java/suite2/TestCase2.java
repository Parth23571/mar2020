package suite2;
//26-03-20202//25-03-2020 11s/ 111s/test 17-03-2020 // updated // Again //Later //sati //Last//1/20032020//finallys //2403202020.\\spTest
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
