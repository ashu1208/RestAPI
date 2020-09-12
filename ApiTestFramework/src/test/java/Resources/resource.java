package Resources;

import java.util.ArrayList;
import java.util.List;

import SerialPojo.Location;
import SerialPojo.Serialization;

public class resource {
	
	public  Serialization PayloadBody(String name,String language,String address) {
	
	Serialization Ser=new Serialization();
	Ser.setAccuracy(50);
	Ser.setAddress(address);
	Ser.setLanguage(language);
	Ser.setName(name);
	Ser.setPhone_number("(+91)9724166406");
	Ser.setWebsite("https://Google.com");
	
	List<String>MyList =new ArrayList<String>();
	MyList.add("shoe park");
	MyList.add("shop");
	Ser.setTypes(MyList);
	
	Location Loc=new Location();
	Loc.setLat(20.123);
	Loc.setLng(30.235);
	Ser.setLocation(Loc);
	
	return Ser;
	}
	
	
	public String deletePlacePayLoad(String placeId) {
		
		return "{\r\n       \"place_id\":\""+placeId+"\"\r\n}";
		
	}
}
