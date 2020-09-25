import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.ReusableCodes;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ClassOne {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		//Add place
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("/maps/api/place/add/json").then()
				.header("Server", "Apache/2.4.18 (Ubuntu)").body("scope", equalTo("APP")).log().all().assertThat()
				.statusCode(200).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		System.out.println("-----------Update place------------");
		String expAdd="70 Summer walk, USA";
		given().log().all().header("Content-Type", "application/json")
		.body("{\n" + 
				"\"place_id\":\""+placeid+"\",\n" + 
				"\"address\":\""+expAdd+"\",\n" + 
				"\"key\":\"qaclick123\"\n" + 
				"}").when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		System.out.println("-----------Get place------------");
		String getResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when()
		.get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1=ReusableCodes.rawToJson(getResponse);
		String actAdd=js1.getString("address");
		
		Assert.assertEquals(actAdd, expAdd);
		
		System.out.println(actAdd);
		

	}

}
