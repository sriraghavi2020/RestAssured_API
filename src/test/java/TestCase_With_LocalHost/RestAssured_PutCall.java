package TestCase_With_LocalHost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RestAssured_PutCall {

	
	@SuppressWarnings("unchecked")
	@Test
	public void Test_PutCall() {
		JSONObject payLoad = new JSONObject();
		
		
		payLoad.put("name", "John");
		payLoad.put("company", "BD");
		payLoad.put("profileID", "1");
		
		
		
		baseURI = "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
				body(payLoad.toJSONString()).
				put("/data/56yWgGt").
		then().
			statusCode(200).
		log().all();
	}
}
