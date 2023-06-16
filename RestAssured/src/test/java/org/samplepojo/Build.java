package org.samplepojo;

public class Build {

	public static Pojo[] createData() {
		int[] id = { 7, 18, 1 };
		String[] firstName = { "MS", "Virat", "Arun" };
		String[] lastName = { "Dhoni", "Kohli", "Kumar" };
		String[] email = { "dhoni@7.com", "kohli@18.com", "kumar@1.com" };
		String[] gender = { "Male", "Male", "Male" };
		String[] ipAddress = { "123456", "1234567", "12345678" };

		Pojo[] value = new Pojo[firstName.length];

		for (int iterator = 0; iterator < firstName.length; iterator++) {
			value[iterator] = new Pojo();
			
			value[iterator].setId(id[iterator]);
			value[iterator].setFirst_name(firstName[iterator]);
			value[iterator].setLast_name(lastName[iterator]);
			value[iterator].setEmail(email[iterator]);
			value[iterator].setIp_address(ipAddress[iterator]);

		}
		return value;
	}

}