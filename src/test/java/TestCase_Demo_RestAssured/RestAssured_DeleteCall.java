package TestCase_Demo_RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class RestAssured_DeleteCall {
	
	@Test
	public void Test_deleteCall() {
		
		given().delete("https://reqres.in/api/users/2").then().statusCode(204);
		
	}

}
