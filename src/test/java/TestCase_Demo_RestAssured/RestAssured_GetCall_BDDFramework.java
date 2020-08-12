package TestCase_Demo_RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssured_GetCall_BDDFramework {

	
	@Test
	public void Test_GetCall_withBDD() {
				
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat().
		body("data.id[0]", equalTo(7)).
		body("data.first_name[0]", equalTo("Michael")).
		log().all();
		
	}
}
