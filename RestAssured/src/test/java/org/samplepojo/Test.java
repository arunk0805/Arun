package org.samplepojo;

import org.utilities.BaseClass;

public class Test extends BaseClass {
	
@org.testng.annotations.Test
	
	public void createData() {
	
	Pojo[] createData = Build.createData();
	String stringConverter = jsonStringConverter(createData);
	System.out.println(stringConverter);
	
		

	}

}
