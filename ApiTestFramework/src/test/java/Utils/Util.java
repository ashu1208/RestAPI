package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util {
	
   public static RequestSpecification requ;
   ResponseSpecification respec;
	
	public RequestSpecification RequestResponse() throws IOException
	{
		
		if(requ==null){
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 requ=new RequestSpecBuilder().
		setBaseUri(GetGlobalValue("BaseUrl")).addQueryParam("key","qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		return requ;
		}
		return requ;
	}
	
	
	/*
	 * public ResponseSpecification ResponseSpec() {
	 * 
	 * respec =new
	 * ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.
	 * JSON).build(); return respec;
	 * 
	 * }
	 */
	 

	public static String GetGlobalValue(String Key) throws IOException
	{	
	Properties prop= new Properties();
	FileInputStream File =new FileInputStream("C:\\Ashutosh Pandey\\Rest Assured API\\ApiTestFramework\\src\\test\\java\\Utils\\Url.properties");
	prop.load(File);
	return prop.getProperty(Key);
	
	}
	
	
	  public String getJsonPath(Response response,String keys) {
	  
	  String resp = response.asString();
	  JsonPath Jsons=new JsonPath(resp); 
	  return Jsons.get(keys).toString();
	  }
}
