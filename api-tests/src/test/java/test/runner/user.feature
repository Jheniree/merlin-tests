Feature: Creating and fetching User Details

  Background:
    * url baseUrl

Scenario: Create user

    * def user = read('classpath:createUserPayload.json')
    
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