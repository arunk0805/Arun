package org.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CreateNewStore {

	private int id;
	private int petId;
	private int quantity;
	private String shipDate;
	private String status;
	private boolean complete;

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see create a Pojo class and set the date for request body
	 * @param id
	 * @param petID
	 * @param quantity
	 * @param shipDate
	 * @param status
	 * @param complete
	 * @return newStorReqBody
	 */
	public CreateNewStore newStoreData(int id, int petID, int quantity, String shipDate, String status,
			boolean complete) {
		CreateNewStore newStore = new CreateNewStore();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		newStore.setId(id);
		newStore.setPetId(petID);
		newStore.setQuantity(quantity);
		newStore.setShipDate(shipDate);
		newStore.setStatus(status);
		newStore.setComplete(complete);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String newStoreReqBody = null;
//		try {
//			newStoreReqBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newStore);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		return newStore;
	}

}
