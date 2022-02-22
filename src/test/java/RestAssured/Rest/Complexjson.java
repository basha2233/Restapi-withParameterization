package RestAssured.Rest;

import io.restassured.path.json.JsonPath;

public class Complexjson 
{
	
	public static void main(String args[])
	{
		String responce="{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		
		JsonPath jp = new JsonPath(responce);
		int count = jp.get("courses.size()");
		System.out.println(count);		
		int purchase =jp.getInt("dashboard.purchaseAmount");
		System.out.println("purcharse" + purchase);		
		String title =jp.get("courses[0].title");
		System.out.println(title);
		
		int sum=0;
		
		  for(int i=0; i<count ; i++) 
		  { 
		  String title1 =jp.get("courses["+i+"].title");
		  int price =jp.getInt("courses["+i+"].price"); 
		  int copies =jp.getInt("courses["+i+"].copies");
		  sum = sum + (price * copies);
		  System.out.println(title1 + "," + price);
		  
		  }
		  System.out.println(sum);
		 
		
		  for(int i=0; i<count ; i++) { String title1 =jp.get("courses["+i+"].title");
		  if(title1.equals("RPA")) { int copies =jp.getInt("courses["+i+"].copies");
		  System.out.println(title1 + "," + copies); 
		  break;}
		  
		  }
		 
		
		
		
	}

}
