package com.examples.problems.stream;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
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
	
	public static List<Employee> employees = Arrays.asList(
			new Employee(1, "Rahul", 24, 120000, "M", "Engineering", "Bangalore", 2000),
			new Employee(2, "Vishal", 34, 110000, "M", "Engineering", "Mumbai", 1998),
			new Employee(3, "Lakshmi", 28, 140000, "F", "HR", "Bangalore", 1992),
			new Employee(4, "Priya", 24, 90000, "F", "Marketing", "Delhi", 2005),
			new Employee(5, "Aditi", 30, 130000, "F", "HR", "Mumbai", 1995),
			new Employee(6, "Jenni", 30, 100000, "F", "Engineering", "Mumbai", 1995)
			);

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
				.max(Comparator.comparing(Employee::getSalary))
				.orElse(null);
		
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
		
		List<Integer> getAllAge = employees.stream()
				.map(Employee::getAge)
				.toList();

		Set<String> departmentNamesSet = employees.stream()
				.map(Employee::getDeptName)
				.collect(Collectors.toSet());

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
		
		List<String> sortByEmpSalAndGetEmployeeNames = Employee.employees.stream()
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
		
		Map<String, Optional<Employee>> secondHighestSalaryEmployeeByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDeptName,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                                .distinct()
                                                .skip(1) // skip highest
                                                .findFirst() // pick second highest
                                )
                        ));
	   secondHighestSalaryEmployeeByDept.forEach((dept, emp) -> System.out.println(dept + " -> " + emp.map(Employee::getName).orElse("None")));

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
		Map<String, Double> getEmployeeMapBySalaryCondition = employees.stream()
				.filter(e -> e.getSalary() > 100000 && e.getSalary() < 150000)
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));

		Map<String, Integer> getNameAndAge = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getAge));

		Map<String, Employee> getNameAndEmp = employees.stream()
				.collect(Collectors.toMap(Employee::getName, e -> e));

		/*** 8. SEARCHING / LOOKUPS ***/
		Employee getEmployeeDataByName = employees.stream()
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
				.max(Comparator.comparingDouble(Employee::getSalary))
				.orElse(null);

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
				.map(e -> e.getKey())
				.orElse("No Department");
		
		/************************************************************************************************************/
		
		// Basic lists and sets
		List<String> employeeNames = Employee.employees.stream().map(Employee::getName).toList();

		Set<String> uniqueCityNames = Employee.employees.stream().map(Employee::getCity).collect(Collectors.toSet());

		List<Employee> employeesOlderThan25 = Employee.employees.stream().filter(e -> e.getAge() > 25).toList();

		List<Employee> employeesWithSalaryBelow100k = Employee.employees.stream().filter(e -> e.getSalary() < 100000).toList();

		List<String> employeesInMumbai = Employee.employees.stream()
		        .filter(e -> e.getCity().equals("Mumbai"))
		        .map(Employee::getName)
		        .toList();

		List<Employee> employeesJoinedBefore2000 = Employee.employees.stream()
		        .filter(e -> e.getYearOfJoining() < 2000)
		        .toList();

		List<Employee> employeesWithNameStartingWithA = Employee.employees.stream()
		        .filter(e -> e.getName().startsWith("A"))
		        .toList();

		// Sorting
		List<String> employeeNamesSortedAsc = Employee.employees.stream()
		        .map(Employee::getName)
		        .sorted()
		        .toList();

		List<String> employeeNamesSortedBySalaryAsc = Employee.employees.stream()
		        .sorted(Comparator.comparingDouble(Employee::getSalary))
		        .map(Employee::getName)
		        .toList();

		// Grouping & Counting
		Map<String, Long> genderWiseEmployeeCount = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		Map<String, Long> departmentWiseEmployeeCount = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

		// Aggregations
		Double averageEmployeeAge = Employee.employees.stream().mapToInt(Employee::getAge).average().orElse(0.0);

		Double averageEmployeeSalary = Employee.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);

		Double totalEmpSalary = Employee.employees.stream().mapToDouble(Employee::getSalary).sum();

		Double maxEmpSalary = Employee.employees.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);

		Integer minEmployeeAge = Employee.employees.stream().mapToInt(Employee::getAge).min().orElse(0);
		
		Double totalSalaryInMumbai = Employee.employees.stream()
		        .filter(e -> e.getCity().equals("Mumbai"))
		        .mapToDouble(Employee::getSalary)
		        .sum();

		// Extremes
		Optional<Employee> mostExperiencedEmployee = Employee.employees.stream()
		        .max(Comparator.comparing(Employee::getExperience));

		Optional<Employee> youngestEmployee = Employee.employees.stream()
		        .min(Comparator.comparing(Employee::getAge));

		Optional<Employee> oldestEmployee = Employee.employees.stream()
		        .max(Comparator.comparing(Employee::getAge));

		// Grouping
		Map<String, List<Employee>> employeesByDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.toList()));

		Map<String, List<Employee>> employeesByCity = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getCity));

		Map<String, Optional<Employee>> highestPaidEmployeePerDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(
		                Employee::getDeptName,
		                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
		        ));

		Map<String, Double> averageSalaryPerDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));

		Map<String, Double> totalSalaryPerDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.summingDouble(Employee::getSalary)));

		// Partitioning
		Map<Boolean, List<Employee>> employeesPartitionedBySalaryAbove100k = Employee.employees.stream()
		        .collect(Collectors.partitioningBy(e -> e.getSalary() > 100000));

		Map<Boolean, List<Employee>> employeesPartitionedByAgeAbove30 = Employee.employees.stream()
		        .collect(Collectors.partitioningBy(e -> e.getAge() > 30));

		// Multi-level grouping
		Map<String, Map<String, List<Employee>>> employeesByGenderThenDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getGender,
		                Collectors.groupingBy(Employee::getDeptName)));

		Map<String, List<String>> employeeNamesPerDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName,
		                Collectors.mapping(Employee::getName, Collectors.toList())));

		Map<String, Long> employeesJoinedAfter1995ByDepartment = Employee.employees.stream()
		        .filter(e -> e.getYearOfJoining() > 1995)
		        .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

		// N-th salaries
		Optional<Employee> secondHighestSalaryEmployee = Employee.employees.stream()
		        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
		        .skip(1)
		        .findFirst();

		Optional<Employee> thirdHighestSalaryEmployee = Employee.employees.stream()
		        .sorted(Comparator.comparing(Employee::getSalary).reversed())
		        .skip(2)
		        .findFirst();

		// Sorting combos
		Optional<Employee> secondYoungestEmployee = Employee.employees.stream()
		        .map(Employee::getAge)
		        .distinct()
		        .sorted()
		        .skip(1)
		        .findFirst()
		        .flatMap(age -> Employee.employees.stream().filter(e -> e.getAge() == age).findFirst());

		List<Employee> employeesSortedByAgeThenSalary = Employee.employees.stream()
		        .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getSalary))
		        .toList();

		List<Employee> employeesSortedByExperienceDesc = Employee.employees.stream()
		        .sorted(Comparator.comparingInt(Employee::getYearOfJoining).reversed())
		        .toList();

		List<Employee> employeesSortedByCityThenName = Employee.employees.stream()
		        .sorted(Comparator.comparing(Employee::getCity)
		        .thenComparing(Employee::getName))
		        .toList();

		// Gender-based filters
		Optional<Employee> highestPaidFemaleEmployee = Employee.employees.stream()
		        .filter(e -> e.getGender().equals("F"))
		        .max(Comparator.comparingDouble(Employee::getSalary));

		Optional<Employee> lowestPaidMaleEmployee = Employee.employees.stream()
		        .filter(e -> e.getGender().equals("M"))
		        .min(Comparator.comparingDouble(Employee::getSalary));

		// Department-specific queries
		List<Employee> top2OldestEmployeesInEngineering = Employee.employees.stream()
		        .filter(e -> e.getDeptName().equals("Engineering"))
		        .sorted(Comparator.comparingInt(Employee::getAge).reversed())
		        .limit(2)
		        .toList();

		List<Employee> top2YoungestEmployeesInHR = Employee.employees.stream()
		        .filter(e -> e.getDeptName().equals("HR"))
		        .sorted(Comparator.comparingInt(Employee::getAge))
		        .limit(2)
		        .toList();

		// Sets
		Set<String> departmentNames = Employee.employees.stream()
		        .map(Employee::getDeptName)
		        .collect(Collectors.toSet());

		// Gender Salary
		Map<String, Double> averageSalaryByGender = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		// Department extremes
		Map<String, Long> departmentWithMostEmployees = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
		        .entrySet().stream()
		        .max(Map.Entry.comparingByValue())
		        .map(e -> Map.of(e.getKey(), e.getValue()))
		        .orElse(Map.of());

		Map<String, Double> departmentWithHighestAverageSalary = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName,
		                Collectors.averagingDouble(Employee::getSalary)))
		        .entrySet().stream()
		        .max(Map.Entry.comparingByValue())
		        .map(e -> Map.of(e.getKey(), e.getValue()))
		        .orElse(Map.of());

		Map<String, Double> maxSalaryPerDepartment = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDeptName,
		                Collectors.collectingAndThen(Collectors.toList(),
		                        list -> list.stream().mapToDouble(Employee::getSalary).max().orElse(0.0))));

		Map<String, Long> cityWiseEmployeeCount = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));

		// Age distribution
		Integer mostCommonAge = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()))
		        .entrySet().stream()
		        .max(Map.Entry.comparingByValue())
		        .get()
		        .getKey();

		Map<Integer, List<String>> employeesGroupedByAgeWithNames = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getAge,
		                Collectors.mapping(Employee::getName, Collectors.toList())));

		List<Integer> mostCommonAges = Employee.employees.stream()
		        .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()))
		        .entrySet().stream()
		        .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
		        .entrySet().stream()
		        .max(Map.Entry.comparingByKey())
		        .map(Map.Entry::getValue)
		        .orElse(List.of());
		/************************************************************************************************************/
	}
}