package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IphoneCategoryPage;
import pages.ItemDetailsPage;
import pages.ShoppingCartPage;

import java.time.Duration;

public class Testcase1 {
    WebDriver driver;
    //pages classes
    HomePage homePage;
    IphoneCategoryPage iphoneCategoryPage;
    ItemDetailsPage itemDetailsPage;
    ShoppingCartPage shoppingCartPage;
    String URL ="https://eshop.vodafone.com.eg/shop#/home";
    @Test
    public void base(){
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     driver.navigate().to(URL);
     homePage=new HomePage(driver);
     //changelanguge
        homePage.changeLanguage();
        //selectiphone
        iphoneCategoryPage=homePage.selectCategory();
        //////////
        ////////another page select iphone watch
        itemDetailsPage=iphoneCategoryPage.selectSpecificItem();
       shoppingCartPage= itemDetailsPage.AddItemToCart();

        //checkout
        shoppingCartPage.clickOnCheckout();
        //select city and town and Select “Deliver to My Address”
        shoppingCartPage.selectDeliveryOptions();
        //9- Add address details.
        shoppingCartPage.setStreetNameField("emam yousef");
        shoppingCartPage.setBuildingNOField("12");
        shoppingCartPage.setFloorNOField("12");
        shoppingCartPage.setApartmentNOField("12");
        shoppingCartPage.setLandMarkField("cairo");
        shoppingCartPage.setAddressNameField("yarab");

        //contain
        shoppingCartPage.clickOnFirstContinue();
        shoppingCartPage.clickOnSecondContinue();

       //Asseration
        Assert.assertTrue(shoppingCartPage.checkMessage(),"full name is not empty");
    }
   // @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
