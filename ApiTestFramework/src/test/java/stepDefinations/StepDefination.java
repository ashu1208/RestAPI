package stepDefinations;

import static io.restassured.RestAssured.given;


import Resources.APIResources;
import Resources.resource;
import Utils.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

import java.io.IOException;


public class StepDefination extends Util{
	
    RequestSpecification REQ;
	Response response;
	Response Respon;
	resource pay=new resource();
	 static String Place_id;
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException 
	{
		
	REQ=given().spec(RequestResponse()).body(pay.PayloadBody(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String ResourceCall, String Method)
	{
	    // Write code here that turns the phrase above into concrete actions
		
		APIResources resourceAPI=APIResources.valueOf(ResourceCall);
		
		if(Method.equalsIgnoreCase("POST")) 
		
		 response =REQ.when().post(resourceAPI.getResource());
		
		else if(Method.equalsIgnoreCase("GET"))
		{
			 response =	REQ.when().get(resourceAPI.getResource());
		}
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		// Respon=response.then().spec(ResponseSpec()).extract().response();
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		
	    assertEquals(getJsonPath(response, keyValue),ExpectedValue);
	  
	}
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedname, String resource) throws IOException {
		
			 Place_id=getJsonPath(response, "place_id");
		//String Place_id=Jsons.get("place_id");
		REQ=given().spec(RequestResponse()).queryParam("place_id", Place_id);
		
		user_calls_with_http_request(resource, "GET");
		
		String actualname=getJsonPath(response, "name");
		//String ActualName=Jsons.get("name");
		assertEquals(actualname, expectedname);
	}
	
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    
		REQ=given().spec(RequestResponse()).body(pay.deletePlacePayLoad(Place_id));
		
				
		
	}
}
