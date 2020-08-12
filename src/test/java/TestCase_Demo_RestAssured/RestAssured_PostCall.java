package TestCase_Demo_RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestAssured_PostCall {
	//
	@SuppressWarnings("unchecked")
	//
	@Test
	public void Test_PostCall() {

		JSONObject payLoad = new JSONObject();
		payLoad.put("name", "tom");
		payLoad.put("job", "leader");
		System.out.println(payLoad);

		given().
			body(payLoad.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);

	}
}
