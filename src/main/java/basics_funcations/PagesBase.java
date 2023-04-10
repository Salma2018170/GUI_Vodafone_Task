package basics_funcations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PagesBase {
   private WebDriver driver;
   private static final Duration DURATION=Duration.ofMinutes(2);
   public PagesBase(WebDriver driver){
       this.driver=driver;
   }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,DURATION);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
