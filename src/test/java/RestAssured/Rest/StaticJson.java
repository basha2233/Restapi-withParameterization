package RestAssured.Rest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson 
{
	
	public static void main (String args[]) throws IOException{
		  RestAssured.baseURI="http://216.10.245.166/";
		  String responce =given().log().all().body(new String(Files
				  .readAllBytes(Paths.get("N://Testing//Selenium//Selenium-Works//Rest//src//test//assjson.json"))))
				  .when().post("Library/Addbook.php")
		  .then().assertThat().statusCode(200).extract().response().asString();
		  JsonPath js = new JsonPath(responce);
			String id=js.getString("ID");
			System.out.println(id);
		  
	  }

}
