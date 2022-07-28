package test.runner;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

	@Karate.Test
    Karate testPetsStore() {
        return Karate.run().relativeTo(getClass());
    }

	
} 
