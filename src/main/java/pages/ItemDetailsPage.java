package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage {
    private WebDriver driver;
    //Element
    private By addCartButton=By.className("btn-block");
    public ItemDetailsPage(WebDriver driver){
        this.driver=driver;
    }
    public ShoppingCartPage AddItemToCart(){
        driver.findElement(addCartButton).click();
        return new ShoppingCartPage(driver);
    }
}
