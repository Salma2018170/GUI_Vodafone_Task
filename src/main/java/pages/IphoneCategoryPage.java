package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IphoneCategoryPage {
  private WebDriver driver;
  //Elements
    By itemField=By.xpath("//*[@id=\"home-0\"]/div/ul/li[6]/a/div/div[3]/a");
          //xpath("//a[@sec_uuid='d0f7d65bf5f9']");
    public IphoneCategoryPage(WebDriver driver){
        this.driver=driver;
    }
    public ItemDetailsPage selectSpecificItem(){
    driver.findElement(itemField).click();
    return new ItemDetailsPage(driver);
    }
}
