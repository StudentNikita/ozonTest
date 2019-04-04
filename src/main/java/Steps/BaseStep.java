package Steps;

import Util.DriverManager;
import Util.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void setUp(){
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(properties.getProperty("app.url"));
    }

    @After
    public void tearDown(){
        //DriveManager.quitDriver();
    }
}