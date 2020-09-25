import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;



public class Auth2 {

	public static void main(String[] args)throws InterruptedException {
		
		
		String accessCode=given().queryParam("code", "4%2F4AH2_X3FTC4V4rmd9d_yb2dDjiDvO9p13buqI9w8-xs8RXfl9eySarMZ5YSCdlG4ZGxG1lBhkWp4_R_7zswAY08").queryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
	     .urlEncodingEnabled(false).queryParam("auth_url", "https://accounts.google.com/o/oauth2/v2/auth")
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("response_type", "code")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.when().log().all().get("https://accounts.google.com/o/oauth2/v2/auth").asString();
		
		System.out.println(accessCode);
		JsonPath jp = new JsonPath(accessCode);
		String access_token = jp.getString("access_token");
		
		
		String response=given().queryParam("access_token", access_token)
		.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
		
	}

}
