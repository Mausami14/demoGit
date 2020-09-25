package serialize;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import pojo.Location;
import pojo.MainPojoClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class AddPlace {

	public static void main(String[] args) {
		
		MainPojoClass m=new MainPojoClass();
		m.setAccuracy(50);
		m.setAddress("29, side layout, cohen 09");
		m.setLanguage("French-IN");
		m.setPhone_number("(+91) 983 893 3937");
		m.setWebsite("http://google.com");
		m.setName("Frontline house");
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		m.setTypes(myList);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		m.setLocation(l);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response res=given().queryParam("key", "qaclick123").body(m)
		.when()
		.post("/maps/api/place/add/json").then().assertThat().statusCode(200)
		.extract().response();
		
		String Responsebody=res.asString();
		System.out.println(Responsebody);
		

	}

}
