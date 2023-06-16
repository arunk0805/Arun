package org.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder

public class UserPojo {

	private int id;
	private String userName;
	private String password;
}
