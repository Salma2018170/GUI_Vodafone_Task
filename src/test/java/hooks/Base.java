package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
   protected WebDriver driver;
    protected Properties properties = new Properties();
    //@BeforeTest
    public void setUp() throws IOException {
        File file = new File("src/main/resources/properties/config.properties");
        FileInputStream stream = new FileInputStream(file);
        properties.load(stream);
        if(properties.getProperty("browserName").equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if(properties.getProperty("browserName").equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    //@After
    public void tearDown(){

        driver.close();
    }
}
