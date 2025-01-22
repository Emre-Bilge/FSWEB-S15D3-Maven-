package org.example;


import org.example.entity.Employee;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

  private static Map<Integer,Employee> employeeMap;

  private static List<Employee> dublicatedEmployees ;

    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "emre", "bilge"));
        employees.add(new Employee(2, "beyza", "bilge"));
        employees.add(new Employee(3, "nadir", "bilge"));
        employees.add(new Employee(4, "şerife", "bilge"));
        employees.add(new Employee(1, "mehmet", "karpuz"));
        employees.add(new Employee(4, "turgut", "banana"));


        System.out.println(findDuplicates(employees).size());
        System.out.println(removeDuplicates(employees));

    }

public static List<Employee> findDuplicates(List<Employee> employees) {
    employeeMap = new HashMap<>();
    dublicatedEmployees = new LinkedList<>();

    Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
        Employee employee = iterator.next();
        if (employee == null) {
            System.out.println("null recorded");
            continue;
        }
        if (employeeMap.containsKey(employee.getId())) {
            dublicatedEmployees.add(employee);
        } else {
            employeeMap.put(employee.getId(), employee);
        }

    }
    return dublicatedEmployees;

}

public static Map<Integer,Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();
    Iterator<Employee> iterator = employees.iterator();
    while(iterator.hasNext()){
        Employee employee = iterator.next();
        if(employee == null){
            System.out.println("null geldi");
            continue;
        }if(!employeeMap.containsKey(employee.getId())){
            employeeMap.put(employee.getId(),employee);
        }
    }
    return employeeMap ;
}

public static List<Employee> removeDuplicates(List<Employee> employees){
    List<Employee> duplicates = findDuplicates(employees);
    Map<Integer, Employee> uniques = findUniques(employees);
    List<Employee> onlyUnique = new LinkedList<>(uniques.values());
    onlyUnique.removeAll(duplicates);
    return onlyUnique ;
}

}





































/*

    List<Employee> dublicates = findDuplicates(employees);

        System.out.println("Tekrar eden çalışanlar : ");

        for(Employee employee : dublicates){
            System.out.println(employee);
        }

         System.out.println(WordCounter.calculatedWord());

    }


    public static List<Employee> findDuplicates(List<Employee> employeeList){
            Set<Integer> savedId = new HashSet<>();
            List<Employee> ortakEmployee = new LinkedList<>();

            for(Employee employee : employeeList){
          if(!savedId.add(employee.getId())){
              ortakEmployee.add(employee);
          }
            }
return ortakEmployee;
    }


    public static Map<Integer, Employee> findUniques(List<Employee> employeeList) {
        Map<Integer, Employee> uniqueEmployee = new HashMap<>();
        for (Employee employee : employeeList) {
            if (!uniqueEmployee.containsKey(employee.getId())) {
                uniqueEmployee.put(employee.getId(), employee);  // Yalnızca id'si ilk defa eklenen çalışanı ekler
            }
        }
        return uniqueEmployee;
    }


    public static List<Employee> removeDuplicates(List<Employee> employeeList){
        Set<Employee> filtredEmployee = new HashSet<>();

        for(Employee employee : employeeList){
            filtredEmployee.add(employee);
        }
        filtredEmployee.removeAll(employeeList);

        List<Employee> filtredList = new ArrayList<>(filtredEmployee);

    return filtredList;
    }
*/
