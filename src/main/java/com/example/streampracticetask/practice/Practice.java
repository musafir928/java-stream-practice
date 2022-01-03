package com.example.streampracticetask.practice;

import com.example.streampracticetask.dto.Employee;
import com.example.streampracticetask.dto.JobHistory;
import com.example.streampracticetask.service.*;
import org.springframework.stereotype.Component;

import java.util.List;

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
    // Also, you can check all the methods in the ServiceImpl classes, they all have explanations.

    // Display all the employees
    public static List<Employee> getAllEmployees() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees' first name
    public static List<String> getAllEmployeesFirstName() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose salary is less than 5000
    public static List<Employee> getAllEmployeesWithLessSalaryThan5000() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose salary is between 6000 and 7000
    public static List<Employee> getAllEmployeesSalaryBetween() {
        //TODO Implement the method
        return null;
    }

    // Display the salary of the employee Grant Douglas (lastName: Grant, firstName: Douglas)
    public static Long getGrantDouglasSalary() throws Exception {
        //TODO Implement the method
        return null;
    }

    // Display the maximum salary an employee gets
    public static Long getMaxSalary() throws Exception {
        //TODO Implement the method
        return null;
    }

    // Display the employee(s) who gets the maximum salary
    public static List<Employee> getMaxSalaryEmployee() {
        //TODO Implement the method
        return null;
    }

    // Display the second maximum salary an employee gets
    public static Long getSecondMaxSalary() throws Exception {
        //TODO Implement the method
        return null;
    }

    // Display the employee(s) who gets the second maximum salary
    public static List<Employee> getSecondMaxSalaryEmployee() {
        //TODO Implement the method
        return null;
    }

    // Display the minimum salary an employee gets
    public static Long getMinSalary() throws Exception {
        //TODO Implement the method
        return null;
    }

    // Display the employee(s) who gets the minimum salary
    public static List<Employee> getMinSalaryEmployee() {
        //TODO Implement the method
        return null;
    }

    // Display the second minimum salary an employee gets
    public static Long getSecondMinSalary() throws Exception {
        //TODO Implement the method
        return null;
    }

    // Display the employee(s) who gets the second minimum salary
    public static List<Employee> getSecondMinSalaryEmployee() {
        //TODO Implement the method
        return null;
    }

    // Display the average salary of the employees
    public static Double getAverageSalary() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees who are making more than average salary
    public static List<Employee> getAllEmployeesAboveAverage() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees who are making less than average salary
    public static List<Employee> getAllEmployeesBelowAverage() {
        //TODO Implement the method
        return null;
    }

    // Display the total number of the departments
    public static Long getTotalDepartmentsNumber() {
        //TODO Implement the method
        return null;
    }

    // Display all the job histories in ascending order by start date
    public static List<JobHistory> getAllJobHistoriesInAscendingOrder() {
        //TODO Implement the method
        return null;
    }

    // Display all the job histories in descending order by start date
    public static List<JobHistory> getAllJobHistoriesInDescendingOrder() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose first name starts with 'A'
    public static List<Employee> getAllEmployeesFirstNameStartsWithA() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose job id contains 'IT'
    public static List<Employee> getAllEmployeesJobIdContainsIT() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose department id is 50, 80, or 100
    public static List<Employee> getAllEmployeesDepartmentIdIs50or80or100() {
        //TODO Implement the method
        return null;
    }

    // Display the initials of all the employees
    // Note: You can assume that there is no middle name
    public static List<String> getAllEmployeesInitials() {
        //TODO Implement the method
        return null;
    }

    // Display the full names of all the employees
    public static List<String> getAllEmployeesFullNames() {
        //TODO Implement the method
        return null;
    }

    // Display the length of the longest full name(s)
    public static Integer getLongestNameLength() throws Exception {
        //TODO Implement the method
        return null;
    }

    // Display the employee(s) with the longest full name(s)
    public static List<Employee> getLongestNamedEmployee() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose department id is 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIs90or60or100or120or130() {
        //TODO Implement the method
        return null;
    }

    // Display all the employees whose department id is NOT 90, 60, 100, 120, or 130
    public static List<Employee> getAllEmployeesDepartmentIdIsNot90or60or100or120or130() {
        //TODO Implement the method
        return null;
    }


}
