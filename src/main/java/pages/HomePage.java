package pages;

import basics_funcations.PagesBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PagesBase {
   private WebDriver driver;
   //Elements
   private By englishField= By.xpath("//a[@id='profile-tab']");
   private By brandSections=By.tagName("h2");
   private By iphonSectionField=By.xpath("/html/body/app-root/div/app-notfound-page/div/app-brand/div/div/div[1]/ul/li[7]/a/div/img");

   public HomePage (WebDriver driver){
       super(driver);
       this.driver=driver;
    }
    public void changeLanguage(){
       WebElement element=driver.findElement(englishField);
       waitForElement(element);
       element.click();
       //close cookies
        driver.findElement(By.xpath("/html/body/app-root/div/app-cookie/div/div/p/i")).click();
    }
    public IphoneCategoryPage selectCategory(){
        driver.findElement(brandSections);
        WebElement element=driver.findElement(iphonSectionField);
        waitForElement(element);
        element.click();
        return new IphoneCategoryPage(driver);
    }

}
