package files;

import io.restassured.path.json.JsonPath;

public class ReusableCodes {
	
	public static JsonPath rawToJson(String resp)
	{
		JsonPath js1= new JsonPath(resp);
		return js1;
	}

}
