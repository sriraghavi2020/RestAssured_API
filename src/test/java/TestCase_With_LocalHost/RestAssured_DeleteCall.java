package TestCase_With_LocalHost;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class RestAssured_DeleteCall {
@Test
public void Test_DeleteCall() {
	
	baseURI = "http://localhost:3000";
	//given().delete("/data/LTQZBBW").then().statusCode(200).log().all();
	given().delete("/data/56yWgGt").then().statusCode(200).log().all();
}

}
