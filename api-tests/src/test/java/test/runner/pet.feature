Feature: Creating and fetching User Details

  Background:
    * url baseUrl

Scenario: Retrieve pets by status

	* def query = { status: 'sold' }
	
	* def soldPets = []
	* def fun = 
	"""
	function(x){ 
		var petObj = { id: x.id, name: x.name }
	  karate.appendTo(soldPets, petObj);
	}
	"""

    Given path '/pet/findByStatus'
    And params query
		When method GET
		Then status 200
		And print response		
		* karate.forEach(response, fun)	