package org.utilities;

import java.util.HashMap;

import org.testng.annotations.Test;

/**
 * 
 * @author Arunkumar.K
 * @Date 19/04/2023
 * @see Here merging the base url with endpoints
 *
 */

public class EndPoint extends APIBaseClass {

//	private static String baseURL = getPropertyValue("baseUrl");
//
//	public final static String findPetByID = baseURL + "api/v3/pet/";
//	public static final String findPetByStatus=baseURL+"api/v3/pet/findByStatus";
//	public static final String deletePet = baseURL + "api/v3/pet/";
//	public static final String createNewPet = baseURL + "api/v3/pet";
//	public static final String updatePet = baseURL + "api/v3/pet";
//	public static final String createNewStore = baseURL + "api/v3/store/order";
//	public static final String findStoreId = baseURL + "api/v3/store/order/";
//	public static final String deleteStoreId = baseURL + "api/v3/store/order/";
//	public static final String createNewUser = baseURL + "api/v3/user";
//	public static final String getUserByUserName = baseURL + "api/v3/user/";
	
	@Test
	public void getData() {

		HashMap<String,String> userData = ReadExcelData.getUserData("D:\\Eclipse\\APIAutomation\\TestData\\ApiTestData.xlsx", "Activity", "TC01");
		System.out.println(userData);
	}

}
