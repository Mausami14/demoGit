import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class DynamicJSON {
	
	@Test
	public void addLib()
	{
		String response=RestAssured.baseURI="http://216.10.245.166/";
		given().header("Content-Type","application/json").body(payload.addLib("dfgsd","555"))
		.when().post("Library/Addbook.php").then()
		.assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
	}

}
