package com.examples.stream;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeListExample {

	private int id;
	private String name;
	private int age;
	private long salary;
	private String gender;
	private String deptName;
	private String city;
	private int yearOfJoining;

	public EmployeeListExample(int id, String name, int age, long salary, String gender, String deptName, String city, int yearOfJoining) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.deptName = deptName;
		this.city = city;
		this.yearOfJoining = yearOfJoining;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public int getExperience() {
		return Calendar.getInstance().get(Calendar.YEAR) - yearOfJoining;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				", gender='" + gender + '\'' +
				", deptName='" + deptName + '\'' +
				", city='" + city + '\'' +
				", yearOfJoining=" + yearOfJoining +
				'}';
	}

	public static List<EmployeeListExample> employees = Arrays.asList(
			new EmployeeListExample(1, "Rahul", 24, 120000, "M", "Engineering", "Bangalore", 2000),
			new EmployeeListExample(2, "Vishal", 34, 110000, "M", "Engineering", "Mumbai", 1998),
			new EmployeeListExample(3, "Lakshmi", 28, 140000, "F", "HR", "Bangalore", 1992),
			new EmployeeListExample(4, "Priya", 24, 90000, "F", "Marketing", "Delhi", 2005),
			new EmployeeListExample(5, "Aditi", 30, 130000, "F", "HR", "Mumbai", 1995),
			new EmployeeListExample(6, "Jenni", 30, 100000, "F", "Engineering", "Mumbai", 1995)
			);

	public static void main(String[] args) {

		/*** 1. MATCHING OPERATIONS ***/
		boolean isNetworkTeamPresent = employees.stream()
				.anyMatch(e -> e.getDeptName().equals("Network"));

		boolean allAboveAge = employees.stream()
				.allMatch(e -> e.getAge() > 18);

		boolean noneInHR = employees.stream()
				.noneMatch(e -> e.getDeptName().equals("HR"));

		/*** 2. AGGREGATION / STATS ***/
		double averageSalary = employees.stream()
				.mapToDouble(EmployeeListExample::getSalary)
				.average()
				.orElse(0.0);

		long totalSalary = employees.stream()
				.mapToLong(EmployeeListExample::getSalary)
				.sum();

		long totalSalaryReduce = employees.stream()
				.map(EmployeeListExample::getSalary)
				.reduce(0L, Long::sum);

		long minSalary = employees.stream()
				.mapToLong(EmployeeListExample::getSalary)
				.min()
				.orElse(0L);

		long maxSalary = employees.stream()
				.mapToLong(EmployeeListExample::getSalary)
				.max()
				.orElse(0L);
		
		EmployeeListExample maxEmployeeBySalary = EmployeeListExample.employees.stream()
				.max(Comparator.comparing(EmployeeListExample::getSalary)).orElse(null);

		DoubleSummaryStatistics salaryStats = employees.stream()
				.collect(Collectors.summarizingDouble(EmployeeListExample::getSalary));

		/*** 3. GROUPING / PARTITIONING ***/
		Map<String, Double> avgSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(EmployeeListExample::getDeptName, Collectors.averagingDouble(EmployeeListExample::getSalary)));
		
		Map<String, List<EmployeeListExample>> employeesByAgeGroupCustom = employees.stream()
			    .collect(Collectors.groupingBy(e -> {
			        if (e.getAge() <= 25) return "Young";
			        else if (e.getAge() <= 40) return "Mid-age";
			        else return "Senior";
			    }));
		
		Map<String, Map<String, Double>> avgSalaryByGenderAndDept = EmployeeListExample.employees.stream().
				collect(Collectors.groupingBy(EmployeeListExample::getGender, Collectors.groupingBy(EmployeeListExample::getDeptName, Collectors.averagingDouble(EmployeeListExample::getSalary))));

		Map<String, Long> countDepartment = employees.stream()
				.collect(Collectors.groupingBy(EmployeeListExample::getDeptName, Collectors.counting()));

		Map<Boolean, List<EmployeeListExample>> partitionByAge = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30));

		/*** 4. FILTERING / MAPPING / COLLECTING ***/
		List<EmployeeListExample> getEmployeeListBySalary = employees.stream()
				.filter(e -> e.getSalary() > 100000 && e.getSalary() < 150000)
				.toList();

		List<String> departmentNamesList = employees.stream()
				.map(EmployeeListExample::getDeptName)
				.distinct()
				.toList();

		Set<String> departmentNamesSet = employees.stream()
				.map(EmployeeListExample::getDeptName)
				.collect(Collectors.toSet());

		List<Integer> getAllAge = employees.stream()
				.map(EmployeeListExample::getAge)
				.toList();

		/*** 5. SORTING ***/
		List<EmployeeListExample> sortEmployeesBySalary = employees.stream()
				.sorted(Comparator.comparingLong(EmployeeListExample::getSalary))
				.toList();

		List<EmployeeListExample> sortEmployeesBySalaryReversed = employees.stream()
				.sorted(Comparator.comparing(EmployeeListExample::getSalary).reversed())
				.toList();

		List<EmployeeListExample> sortedByDeptThenSalary = employees.stream()
				.sorted(Comparator.comparing(EmployeeListExample::getDeptName)
				.thenComparing(EmployeeListExample::getSalary))
				.toList();

		/*** 6. TOP-N / CUSTOM FILTERS ***/
		List<EmployeeListExample> top3Salaries = employees.stream()
				.sorted(Comparator.comparing(EmployeeListExample::getSalary).reversed())
				.limit(3)
				.toList();

		long secondHighestSalary = employees.stream()
				.mapToLong(EmployeeListExample::getSalary)
				.distinct()
				.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.orElse(0L);
		
		EmployeeListExample secondHighestEmpSalary = EmployeeListExample.employees.stream()
				.sorted(Comparator.comparingDouble(EmployeeListExample::getSalary).reversed())
				.distinct()
				.skip(1)
				.findFirst()
				.orElse(null);
		
		Map<String, Long> secondHighestEmpSalary2 = EmployeeListExample.employees.stream()
			    .sorted(Comparator.comparingLong(EmployeeListExample::getSalary).reversed())
			    .distinct()
			    .skip(1)
			    .findFirst()
			    .map(e -> Map.of(e.getName(), e.getSalary()))
				.orElse(/* Map.of() */ null);

		Map<String, List<EmployeeListExample>> top2SalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(
						EmployeeListExample::getDeptName,
						Collectors.collectingAndThen(
								Collectors.toList(),
								list -> list.stream()
								.sorted(Comparator.comparing(EmployeeListExample::getSalary).reversed())
								.limit(2)
								.toList()
								)
						));
		
		Map<String, EmployeeListExample> getMaleNameAndEmp = EmployeeListExample.employees.stream()
				.filter(e -> e.getGender().equals("M"))
				.collect(Collectors.toMap(EmployeeListExample::getName, e -> e));

		/*** 7. MAP CREATION ***/
		Map<String, Long> getEmployeeMapBySalary = employees.stream()
				.filter(e -> e.getSalary() > 100000 && e.getSalary() < 150000)
				.collect(Collectors.toMap(EmployeeListExample::getName, EmployeeListExample::getSalary));

		Map<String, Integer> getNameAndAge = employees.stream()
				.collect(Collectors.toMap(EmployeeListExample::getName, EmployeeListExample::getAge));

		Map<String, EmployeeListExample> getNameAndEmp = employees.stream()
				.collect(Collectors.toMap(EmployeeListExample::getName, e -> e));

		/*** 8. SEARCHING / LOOKUPS ***/
		EmployeeListExample getEmployeeData = employees.stream()
				.filter(e -> e.getName().equals("Priya") && e.getDeptName().equals("Marketing"))
				.findFirst().orElse(null);

		EmployeeListExample findYoungestFemaleEmployee = employees.stream()
				.filter(emp -> emp.getGender().equals("F"))
				.min(Comparator.comparingInt(EmployeeListExample::getAge))
				.orElse(null);
		
		Map<String, Integer> findYoungestFemaleEmployeeMap = EmployeeListExample.employees.stream()
				.filter(emp -> emp.getGender().equals("F"))
			    .min(Comparator.comparingInt(EmployeeListExample::getAge))
			    .map(e -> Map.of(e.getName(), e.getAge()))
			    .orElse(null);

		EmployeeListExample maxSalaryEmployee = employees.stream()
				.max(Comparator.comparingDouble(EmployeeListExample::getSalary)).orElse(null);

		/*** 9. EXTRA: Duplicates by name ***/
		Map<String, Long> nameCount = employees.stream()
				.collect(Collectors.groupingBy(EmployeeListExample::getName, Collectors.counting()));

		List<String> duplicateNames = nameCount.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey)
				.toList();

		/*** 10. MISC ***/
		String allNames = employees.stream()
				.map(EmployeeListExample::getName)
				.collect(Collectors.joining(", "));

		String largestDept = employees.stream()
				.collect(Collectors.groupingBy(EmployeeListExample::getDeptName, Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse("No Department");
	}
}

class Pratice
{
	public static void main(String[] args) {
		
	}
}