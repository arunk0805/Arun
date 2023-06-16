/**
 *@author Arunkumar.K
 *@Date 19/04/2023 
 */
package org.test;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.constantpath.ConstantPath;
import org.pojo.AddNewPet;
import org.pojo.UpdatePetData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.APIBaseClass;
import org.utilities.EndPoint;
import org.utilities.ReadExcelData;
import org.utilities.StatusCode;

import com.fasterxml.jackson.databind.ObjectMapper;

import bsh.This;
import io.restassured.response.Response;

public class Pet extends APIBaseClass {
	static Logger logger = Logger.getLogger(Pet.class);
	AddNewPet newPet = new AddNewPet();

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see This method is used to get the data from excel sheet
	 */
	@Test(priority = 1)
	public void readExcelData() {
		HashMap<String, String> data = ReadExcelData.getUserData(ConstantPath.testDataPath, "petData", "TC01");
		createNewPet(data);

		HashMap<String, String> updateData = ReadExcelData.getUserData(ConstantPath.testDataPath, "petData", "TC02");
		updatePet(updateData);

	}

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see This method is used to create a new pet, get pet by id and delete pet by
	 *      id
	 * @param data
	 */

	public static void createNewPet(HashMap<String, String> data) {
		Response response = null;
		try {

			AddNewPet requestbody = AddNewPet.testData(Integer.parseInt(data.get("id")),
					Integer.parseInt(data.get("categoryId")), (data.get("categoryName")), data.get("petName"),
					data.get("photoUrl"), Integer.parseInt(data.get("tagsId")), (data.get("tagsName")),
					(data.get("status")));
			response = postMethod(requestbody, EndPoint.createNewPet);

			ObjectMapper mapper = new ObjectMapper();
			AddNewPet readValue;
			readValue = mapper.readValue(response.body().asString(), AddNewPet.class);
			int id = readValue.getId();
			logger.info(readValue.getId());
			/**
			 * Get pet by Id
			 */
			Response getMethod = getMethod(EndPoint.findPetByID + id);
			Assert.assertEquals(getMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(getMethod.getBody().asString().contains("Kutty"));
			logger.info(getMethod.getBody().asPrettyString());
			logger.info("Request body contains pet name as Kutty");
			logger.info("Successfully find the pet by ID");
			/**
			 * Delete pet by Id
			 */
			Response deleteMethod = deleteMethod(EndPoint.findStoreId + id);
			Assert.assertEquals(deleteMethod.getStatusCode(), StatusCode.OK.getCode());
			logger.info("Successfully deleted the pet by ID");

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * @author Arunkumar.K
	 * @Date 19/04.2023
	 * @see This method is used to update a pet details
	 * @param updateData
	 */
	public void updatePet(HashMap<String, String> updateData) {
		Response response = null;
		try {

			AddNewPet putRequestbody = AddNewPet.testData(Integer.parseInt(updateData.get("id")),
					Integer.parseInt(updateData.get("categoryId")), (updateData.get("categoryName")),
					updateData.get("petName"), updateData.get("photoUrl"), Integer.parseInt(updateData.get("tagsId")),
					(updateData.get("tagsName")), (updateData.get("status")));
			response = putMethod(putRequestbody, EndPoint.updatePet);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			logger.info("Successfully Upadte Pet Data");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(" Pet Data is not Updated");
		}

	}

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see This method is used to get the Pet by Id
	 */

	@Test(priority = 2)
	public void getPet() {
		try {
			Response response = getMethod(EndPoint.findPetByID + getPropertyValue("id"));
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			logger.info("Successfully get the Pet Data");
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error("Pet Data is not received");
		}

	}

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see This method is used to delete the pet by id
	 */

	@Test(priority = 4)
	public void deletePet() {
		try {
			Response response = deleteMethod(EndPoint.deletePet + getPropertyValue("id"));
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertEquals(response.body().asString(), "Pet deleted");
			logger.info("Status Code Matched");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error("Status code Not Matched");
		}

	}

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see This method is used to update the pet
	 */
	@Test(priority = 3)
	public void putRequest() {
		try {
			String putTestData = UpdatePetData.putTestData();
			Response response = putMethod(putTestData, EndPoint.updatePet);
			Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
			logger.info("Status Code Matched");

		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error("Status code Not Matched");
		}

	}

	@Test
	public void getPetByStatus() {
try {

	Response response = getMethod(EndPoint.findPetByStatus, getPropertyValue("key"), getPropertyValue("value"));
	Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getCode());
	logger.info(response.getBody().asPrettyString());
	logger.info("Successfully get the Pet Data by status");
	
} catch (Exception exception) {
	exception.printStackTrace();
	logger.error("Status code Not Matched");

}
	}

}
