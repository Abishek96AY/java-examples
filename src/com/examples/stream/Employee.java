package com.examples.stream;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Employee {

	private int id;
	private String name;
	private int age;
	private double salary;
	private String gender;
	private String deptName;
	private String city;
	private int yearOfJoining;

	public Employee(int id, String name, int age, long salary, String gender, String deptName, String city, int yearOfJoining) {
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

	public double getSalary() {
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

	public static List<Employee> employees = Arrays.asList(
			new Employee(1, "Rahul", 24, 120000, "M", "Engineering", "Bangalore", 2000),
			new Employee(2, "Vishal", 34, 110000, "M", "Engineering", "Mumbai", 1998),
			new Employee(3, "Lakshmi", 28, 140000, "F", "HR", "Bangalore", 1992),
			new Employee(4, "Priya", 24, 90000, "F", "Marketing", "Delhi", 2005),
			new Employee(5, "Aditi", 30, 130000, "F", "HR", "Mumbai", 1995),
			new Employee(6, "Jenni", 30, 100000, "F", "Engineering", "Mumbai", 1995)
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
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0);

		double totalSalary = employees.stream()
				.mapToDouble(Employee::getSalary)
				.sum();

		double totalSalaryReduce = employees.stream()
				.map(Employee::getSalary)
				.reduce(0.0, Double::sum);

		double minSalary = employees.stream()
				.mapToDouble(Employee::getSalary)
				.min()
				.orElse(0L);

		double maxSalary = employees.stream()
				.mapToDouble(Employee::getSalary)
				.max()
				.orElse(0L);
		
		Employee maxEmployeeBySalary = Employee.employees.stream()
				.max(Comparator.comparing(Employee::getSalary)).orElse(null);
		
		Optional<Employee> findEmployeeObjByName = employees.stream()
			    .filter(e -> e.getName().equals("Abishek"))
			    .findFirst();

		DoubleSummaryStatistics salaryStats = employees.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		/*** 3. GROUPING / PARTITIONING ***/
		Map<String, Double> avgSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
		
		Map<String, List<Employee>> employeesByAgeGroupCustom = employees.stream()
			    .collect(Collectors.groupingBy(e -> {
			        if (e.getAge() <= 25) return "Young";
			        else if (e.getAge() <= 40) return "Mid-age";
			        else return "Senior";
			    }));
		
		Map<String, Map<String, Double>> avgSalaryByGenderAndDept = Employee.employees.stream().
				collect(Collectors.groupingBy(Employee::getGender, Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary))));

		Map<String, Long> countDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

		Map<Boolean, List<Employee>> partitionByAge = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30));

		/*** 4. FILTERING / MAPPING / COLLECTING ***/
		List<Employee> getEmployeeListBySalary = employees.stream()
				.filter(e -> e.getSalary() > 100000 && e.getSalary() < 150000)
				.toList();

		List<String> departmentNamesList = employees.stream()
				.map(Employee::getDeptName)
				.distinct()
				.toList();

		Set<String> departmentNamesSet = employees.stream()
				.map(Employee::getDeptName)
				.collect(Collectors.toSet());

		List<Integer> getAllAge = employees.stream()
				.map(Employee::getAge)
				.toList();

		/*** 5. SORTING ***/
		List<Employee> sortEmployeesBySalary = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary))
				.toList();

		List<Employee> sortEmployeesBySalaryReversed = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.toList();

		List<Employee> sortedByDeptThenSalary = employees.stream()
				.sorted(Comparator.comparing(Employee::getDeptName)
				.thenComparing(Employee::getSalary))
				.toList();

		/*** 6. TOP-N / CUSTOM FILTERS ***/
		List<Employee> top3Salaries = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.distinct()
				.limit(3)
				.toList();
		
		List<String> employeeNames = Employee.employees.stream()
			    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
			    .map(Employee::getName)
			    .toList();

		double secondHighestSalary = employees.stream()
				.mapToDouble(Employee::getSalary)
				.distinct()
				.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.orElse(0.0);
		
		Employee secondHighestEmpSalary = Employee.employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.distinct()
				.skip(1)
				.findFirst()
				.orElse(null);
		
		Map<String, Double> secondHighestEmpSalary2 = Employee.employees.stream()
			    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
			    .distinct()
			    .skip(1)
			    .findFirst()
			    .map(e -> Map.of(e.getName(), e.getSalary()))
				.orElse(Map.of());
		
		Map<String, Employee> secondHighestEmpSalary3 = Employee.employees.stream()
			    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
			    .distinct()
			    .skip(1)
			    .findFirst()
			    .map(e -> Map.of(e.getName(), e))
				.orElse(Map.of());

		Map<String, List<Employee>> top2SalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getDeptName,
						Collectors.collectingAndThen(
								Collectors.toList(),
								list -> list.stream()
								.sorted(Comparator.comparing(Employee::getSalary).reversed())
								.limit(2)
								.toList()
								)
						));
		
		Map<String, Employee> getMaleNameAndEmp = Employee.employees.stream()
				.filter(e -> e.getGender().equals("M"))
				.collect(Collectors.toMap(Employee::getName, e -> e));

		/*** 7. MAP CREATION ***/
		Map<String, Double> getEmployeeMapBySalary = employees.stream()
				.filter(e -> e.getSalary() > 100000 && e.getSalary() < 150000)
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));

		Map<String, Integer> getNameAndAge = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getAge));

		Map<String, Employee> getNameAndEmp = employees.stream()
				.collect(Collectors.toMap(Employee::getName, e -> e));

		/*** 8. SEARCHING / LOOKUPS ***/
		Employee getEmployeeData = employees.stream()
				.filter(e -> e.getName().equals("Priya") && e.getDeptName().equals("Marketing"))
				.findFirst().orElse(null);

		Employee findYoungestFemaleEmployee = employees.stream()
				.filter(emp -> emp.getGender().equals("F"))
				.min(Comparator.comparingInt(Employee::getAge))
				.orElse(null);
		
		Map<String, Integer> findYoungestFemaleEmployeeMap = Employee.employees.stream()
				.filter(emp -> emp.getGender().equals("F"))
			    .min(Comparator.comparingInt(Employee::getAge))
			    .map(e -> Map.of(e.getName(), e.getAge()))
			    .orElse(null);

		Employee maxSalaryEmployee = employees.stream()
				.max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);

		/*** 9. EXTRA: Duplicates by name ***/
		Map<String, Long> nameCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

		List<String> duplicateNames = nameCount.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey)
				.toList();

		/*** 10. MISC ***/
		String allNames = employees.stream()
				.map(Employee::getName)
				.collect(Collectors.joining(", "));

		String largestDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse("No Department");
	}
}

class Pratice {
	public static void main(String[] args) {
	}
}