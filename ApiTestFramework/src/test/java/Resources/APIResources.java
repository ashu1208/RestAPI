package Resources;

public enum APIResources {
	
     AddPlaceAPI("/maps/api/place/add/json"),
     getPlaceAPI("/maps/api/place/get/json"),
     deletePlaceAPI("/maps/api/place/delete/json");
	
		private String ResourceCall;
	
	
	APIResources(String ResourceCall)
	{
		this.ResourceCall=ResourceCall;
	}
	
	public String getResource() 
	{
		return ResourceCall;
		
	}

}
