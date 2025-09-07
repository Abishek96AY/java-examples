package com.examples.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExWithMap {
	public static void main(String[] args) {
		
		Map<String, List<Employee>> employeesByDepartmentMap = Employee.employees.stream().collect(Collectors.groupingBy(Employee::getDeptName));
		
		employeesByDepartmentMap.forEach((a, b) -> {
			b.forEach(c -> {
				System.out.println(a + ", " + c.getName());
			});
		});
	}
}