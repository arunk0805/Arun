package org.utilities;

import org.testng.annotations.Test;

public class AuthCode extends BaseClass {

	@Test
	public static String getAuthCode() {
		browserLaunch(
				"https://accounts.spotify.com/authorize?client_id=e7e499e672e9473982f90cd9466fd3ce&response_type=code&redirect_uri=https://oauth.pstmn.io/v1/browser-callback&scope=playlist-modify-public playlist-read-private playlist-modify-private");
		locatorById("login-username").sendKeys("revarun997@gmail.com");
		locatorById("login-password").sendKeys("@runK0805");
		locatorByXpath("//span[text()='Log In']").click();
		sleep(3000);
		String currentUrl = currentUrl();
		String[] url = currentUrl.split("=");
		String authCode = url[1];
		return authCode;

	}

}
