package model;

public class AccountBean {

	private String username = "";
	private String password = "";
	
	//-----------------Username-----------------//
	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String[] getUsernames() {

		return AccountHandler.getUsernames(username);
	}
	
	//------------------Password------------------
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getPasswords() {
		return AccountHandler.getPasswords(password);
	}

}
