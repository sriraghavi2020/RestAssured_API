package TestCase_With_LocalHost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RestAssured_PostCall {

	
	@SuppressWarnings("unchecked")
	@Test
	public void Test_PosstCall() {
		JSONObject payLoad = new JSONObject();
		
		payLoad.put("name", "John");
		payLoad.put("company", "BD");
		payLoad.put("profileID", "1");
		payLoad.put("id", "4");
		
		baseURI = "http://localhost:3000"; 
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(payLoad.toJSONString()).post("/data").then().statusCode(201).log().all();
	}
}
