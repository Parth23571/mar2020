package suite2;
//1NEW BRANCH TEST rEtEST26.03.20220Stest 17-03-2020 //Hello // updated (modified) // Again //Later //sati //Last//1/20032020//finallys //2403202020.\\spTest
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
