package lectures;

import beans.Employee;
import mockdata.MockData;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmplyeeTest {

    @Test
    public void maleAndFemaleEmployeeCount(){
        Map<String, Long> group = MockData.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(group);
    }


    @Test
    public void allDepartments(){
        MockData.getEmployees().stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }


    @Test
    public void avgAgeOfMaleAndFemaleEmployee(){
       Map<String, Double> group = MockData.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

       System.out.println(group);
    }


    @Test
    public void highestPaidEmployeeDetails(){
        MockData.getEmployees().stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);
    }


    @Test
    public void employeeJoinedAfter2015(){
        MockData.getEmployees().stream()
                .filter(it -> it.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void countOfEmployeeInEachDepartment(){
        Map<String, Long> group = MockData.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(group);
    }


    @Test
    public void averageSalaryOfEachDepartment(){
        Map<String, Double> group = MockData.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(group);
    }

    @Test
    public void youngestEmployeeInProductDevelopmentDepartment(){
        MockData.getEmployees().stream()
                .filter(it -> "Product Development".equalsIgnoreCase(it.getDepartment()) && "Male".equalsIgnoreCase(it.getGender()))
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);
    }

    @Test
    public void mostExperiencedINOrganization(){
        MockData.getEmployees().stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .ifPresent(System.out::println);
    }

    @Test
    public void maleAndFemaleInSaleAndMarketing(){
        Map<String, Long> group = MockData.getEmployees().stream()
                .filter(it -> "Sales And Marketing".equalsIgnoreCase(it.getDepartment()))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(group);
    }

    @Test
    public void departmentWiseEmployeeList(){
        Map<String, List<String>> group = MockData.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(group);
    }

    @Test
    public void averageAndTotalSalaryOfOrganization(){
        DoubleSummaryStatistics data = MockData.getEmployees().stream()
                .map(Employee::getSalary)
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        System.out.println(data);
    }


    @Test
    public void oldestEmployeeInOrganization(){
        MockData.getEmployees()
                .stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);
    }

    @Test
    public void employeePartitioningByEyongerOrEqualTo25(){
        Map<Boolean, List<Employee>> group = MockData.getEmployees().stream()
                .collect(Collectors.partitioningBy(it -> it.getAge() <= 25));

        System.out.println(group);
    }

    @Test
    public void countingWords(){
        String str  = "Fear leads to anger anger leads to hatred hatred leads to conflict conflict leads to suffering";
        Map<String, Long> group = Stream.of(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(group);
    }


    @Test
    public void countingCharacter(){
        String str  = "Fear leads to anger anger leads to hatred hatred leads to conflict conflict leads to suffering";
        Map<Character, Long> group = str.chars()
                .mapToObj(x -> (char)x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(group);


    }


    @Test
    public void countingWordsOther(){
        String str  = "Fear leads to anger anger leads to hatred hatred leads to conflict conflict leads to suffering";

        var group = Pattern.compile(" ").splitAsStream(str)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(group);


    }
}
