package org.pojo;

import org.utilities.APIBaseClass;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter
@Setter
public class CreateNewUser extends APIBaseClass {
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int userStatus;


public static void createUser() {
	
	CreateNewStore createNewStore = new CreateNewStore();
	
 
}
}