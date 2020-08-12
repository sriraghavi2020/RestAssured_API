package TestCase_Demo_RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class RestAssured_PutCall {

	//
	@SuppressWarnings("unchecked")
	//
	@Test
	public void Test_PutCall() {
		JSONObject payLoad = new JSONObject();
		payLoad.put("name", "tom");
		payLoad.put("job", "leader");
		System.out.println(payLoad);
		
		given().
			body(payLoad.toJSONString()).
				put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
		log().all();
	}
}
