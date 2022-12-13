package model;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	private String tempStr;

	public weatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;
	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}
	//Cloud-----------------------------------------------
	public String getCloudsStr() {
		return cloudsStr;
	}

		public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
	//Temp-------------------------------------------------
	public String getTempStr() {
			return tempStr;
		}
		
	public void setTempStr(String TempStr) {
			this.tempStr = TempStr;
		}
		
		
		
		
		
		
		
		
		
		
		

}