package com.example.streampracticetask.practice;

import com.example.streampracticetask.model.*;
import com.example.streampracticetask.service.*;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Practice {

    public static CountryService countryService;
    public static DepartmentService departmentService;
    public static EmployeeService employeeService;
    public static JobHistoryService jobHistoryService;
    public static JobService jobService;
    public static LocationService locationService;
    public static RegionService regionService;

    public Practice(CountryService countryService, DepartmentService departmentService,
                    EmployeeService employeeService, JobHistoryService jobHistoryService,
                    JobService jobService, LocationService locationService,
                    RegionService regionService) {

        Practice.countryService = countryService;
        Practice.departmentService = departmentService;
        Practice.employeeService = employeeService;
        Practice.jobHistoryService = jobHistoryService;
        Practice.jobService = jobService;
        Practice.locationService = locationService;
        Practice.regionService = regionService;

    }

    // You can use the services above for all the CRUD (create, read, update, delete) operations.
    // Above services have all the required methods.
    // Also, you can check all the methods in the ServiceImpl classes inside the service.impl package, they all have explanations.

    // Get all the employees
    public static List<Employee> getAllEmployees() {
        return employeeService.readAll();
    }

    // Get all the countries
    public static List<Country> getAllCountries() {
        return countryService.readAll();
    }

    // Get all the departments
    public static List<Department> getAllDepartments() {
        return departmentService.readAll();
    }

    // Get all the jobs
    public static List<Job> getAllJobs() {
        return jobService.readAll();
    }

    // Get all the locations
    public static List<Location> getAllLocations() {
        return locationService.readAll();
    }

    // Get all the regions
    public static List<Region> getAllRegions() {
        return regionService.readAll();
    }

    // Get all the job histories
    public static List<JobHistory> getAllJobHistories() {
        return jobHistoryService.readAll();
    }

    // Get all the employees' first names
    public static List<String> getAllEmployeesFirstName() {
        return employeeService.readAll().stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    // Get all the countries' names
    public static List<String> getAllCountryNames() {
        return countryService.readAll().stream()
                .map(Country::getCountryName)
                .collect(Collectors.toList());
    }

    // Get all the departments' managers' first names
    public static List<String> getAllDepartmentManagerFirstNames() {
        return departmentService.readAll().stream()
                .map(Department::getManager)
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    // Get all the departments where manager name of the department is 'Steven'
    public static List<Department> getAllDepartmentsWhichManagerFirstNameIsSteven() {
        return departmentService.readAll().stream()
                .filter(d -> d.getManager().getFirstName().equals("Steven"))
                .collect(Collectors.toList());
    }

    // Get all the departments where postal code of the location of the department is '98199'
    public static List<Department> getAllDepartmentsWhereLocationPostalCodeIs98199() {
        return departmentService.readAll().stream()
                .filter(d -> d.getLocation().getPostalCode().equals("98199"))
                .collect(Collectors.toList());
    }

    // Get the region of the IT department
    public static Region getRegionOfITDepartment() throws Exception {
        return departmentService.readAll().stream()
                .filter(department -> department
                        .getDepartmentName()
                        .equals("IT"))
                .map(d -> d.getLocation().getCountry().getRegion())
                .findAny()
                .orElse(null);
    }

    // Get all the departments where the region of department is 'Europe'
    public static List<Department> getAllDepartmentsWhereRegionOfCountryIsEurope() {
        return departmentService.readAll().stream()
                .filter(department -> department
                        .getLocation()
                        .getCountry()
                        .getRegion()
                        .getRegionName()
                        .equals("Europe"))
                .collect(Collectors.toList());
    }

    // Get if there is any employee with salary less than 1000. If there is none, the method should return true
    public static boolean checkIfThereIsNoSalaryLessThan1000() {
        return employeeService.readAll().stream()
                .noneMatch(employee -> employee.getSalary() < 1000);
    }

    // Check if the salaries of all the employees in IT department are greater than 2000 (departmentName: IT)
    public static boolean checkIfThereIsAnySalaryGreaterThan2000InITDepartment() {
        return employeeService.readAll().stream()
                .filter(employee -> employee
                        .getDepartment()
                        .getDepartmentName()
                        .equals("IT")
                )
                .anyMatch(employee -> employee
                        .getSalary() > 2000
                );
    }

    // Get all the employees whose salary is less than 5000
    public static List<Employee> getAllEmployeesWithLessSalaryThan5000() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() < 5000)
                .collect(Collectors.toList());
    }

    // Get all the employees whose salary is between 6000 and 7000
    public static List<Employee> getAllEmployeesSalaryBetween() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() > 6000 && employee.getSalary() < 7000)
                .collect(Collectors.toList());
    }

    // Get the salary of the employee Grant Douglas (lastName: Grant, firstName: Douglas)
    public static Long getGrantDouglasSalary() throws Exception {
        return employeeService.readAll().stream()
                .filter(employee -> (employee.getLastName() + employee.getFirstName()).equals("GrantDouglas"))
                .map(Employee::getSalary)
                .findFirst()
                .orElse(0L);
    }

    // Get the maximum salary an employee gets
    public static Long getMaxSalary() throws Exception {
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .max(Double::compare)
                .orElse(0L);
    }

    // Get the employee(s) who gets the maximum salary
    public static List<Employee> getMaxSalaryEmployee() {
        return employeeService.readAll().stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .reduce((a, b) -> b)
                .orElseThrow()
                .getValue();
    }

    // Get the max salary employee's job
    public static Job getMaxSalaryEmployeeJob() throws Exception {
        return employeeService.readAll().stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .orElseThrow()
                .getJob();
    }

    // Get the max salary in Americas Region
    public static Long getMaxSalaryInAmericasRegion() throws Exception {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getDepartment()
                        .getLocation()
                        .getCountry()
                        .getRegion()
                        .getRegionName()
                        .equals("Americas"))
                .map(Employee::getSalary)
                .max(Long::compare)
                .orElse(0L);
    }

    // Get the second maximum salary an employee gets
    public static Long getSecondMaxSalary() throws Exception {
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0L);
    }

    // Get the employee(s) who gets the second maximum salary
    public static List<Employee> getSecondMaxSalaryEmployee() {
        Long secondMax = employeeService.readAll().stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0L);
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary().equals(secondMax))
                .collect(Collectors.toList());
    }

    // Get the minimum salary an employee gets
    public static Long getMinSalary() throws Exception {
        return employeeService.readAll().stream()
                .mapToLong(Employee::getSalary)
                .min()
                .orElse(0L);
    }

    // Get the employee(s) who gets the minimum salary
    public static List<Employee> getMinSalaryEmployee() {
        return employeeService.readAll().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .limit(1)
                .collect(Collectors.toList());
    }

    // Get the second minimum salary an employee gets
    public static Long getSecondMinSalary() throws Exception {
        return employeeService.readAll().stream()
                .map(Employee::getSalary)
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(0L);
    }

    // Get the employee(s) who gets the second minimum salary
    public static List<Employee> getSecondMinSalaryEmployee() {
        return employeeService.readAll().stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .skip(1)
                .findFirst()
                .stream()
                .map(Map.Entry::getValue)
                .findAny()
                .orElse(null);

    }

    // Get the average salary of the employees
    public static Double getAverageSalary() {
        return employeeService.readAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    // Get all the employees who are making more than average salary
    public static List<Employee> getAllEmployeesAboveAverage() {
        Double average = employeeService.readAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() > average)
                .collect(Collectors.toList());
    }

    // Get all the employees who are making less than average salary
    public static List<Employee> getAllEmployeesBelowAverage() {
        Double average = employeeService.readAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        return employeeService.readAll().stream()
                .filter(employee -> employee.getSalary() < average)
                .collect(Collectors.toList());
    }

    // Get all the employees separated based on their department id number
    public static Map<Long, List<Employee>> getAllEmployeesForEachDepartment() {
        return employeeService.readAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getId()));
    }

    // Get the total number of the departments
    public static Long getTotalDepartmentsNumber() {
        return departmentService.readAll().stream()
                .mapToLong(e -> 1L)
                .sum();
    }

    // Get the employee whose first name is 'Alyssa' and manager's first name is 'Eleni' and department name is 'Sales'
    public static Employee getEmployeeWhoseFirstNameIsAlyssaAndManagersFirstNameIsEleniAndDepartmentNameIsSales() throws Exception {
        return employeeService.readAll().stream()
                .filter(employee ->
                        employee.getFirstName().equals("Alyssa")
                                && employee.getManager().getFirstName().equals("Eleni")
                                && employee.getDepartment().getDepartmentName().equals("Sales")
                ).findFirst()
                .orElse(new Employee());
    }

    // Get all the job histories in ascending order by start date
    public static List<JobHistory> getAllJobHistoriesInAscendingOrder() {
        return jobHistoryService.readAll().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate))
                .collect(Collectors.toList());
    }

    // Get all the job histories in descending order by start date
    public static List<JobHistory> getAllJobHistoriesInDescendingOrder() {
        return jobHistoryService.readAll().stream()
                .sorted(Comparator.comparing(JobHistory::getStartDate).reversed())
                .collect(Collectors.toList());
    }

    // Get all the job histories where the start date is after 01.01.2005
    public static List<JobHistory> getAllJobHistoriesStartDateAfterFirstDayOfJanuary2005() {
        return jobHistoryService.readAll().stream()
                .filter(job -> job.getStartDate()
                        .isAfter(LocalDate.of(2005, 1, 1))
                )
                .collect(Collectors.toList());
    }

    // Get all the job histories where the end date is 31.12.2007 and the job title of job is 'Programmer'
    public static List<JobHistory> getAllJobHistoriesEndDateIsLastDayOfDecember2007AndJobTitleIsProgrammer() {
        return jobHistoryService.readAll().stream()
                .filter(jobHistory -> jobHistory.getEndDate()
                        .isEqual(
                                LocalDate.of(2007, 12, 31)
                        )
                        && jobHistory.getJob().getJobTitle().equals("Programmer")
                )
                .collect(Collectors.toList());
    }

    // Get the employee whose job history start date is 01.01.2007 and job history end date is 31.12.2007 and department's name is 'Shipping'
    public static Employee getEmployeeOfJobHistoryWhoseStartDateIsFirstDayOfJanuary2007AndEndDateIsLastDayOfDecember2007AndDepartmentNameIsShipping() throws Exception {
        return jobHistoryService.readAll().stream()
                .filter(jobHistory ->
                        jobHistory
                                .getStartDate()
                                .isEqual(LocalDate.of(2007, 1, 1))
                                && jobHistory
                                .getEndDate()
                                .isEqual(LocalDate.of(2007, 12, 31))
                                && jobHistory
                                .getDepartment()
                                .getDepartmentName()
                                .equals("Shipping")
                )
                .map(JobHistory::getEmployee)
                .findFirst()
                .orElseThrow();
    }

    // Get all the employees whose first name starts with 'A'
    public static List<Employee> getAllEmployeesFirstNameStartsWithA() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // Get all the employees whose job id contains 'IT'
    public static List<Employee> getAllEmployeesJobIdContainsIT() {
        return employeeService.readAll().stream()
                .filter(employee -> employee.getJob().getId().contains("IT"))
                .collect(Collectors.toList());
    }

    // Get the number of employees whose job title is programmer and department name is 'IT'
    public static Long getNumberOfEmployeesWhoseJobTitleIsProgrammerAndDepartmentNameIsIT() {
        return employeeService.readAll().stream()
                .filter(employee ->
                            employee
                                    .getJob()
                                    .getJobTitle()
                                    .equals("Programmer")
                            && employee
                                    .getDepartment()
                                    .getDepartmentName()
                                    .equals("IT")
                )
                .mapToLong(e->1L)
                .sum();
    }

    // Get all the employees whose department id is 50, 80, or 100
    public static List<Employee> getAllEmployeesDepartmentIdIs50or80or100() {
        List<Long> target = Arrays.asList(50L,80L,100L);
        return employeeService.readAll().stream()
                .filter(employee -> target.contains(employee.getDepartment().getId()))
                .collect(Collectors.toList());
    }

    // Get the initials of all the employees
    // Note: You can assume that there is no middle name
    public static List<String> getAllEmployeesInitials() {
        return employeeService.readAll().stream()
                .map(employee -> "" +
                        employee.getFirstName().charAt(0)
                        +
                        employee.getLastName().charAt(0))
                .collect(Collectors.toList());
    }

    // Get the full names of all the employees
    public static List<String> getAllEmployeesFullNames() {
        return employeeService.readAll().stream()
        .map(employee ->
                employee.getFirstName()
                + " " +
                employee.getLastName()
        )
        .collect(Collectors.toList());
    }

    // Get the length of the longest full name(s)
    public static Integer getLongestNameLength() throws Exception {
        return employeeService.readAll().stream()
                .mapToInt(employee->
                        employee.getFirstName().length()
                        +
                        employee.getLastName().length()
                        + 1  // for space
                )
                .max()
                .orElseThrow();
    }

    // Get the employee(s) with the longest full name(s)
    public static List<Employee> getLongestNamedEmployee() {
        return employeeService.readAll().stream()
                .collect(Collectors.groupingBy(employee ->
                        employee.getFirstName().length()
                                +
                                employee.getLastName().length()
                                + 1))
                .entrySet().stream().max(Map.Entry.comparingByKey())
                .stream()
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

    }

    // Get all the employees whose department id is 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIs90or60or100or120or130() {
        List<Long> target = Arrays.asList(60L,90L,100L, 120L, 130L);
        return employeeService.readAll().stream()
                .filter(employee -> target.contains(employee.getDepartment().getId()))
                .collect(Collectors.toList());
    }

    // Get all the employees whose department id is NOT 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIsNot90or60or100or120or130() {
        List<Long> target = Arrays.asList(60L,90L,100L, 120L, 130L);
        return employeeService.readAll().stream()
                .filter(employee -> !target.contains(employee.getDepartment().getId()))
                .collect(Collectors.toList());
    }

}
