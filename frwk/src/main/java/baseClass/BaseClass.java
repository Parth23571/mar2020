package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties objects = null;
	public static Properties params = null;
	public static File objectFile = null;
	public static File paramFile = null;

	public static FileInputStream objectFileInput = null;
	public static FileInputStream paramFileInput = null;
	public static WebDriver driver = null;
	public static String baseDir = null;

	public WebElement getElementbyID(String str) {
		WebElement id = null;
		try {
			if (!driver.findElement(By.id(objects.getProperty(str))).isEnabled() == false) {
				if (!driver.findElement(By.id(objects.getProperty(str))).isDisplayed() == false) {
					id = driver.findElement(By.id(objects.getProperty(str)));
				} else {
					System.out.println("Is NOT displayed"+str);
				}

			} else {
				System.out.println("Is NOT enabled"+str);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	public WebElement getElementbyXpath(String str) {
		WebElement xpath = null;
		try {
			if (!driver.findElement(By.xpath(objects.getProperty(str))).isEnabled() == false) {
				if (!driver.findElement(By.xpath(objects.getProperty(str))).isDisplayed() == false) {
					xpath = driver.findElement(By.xpath(objects.getProperty(str)));
				} else {
					System.out.println("Is NOT displayed"+str);
				}

			} else {
				System.out.println("Is NOT enabled"+str);
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return xpath;
	}

	public void InvokeApplication() {
		try {
//System.setProperty("webdriver.chrome.driver", baseDir+"\\src\\main\\java\\browsers\\chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(params.getProperty("url"));
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void loadProperties() {
		try {
			baseDir = System.getProperty("user.dir");

			paramFile = new File(baseDir + "\\src\\main\\java\\configFiles\\param.properties");
			paramFileInput = new FileInputStream(paramFile);
			params = new Properties();
			params.load(paramFileInput);

			objectFile = new File(baseDir + "\\src\\main\\java\\configFiles\\objects.properties");
			objectFileInput = new FileInputStream(objectFile);
			objects = new Properties();
			objects.load(objectFileInput);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
