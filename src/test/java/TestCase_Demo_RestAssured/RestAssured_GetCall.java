package TestCase_Demo_RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured_GetCall {

	@Test
	public void Test_Reqres_GetCall() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		int statuscode = response.getStatusCode();
		System.out.println("Status code: " + statuscode);
		
		String body = response.getBody().asString();
		System.out.println("Body is: "+body);
		
		long time = response.getTime();
		System.out.println("Time is: "+time);
	
	}

}
