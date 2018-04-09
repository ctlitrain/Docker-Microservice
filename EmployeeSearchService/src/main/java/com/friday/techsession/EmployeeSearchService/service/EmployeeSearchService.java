package com.friday.techsession.EmployeeSearchService.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.friday.techsession.EmployeeSearchService.model.Employee;
import org.springframework.stereotype.Service;
@Service
public class EmployeeSearchService {
    private static Map < Long, Employee> EmployeeRepsitory = null;
    static {
        Stream < String > employeeStream = Stream.of("1,Rahul Lokurte,Java,Senior Software Engineer", "2,Rahul Kumar,Java,Software Engineer",
                "3,Rajesh Meena,UNIX,Team Lead");
        EmployeeRepsitory = employeeStream.map(employeeStr -> {
            String[] info = employeeStr.split(",");
            return createEmployee(new Long(info[0]), info[1], info[2], info[3]);
        }).collect(Collectors.toMap(Employee::getEmployeeId, emp -> emp));
    }
    private static Employee createEmployee(Long id, String name, String practiceArea, String designation) {
        Employee emp = new Employee();
        emp.setEmployeeId(id);
        emp.setName(name);
        emp.setPracticeArea(practiceArea);
        emp.setDesignation(designation);
        emp.setCompanyInfo("Centurylink");
        return emp;
    }
    public Employee findById(Long id) {
        return EmployeeRepsitory.get(id);
    }
    public Collection < Employee > findAll() {
        return EmployeeRepsitory.values();
    }
}