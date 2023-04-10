Feature:Vodafone Shop Functionality
  @End2End
  Scenario:Vodafone Shop
    Given User go to Vodafone Shop website
    When User select language as English , Go to Shop By Brand section and select Iphone
    And User select any of returned iphone mobiles and press add to cart
    And User Press Proceed to Checkout and Select Delivery Options as "Cairo" and "Ain Shams" and Select Deliver to My Address
    And User Add address details StreetName as "emam yousef" BuildingNO as "12" FloorNO as "2" ApartmentNO as "21" LandMarkField as "school" AddressName as "yousef" and Press continue
    And Leave Personal info empty and Press continue
    Then error message returned from Full Name field