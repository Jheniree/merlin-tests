Feature: Creating and fetching User Details

  Background:
    * url baseUrl

Scenario: Create user

    * def user =
    """
			{
				"id": 0,
				"username": "jhenigc",
				"firstName": "Jheni",
				"lastName": "Gomes",
				"email": "jhenigc@test.com",
				"password": "jhenipass",
				"phone": "666777888",
				"userStatus": 0
			}
    """
    
    Given path '/user'
		And request user
		When method POST
		Then status 200
		

Scenario: Retrieve user details

    Given path '/user/jhenigc'
		When method GET
		Then status 200
		And print response
    And match response.firstName contains 'Jheni'
    And match response.lastName contains 'Gomes'