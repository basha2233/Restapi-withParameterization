package RestAssured.Rest;

public class Payload 
{
	
	public static String addBook(String a, String b)
	{
		String payload ="{\r\n"
		+ "\r\n"
		+ "\"name\":\"Learn Appium Automation with Java1\",\r\n"
		+ "\"isbn\":\""+a+"\",\r\n"
		+ "\"aisle\":\""+b+"\",\r\n"
		+ "\"author\":\"John foe\"\r\n"
		+ "}\r\n"
		+ "";
		
		return payload;
	}

}
