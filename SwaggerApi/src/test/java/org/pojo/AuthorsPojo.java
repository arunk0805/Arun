package org.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthorsPojo {
	 private int id;
	 private int idBook;
	 private String firstName;
	 private String lastName;

}
