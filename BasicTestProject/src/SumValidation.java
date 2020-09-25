import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sum() {

		System.out.println("---------Verify if Sum of all Course prices matches with Purchase Amount------------");
		JsonPath js = new JsonPath(payload.coursePrice());
		int coursesCount = js.getInt("courses.size()");
		
		int sum = 0;

		for (int i = 0; i < coursesCount; i++) {
			
			int Price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			int Amt = Price * copies;
			sum = sum + Amt;		
		}
		
		System.out.println(sum);

	}

}
