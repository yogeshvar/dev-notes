Feature: Get the list of items available in Vikas Maggi Plaza

	Scenario: A new customer comes in
		Given A new customers get into the hotel
		When A new customer place an order	
		Then He should get an welcome message 


	Scenario: A customer wants to get the list of items
		Given A customer gets into the hotel
		When he asks the list of items available 
		Then He should get the list of items available
