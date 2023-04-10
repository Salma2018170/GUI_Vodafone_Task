package pages;

import basics_funcations.PagesBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IphoneCategoryPage extends PagesBase {
  private WebDriver driver;
  //Elements
    By itemField=By.xpath("//*[@id=\"home-0\"]/div/ul/li[6]/a/div/div[3]/a");
          //xpath("//a[@sec_uuid='d0f7d65bf5f9']");
    public IphoneCategoryPage(WebDriver driver){
      super(driver);
      this.driver=driver;
    }
    public ItemDetailsPage selectSpecificItem(){
      WebElement element=driver.findElement(itemField);
      waitForElement(element);
      element.click();
    return new ItemDetailsPage(driver);
    }
}
