package StepDefinitionCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

public class Products {

	RequestSpecification httpRequest;
	Response response;

	@Given("The url of get item info api endpoint to Fetch all the Items For which the selling Price needs to be Changed.")
	public void the_url_of_get_item_info_api_endpoint_to_fetch_all_the_items_for_which_the_selling_price_needs_to_be_changed() {

		httpRequest = RestAssured.given();
	}

	@When("I hit the url of an Item Info API to Fetch all the Items")
	public void i_hit_the_url_of_an_Item_Info_API_to_Fetch_all_the_Items() throws Throwable {
		httpRequest = httpRequest.queryParam("spType", 27).queryParam("itemName", 20).queryParam("outlet", "")
				.queryParam("area", "").queryParam("isItemCodeSearch", 27);
		response = httpRequest.when().cookie("JSESSIONID", "6F0467E47AAE37937DEE088F3A4BC18D.jvm1;")
				.get("http://10.63.39.201:8181/RayMedi_HQ/rest/trans/priceupdate/get/item-info");

	}

	@Then("I should Receive all the Items as a Result of the Response")
	public void i_should_Receive_all_the_Items_as_a_Result_of_the_Response() throws Throwable {

		System.out.println(response.asPrettyString());

	}

	@Then("I receive the response code as {int} and the Response Message as Success")
	public void i_receive_the_response_code_as_and_the_Response_Message_as_Success(int arg1) throws Throwable {

		int statusCode = response.statusCode();
		JsonPath path = response.jsonPath();
		String pathmsg = path.get("status");
		System.out.println(pathmsg);
		assertEquals(200, statusCode);
		assertEquals("success", pathmsg);

		System.out.println(statusCode);

		if (statusCode == 200 && statusCode != 400) {
			System.out.println("The Given EndPoint is Valid and the Response Message is " + pathmsg);
		} else {
			System.out.println("The Given EndPoint is inValid and Bad Request");
		}
	}
}
