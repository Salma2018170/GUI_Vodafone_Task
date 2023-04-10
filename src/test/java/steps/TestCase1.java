package steps;

import hooks.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.IphoneCategoryPage;
import pages.ItemDetailsPage;
import pages.ShoppingCartPage;

public class TestCase1 extends Base {
    HomePage homePage;
    IphoneCategoryPage iphoneCategoryPage;
    ItemDetailsPage itemDetailsPage;
    ShoppingCartPage shoppingCartPage;
    String URL ="https://eshop.vodafone.com.eg/shop#/home";
    @Given("User go to Vodafone Shop website")
    public void user_go_to_vodafone_shop_website() {
        setUp();
        driver.navigate().to(URL);
        homePage=new HomePage(driver);
    }
    @When("User select language as English , Go to Shop By Brand section and select Iphone")
    public void user_select_language_as_english_go_to_shop_by_brand_section_and_select_iphone() {
        homePage.changeLanguage();
        iphoneCategoryPage=homePage.selectCategory();
    }
    @When("User select any of returned iphone mobiles and press add to cart")
    public void user_select_any_of_returned_iphone_mobiles_and_press_add_to_cart() {
        itemDetailsPage=iphoneCategoryPage.selectSpecificItem();
        shoppingCartPage= itemDetailsPage.AddItemToCart();

    }
    @When("User Press Proceed to Checkout and Select Delivery Options as {string} and {string} and Select Deliver to My Address")
    public void user_press_proceed_to_checkout_and_select_delivery_options_as_and_and_select_deliver_to_my_address(String string, String string2) {
        shoppingCartPage.clickOnCheckout();
        shoppingCartPage.selectDeliveryOptions(string, string2);
    }
    @When("User Add address details StreetName as {string} BuildingNO as {string} FloorNO as {string} ApartmentNO as {string} LandMarkField as {string} AddressName as {string} and Press continue")
    public void user_add_address_details_street_name_as_building_no_as_floor_no_as_apartment_no_as_land_mark_field_as_address_name_as_and_press_continue(String streetName, String buildingNO, String floorNO, String apartmentNO,String landmarkName, String addressName) {
        shoppingCartPage.setStreetNameField(streetName);
        shoppingCartPage.setBuildingNOField(buildingNO);
        shoppingCartPage.setFloorNOField(floorNO);
        shoppingCartPage.setApartmentNOField(apartmentNO);
        shoppingCartPage.setLandMarkField(landmarkName);
        shoppingCartPage.setAddressNameField(addressName);
    }
    @When("Leave Personal info empty and Press continue")
    public void leave_personal_info_empty_and_press_continue() {
        shoppingCartPage.clickOnFirstContinue();
        shoppingCartPage.clickOnSecondContinue();
    }
    @Then("error message returned from Full Name field")
    public void error_message_returned_from_full_name_field() {
        Assert.assertTrue(shoppingCartPage.checkMessage(),"full name is not empty");
        tearDown();
    }
}
