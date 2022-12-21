package model;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;

	private String tempStr;

	private String unit;

	private String lastDate;

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

	// Cloud-----------------------------------------------
	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}

	// Temp-------------------------------------------------
	public String getTempStr() {
		return tempStr;
	}

	public void setTempStr(String TempStr) {
		this.tempStr = TempStr;
	}

//-----------------------Unit------------------------------
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

//_______________________Date______________________________________
	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

}