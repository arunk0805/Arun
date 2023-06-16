package org.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddNewPet {
	private int id;
	private String name;
	private Category category;
	private List<String> photoUrls;
	private ArrayList<Tag> tags;
	private String status;

	/**
	 * @author Arunkumar.K
	 * @Date 19/04/2023
	 * @see create a Pojo class and set the date for request body
	 * @param id
	 * @param categoryID
	 * @param categoryName
	 * @param petName
	 * @param photoUrl
	 * @param tagId
	 * @param tagName
	 * @param status
	 * @return newPetReqBody
	 */

	public static AddNewPet testData(int id, int categoryID, String categoryName, String petName, String photoUrl,
			int tagId, String tagName, String status) {
		AddNewPet newPet = new AddNewPet();
		Category category = new Category();
		Tag tag = new Tag();
		ArrayList<Tag> list = new ArrayList<Tag>();
		list.add(tag);

		newPet.setId(id);
		category.setId(categoryID);
		category.setName(categoryName);
		newPet.setName(petName);
		newPet.setCategory(category);
		newPet.setPhotoUrls(Arrays.asList(photoUrl));
		tag.setId(tagId);
		tag.setName(tagName);
		newPet.setStatus(status);
		newPet.setTags(list);

//		ObjectMapper mapper = new ObjectMapper();
//		String reqBody = null;
//		try {
//			reqBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newPet);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		return newPet;
	}

}