package org.baseclass;

import org.testng.annotations.Test;

public class AuthCode extends BaseClass {

	@Test
	public void getAuthCode() {
		browserLaunch(
				"https://accounts.spotify.com/authorize?client_id=e7e499e672e9473982f90cd9466fd3ce&response_type=code&redirect_uri=https://oauth.pstmn.io/v1/browser-callback&scope=playlist-modify-public playlist-read-private playlist-modify-private");
		implicitWait(10);
		locatorById("login-username").sendKeys("revarun997@gmail.com");
		locatorById("login-password").sendKeys("@runK0805");
		locatorByXpath("//span[text()='Log In']").click();
		try {
			sleep(3000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
				String currentUrl = currentUrl();
		System.out.println(currentUrl);
		String[] str = currentUrl.split("=");
		String authCode = str[1];
		System.out.println(authCode);
		
	}

}
