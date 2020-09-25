import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonResp {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(payload.coursePrice());

		// Print No of courses returned by API
		System.out.println("---------Print No of courses returned by API------------");
		int coursesCount = js.getInt("courses.size()");
		System.out.println(coursesCount);

		System.out.println("---------Print Purchase Amount------------");

		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmt);

		System.out.println("---------Print Title of the first course------------");
		String titleOfFirstCourse = js.get("courses[0].title");
		System.out.println(titleOfFirstCourse);

		System.out.println("---------Print All course titles and their respective Prices------------");

		for (int i = 0; i < coursesCount; i++) {
			String CourseTitle = js.getString("courses[" + i + "].title");
			System.out.println(CourseTitle);

			System.out.println(js.getInt("courses[" + i + "].price"));
		}

		System.out.println("---------Print no of copies sold by RPA Course------------");

		for (int i = 0; i < coursesCount; i++) {
			String CourseTitle = js.getString("courses[" + i + "].title");

			if (CourseTitle.equalsIgnoreCase("RPA")) {

				System.out.println(js.getString("courses[" + i + "].copies"));
				break;
			}
			
			/*
			 * System.out.
			 * println("---------Verify if Sum of all Course prices matches with Purchase Amount------------"
			 * ); int sum = 0;
			 * 
			 * for (int j = 0; j < coursesCount; j++) {
			 * 
			 * int Price = js.get("courses[" +j+ "].price"); int copies = js.get("courses["
			 * +j+ "].copies"); int Amt = Price * copies; sum = sum + Amt;
			 * 
			 * 
			 * } //System.out.println(sum);
			 */			

		}
	}

}
