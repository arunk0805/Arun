/**
 * @author Arunkumar.K
 * @Date 19/04/2023
 * 
 */
package org.test;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.constantpath.ConstantPath;
import org.pojo.CreateNewStore;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.APIBaseClass;
import org.utilities.EndPoint;
import org.utilities.ReadExcelData;
import org.utilities.StatusCode;

import com.fasterxml.jackson.databind.ObjectMapper;

import bsh.This;
import io.restassured.response.Response;

public class Store extends APIBaseClass {
	Logger logger = Logger.getLogger(Store.class);
	CreateNewStore createNewStore = new CreateNewStore();

	/**
	 * @author Arunkumar.K
	 * @see This method is used Create new store and get story by id and delete
	 *      store by id
	 * @param data
	 */

	public void addNewPetStore(HashMap<String, String> data) {
		Response response = null;
		/**
		 * Create New Store
		 */
		try {
			CreateNewStore requestbody = createNewStore.newStoreData(Integer.parseInt(data.get("id")),
					Integer.parseInt(data.get("petId")), Integer.parseInt(data.get("quantity")), data.get("shipDate"),
					data.get("status"), Boolean.parseBoolean(data.get("complete")));
			response = postMethod(requestbody, EndPoint.createNewStore);
			ObjectMapper mapper = new ObjectMapper();
			CreateNewStore readValue;

			readValue = mapper.readValue(response.getBody().asString(), CreateNewStore.class);
			int id = readValue.getId();
			logger.info(readValue.getId());
			/**
			 * Get the store by Id
			 */
			Response getMethod = getMethod(EndPoint.findStoreId + id);
			Assert.assertEquals(getMethod.getStatusCode(), StatusCode.OK.getCode());
			Assert.assertTrue(getMethod.getBody().asString().contains("10"));
			logger.info(getMethod.getBody().asPrettyString());
			logger.info("Request body contains Id = 10");
			logger.info("Successfully find the purchase order by ID");
			/**
			 * Delete the store by Id
			 */
			Response deleteMethod = deleteMethod(EndPoint.findStoreId + id);
			Assert.assertEquals(deleteMethod.getStatusCode(), StatusCode.OK.getCode());
			logger.info("Successfully deleted the purchase order by ID");
			

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @author Arunkumar.K
	 * @see This method is used to real the value from excel sheet
	 */
	@Test
	public void readExcelData() {
		HashMap<String, String> data = ReadExcelData.getUserData(ConstantPath.testDataPath, "storeData", "TC01");
		addNewPetStore(data);
	}

}
