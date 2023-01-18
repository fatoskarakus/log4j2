package BaseClass;

//import org.apache.log4j.PropertyConfigurator;

import Utils.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
   // private static final Logger Log = LogManager.getLogger(BaseClass.class);
//    private static final Logger LogS = LogManager.getLogger(class.);


    // @Before
    public static void loadConfig() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // @Before
    public static WebDriver launchApp() throws IOException {
        loadConfig();
        Log.info("Opening Browser....");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
       // driver.manage().window().setSize(new Dimension(1000, 1500));
        driver.manage().getCookies();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        return driver;
    }

     @After
    public void closeDriver() {
        driver.quit();
    }

    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

//    @AfterSuite()
//    public void afterSuite() {
//        ExtentManager.endReport();
//    }

}