package org.utilities;

public class EndPoint extends BaseClass {
	static String UserId = "315qvlybohbmljijxczhd2vtenle";
	static String PlaylistId = "3Ia0VhvHx15CCvSm8ytRNf";

	// authentication methods

	public final static String basicAuthUrl = "https://postman-echo.com/basic-auth";
	public static final String digestAuthUrl = "https://postman-echo.com/digest-auth";
	public static final String preemptiveUrl = "https://postman-echo.com/basic-auth";
	public static final String callBackUrl = "https://oauth.pstmn.io/v1/browser-callback";
	public static final String accesstokeUrl = "https://accounts.spotify.com/api/token";
	public static final String gitHubBearerToken = "https://github.com/arunk0805?tab=repositories";
	public static final String weatherApiKey = "https://api.openweathermap.org/data/2.5/weather";

	// OAuth2.0 Spotify
	private static String spotifyBaseURL = getPropertyValue("spotifyBaseUrl");

	public static final String getPlaylist = spotifyBaseURL + "v1/users/" + UserId + "/playlists";
	public static final String updatePlaylist = spotifyBaseURL + "v1/playlists/" + PlaylistId;
	public static final String createPlayList = spotifyBaseURL + "v1/users/" + UserId + "/playlists";

	// post options

	public static final String multiValue = "https://api.openweathermap.org/data/2.5/weather";
	public static final String pathParam = "https://petstore3.swagger.io/api/v3/pet/{petId}";
	public static final String multiPart = "https://the-internet.herokuapp.com/upload";
	public static final String cookies = "https://api.apilayer.com/fixer/latest";
	public static final String csrfToken = "https://jumbo.zomato.com/event";

	// Activities Swagger swaggerBaseUrl
	private static String swaggerBaseUrl = getPropertyValue("swaggerBaseUrl");

	public static final String createActivities = swaggerBaseUrl + "api/v1/Activities";
	public static final String getActivities = swaggerBaseUrl + "api/v1/Activities/{id}";
	public static final String updateActivities = swaggerBaseUrl + "api/v1/Activities/{id}";
	public static final String deleteActivities = swaggerBaseUrl + "api/v1/Activities/{id}";

	// Books Swagger
	public static final String createBooks = swaggerBaseUrl + "api/v1/Books";
	public static final String getBooks = swaggerBaseUrl + "api/v1/Books/{id}";
	public static final String updateBooks = swaggerBaseUrl + "api/v1/Books/{id}";
	public static final String deleteBooks = swaggerBaseUrl + "api/v1/Books/{id}";

	// Users Swagger
	public static final String createUser = swaggerBaseUrl + "api/v1/Users";
	public static final String getUser = swaggerBaseUrl + "api/v1/Users/{id}";
	public static final String updateUser = swaggerBaseUrl + "api/v1/Users/{id}";
	public static final String deleteUser = swaggerBaseUrl + "api/v1/Users/{id}";
}
