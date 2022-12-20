package model;

public class AccountHandler {

	private static String[] username = { "Bullshit", "Swervlet" };
	private static String[] password = { "superSafePassword", "unSafePassword" };

	public static String[] getUsernames(String inputUsername) {
		return username;
	}

	public static String[] getPasswords(String inputPassword) {
		return password;
	}

}
