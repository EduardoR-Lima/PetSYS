package petsys.utils;

import java.util.prefs.Preferences;

import petsys.database.DbCredentials;

public class PreferencesManager {
	private static Preferences prefs = Preferences.userNodeForPackage(PreferencesManager.class);
	
	public static DbCredentials getDatabaseCredentials() {
		String dbUrl = prefs.get("db_h", null);
		String user = prefs.get("db_u", null);
		String password = prefs.get("db_p", null);
		return new DbCredentials(dbUrl, user, password);
	}
	
	public static void setDatabaseCredentials(DbCredentials credentials) {
		prefs.put("db_h", credentials.url());
		prefs.put("db_u", credentials.user());
		prefs.put("db_p", credentials.password());
	}
}
