package org.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdatePetData {

	private int id;
	private String name;
	private PutCategory category;
	private List<String> photoUrls;
	private ArrayList<PutTag> tags;
	private String status;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PutCategory getCategory() {
		return category;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public ArrayList<PutTag> getTags() {
		return tags;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(PutCategory category) {
		this.category = category;
	}

	public void setPhotoUrls(List<String> list) {
		this.photoUrls = list;
	}

	public void setTags(ArrayList<PutTag> tags) {
		this.tags = tags;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static String putTestData() {
		UpdatePetData updatePet = new UpdatePetData();
		PutCategory category = new PutCategory();
		PutTag tag = new PutTag();
		ArrayList<PutTag> list = new ArrayList<PutTag>();
		list.add(tag);

		updatePet.setId(7);
		updatePet.setName("Tom");
		category.setId(101);
		category.setName("Lab");
		updatePet.setCategory(category);
		updatePet.setPhotoUrls(Arrays.asList("String", "Arun"));
		updatePet.setStatus("available");
		tag.setId(1);
		tag.setName("Dhoni");
		updatePet.setTags(list);

		ObjectMapper mapper = new ObjectMapper();
		String putReqBody = null;
		try {
			putReqBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(updatePet);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return putReqBody;
	}

}
