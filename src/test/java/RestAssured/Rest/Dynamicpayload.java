package RestAssured.Rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Dynamicpayload {
  @Test(dataProvider = "booksdata")
  public void addBook(String S1 , String s2) {
	  RestAssured.baseURI="http://216.10.245.166/";
	  String responce =given().log().all().body(Payload.addBook(S1,s2)).when().post("Library/Addbook.php")
	  .then().assertThat().statusCode(200).extract().response().asString();
	  JsonPath js = new JsonPath(responce);
		String id=js.getString("ID");
		System.out.println(id);
	  
  }
  
  @DataProvider(name ="booksdata")
  public Object data()
  {
	 return new Object[][] {{"ax","52"},{"az","56"}};
  }
}
