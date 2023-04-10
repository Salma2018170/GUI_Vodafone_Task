package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
    private WebDriver driver;
    //Element
    private By checkOutButton =By.xpath("/html/body/app-root/div/app-shoping-cart/div/div[1]/div[2]/div[2]/div[2]/div/div[3]/button") ;
    private By cityField=By.xpath("//*[@id=\"headingOne\"]/div[1]/select");
    private  By townField=By.xpath("//*[@id=\"headingOne\"]/div[2]/select");
    private final By addressField=By.className("tracker");
    //Address Details Element
    private final By streetNameField=By.xpath("//input[@formcontrolname=\"address1\"]");
    private final By buildingNOField=By.xpath("//input[@formcontrolname=\"buildingNumber\"]");
    private final By floorNOField=By.xpath("//input[@formcontrolname=\"floorNumber\"]");
    private final By apartmentNOField =By.xpath("//input[@formcontrolname='appartmentNumber']");
    private final By landMarkField=By.xpath("//*[@id=\"checkout-deliveryAdd\"]/div[1]/div[1]/div/div[5]/div/input");
   private final By addressNameField=By.xpath("//input[@formcontrolname=\"addressName\"]");

   private By continueButtonFirst=By.xpath("//*[@id=\"checkout-deliveryAdd\"]/div[3]/button");
    private By continueButtonSecond=By.id("shippingAddressContinue");
    private By errorMessage=By.xpath("//*[@id=\"collapseTwo\"]/form/div/div/div[1]/div[1]/app-alert/div/div/div/div[2]/div/div/div");
    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickOnCheckout(){
        driver.findElement(checkOutButton).click();
    }
    public void selectDeliveryOptions(){
        Select cityDropDown=new Select(driver.findElement(cityField));
        cityDropDown.selectByValue("0");
        Select townDropDown=new Select(driver.findElement(townField));
        townDropDown.selectByVisibleText("Ain Shams");
        driver.findElement(addressField).click();
    }
    public void setStreetNameField(String streetName){
    driver.findElement(streetNameField).sendKeys(streetName);
    }
    public void setBuildingNOField(String buildingNO){
        driver.findElement(buildingNOField).sendKeys(buildingNO);
    }
    public void setFloorNOField(String floorNO){
        driver.findElement(floorNOField).sendKeys(floorNO);
    }
    public void setApartmentNOField(String apartmentNO){
        driver.findElement(apartmentNOField).sendKeys(apartmentNO);
    }
    public void setLandMarkField(String landMark){
        driver.findElement(landMarkField).sendKeys(landMark);
    }
    public void setAddressNameField(String addressName){
        driver.findElement(addressNameField).sendKeys(addressName);
    }
    public void clickOnFirstContinue(){
        driver.findElement(continueButtonFirst).click();
    }
    public void clickOnSecondContinue(){
        driver.findElement(continueButtonSecond).click();
    }
     public boolean checkMessage() {

        return driver.findElement(errorMessage).isDisplayed();

        //System.out.println(statusText);
    }
}
