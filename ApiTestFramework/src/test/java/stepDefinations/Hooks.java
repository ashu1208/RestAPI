package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void BeforeScenario() throws IOException 
	{
		StepDefination m=new StepDefination();
		if(StepDefination.Place_id==null)
		{
		
		m.add_Place_Payload_with("Pandey", "Africa", "Eurpoe");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Pandey", "getPlaceAPI");
		
		}
	}
	
}
