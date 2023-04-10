package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
   private WebDriver driver;
   //Elements
   private By englishField= By.xpath("//a[@id='profile-tab']");
   private By brandSections=By.tagName("h2");
   private By iphonSectionField=By.xpath("//a[@href='/shop/shopByBrand/Apple']");
   public HomePage (WebDriver driver){
        this.driver=driver;
    }
    public void changeLanguage(){
        driver.findElement(englishField).click();
    }
    public IphoneCategoryPage selectCategory(){
        driver.findElement(brandSections);
        driver.findElement(iphonSectionField).click();
        return new IphoneCategoryPage(driver);
    }

}
