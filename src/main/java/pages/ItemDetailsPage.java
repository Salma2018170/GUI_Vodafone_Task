package pages;

import basics_funcations.PagesBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemDetailsPage extends PagesBase {
    private WebDriver driver;
    //Element
    private By addCartButton=By.className("btn-block");
    public ItemDetailsPage(WebDriver driver){

        super(driver);
        this.driver=driver;
    }
    public ShoppingCartPage AddItemToCart(){
        WebElement element=driver.findElement(addCartButton);
        waitForElement(element);
        element.click();
        return new ShoppingCartPage(driver);
    }
}
