Feature: Register new user to Pet Store website to searching the product
Login wiith the created user
Add product to the cart
Place the order
Sign out 

Background:
 Given Launch the browser
 When Enter the Pet store url "https://petstore.octoperf.com/actions/Catalog.action"
 Then Verify the pet store title

@UserRegisteration
	Scenario: Register the new user to Pet store
    Given Launch the browser
    When Enter the Pet store url "https://petstore.octoperf.com/actions/Catalog.action"
    Then Verify the pet store title 
    When Click on Sign In link
    And Click on Register Now link
    And Enter User enters UserID
    And Enter New Password and repeat password
    And Enter First Name and Last Name 
    And Enter email and Phone
    And Enter Address1 and Address2
    And Enter city and State
    And Enter Zip and Country
    And Select Language preference and Favourite Category
    And Enable the My checklist and MyBanner checkBox
    And click on Save Account Information button
    
 #@UserLogin
#	Scenario Outline:  Login to the pet store with registered user
    #Given Launch the browser
    #When Enter the Pet store url "https://petstore.octoperf.com/actions/Catalog.action"
    #Then Verify the pet store title 
    #When Click on Sign In link
    #And Enter username "<Email>" and password "<Password>"
    #And Click on Login button
    #Then Verify the welcome message 
    #
     #Examples:
    #| Email | Password |
    #| Demo2 | Demo2@123 |
    #
 #@AddtoCart
#	Scenario Outline: Select and Adding product to the cart   
    #When Click on Sign In link
    #And Enter username "<Email>" and password "<Password>"
    #And Click on Login button
    #Then Verify the welcome message  
    #When Select Required product from the menu as "Fish"
    #Then Verify the List Name as "Fish"
    #When Select Product ID from the table as "FI-SW-01"
    #And Click on AddToCart button of Item ID from the table
    #Then Verify the Shopping cart that selected product is available in the cart table
    #
     #Examples:
    #| Email | Password |
    #| Demo2 | Demo2@123 |
    #
 #@PurchaseProduct
#	Scenario Outline: Purchase the product by replacing order
    #When Click on Sign In link
    #And Enter username "<Email>" and password "<Password>"
    #And Click on Login button
    #Then Verify the welcome message 
     #When Select Required product from the menu as "Fish"
    #Then Verify the List Name as "Fish"
    #When Select Product ID from the table as "FI-SW-01"
    #And Click on AddToCart button of Item ID from the table
    #Then Verify the Shopping cart that selected product is available in the cart table
    #And Click on home button 
    #When Click on Cart Icon
    #Then Verify the Shopping Cart should not be empty 
    #When Click on the ProceedToCheckout button
    #And Click on Continue button
     #And Click on Confirm button
    #Then Verify the Success message as "Thank you, your order has been submitted."
    #When Click on Sign Out button
    #
    #Examples:
    #| Email | Password |
    #| Demo2 | Demo2@123 |
#
    #
    #
    #
    