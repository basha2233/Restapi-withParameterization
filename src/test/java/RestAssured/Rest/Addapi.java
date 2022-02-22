package RestAssured.Rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

public class Addapi {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// Add API
		String responce =given().log().all().queryParam("key", "qaclick123").body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "	").when().post("/maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).extract().response().asString();
		//equal to method coming from Hamcrest package
		// asserting status code , body level scope , header level in responce
		System.out.println(responce);
		JsonPath js = new JsonPath(responce);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		
		// Update API
		
		given().log().all().queryParam("key", "qaclick123").body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("/maps/api/place/update/json").then().assertThat().log().all().
		statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GetAPI
		
		String placeresponce =given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).when()
		.get("/maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response()
		.asString();
		
		JsonPath jp = new JsonPath(placeresponce);
		String address = jp.getString("address");
		System.out.println(address);
		Assert.assertEquals(address,"70 Summer walk, USA");
		

	}
//.header("Content-type", "application/json")
}
