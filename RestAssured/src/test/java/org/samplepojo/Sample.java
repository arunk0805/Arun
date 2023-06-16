package org.samplepojo;

import java.util.Arrays;
import java.util.List;

import org.utilities.BaseClass;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Sample extends BaseClass {
	private String companyName;
	private String location;
	private List<Employee> employees;
	private List<Contractor> contractor;

	// @Test
	// public static Object addDetails() {
	// Sample sample = new Sample();

//		sample.setCompnayName("ATMECS");
//		sample.setLocation("Coimbatore");
//		employee.setEmpName("Arun");
//		employee.setId(7);
//		employee.setEmpName("Loki");
//		employee.setId(8);
//		contracter.setContractorName("Finvi");
//		contracter.setContractorId(100);
//		sample.setEmployee(Arrays.asList(employee));
//		sample.setContracter(Arrays.asList(contracter));
//			ObjectMapper mapper = new ObjectMapper();
//		String reqBody = null;
//		try {
//			reqBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sample);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return reqBody;

	public static Object setDetails() {
		
		int[] contractorId = { 1, 2 };
		String [] contractorName = {"Finvi","JetBlue"};
		

		String[] employeeName = { "loki", "arun" };
		int[] employeeId = { 1, 2 };

		//Contractor contractor = Contractor.builder().contractorId(0).contractorName("arun").build();

		Employee[] employee = new Employee[employeeName.length];
		Contractor[] contractor = new Contractor[contractorName.length];

		for (int objectNumber = 0; objectNumber < employeeName.length; objectNumber++) {

			employee[objectNumber] = new Employee();

			employee[objectNumber].setEmpName(employeeName[objectNumber]);
			employee[objectNumber].setEmpId(employeeId[objectNumber]);

		}
		for (int objectNumber = 0; objectNumber < employeeName.length; objectNumber++) {

			contractor[objectNumber] = new Contractor();

			contractor[objectNumber].setContractorId(contractorId[objectNumber]);
			contractor[objectNumber].setContractorName(contractorName[objectNumber]);

		}

		Sample sample = Sample.builder().companyName("Atmecs").location("cbe").employees(Arrays.asList(employee))
				.contractor(Arrays.asList(contractor)).build();
		String jsonStringConverter = jsonStringConverter(sample);
		return jsonStringConverter;

	}

}
