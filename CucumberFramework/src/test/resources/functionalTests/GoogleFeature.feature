Feature: Chech the google page

Background:
 Given Launch the browser
 

@Test1
	Scenario: Search the wikipedia page
    When Enter the Pet store url "https://www.google.com/"
 		Then Verify the google title
 #		When Enter the text in search box and hit enter
 #		When Click on the first link
 #		Then Verify the Page title
 		
 		
 		@Test2
	Scenario: Search the wikipedia page
    When Enter the text in search box and hit enter
 		When Click on the first link
 		Then Verify the Page title
   
    
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
    