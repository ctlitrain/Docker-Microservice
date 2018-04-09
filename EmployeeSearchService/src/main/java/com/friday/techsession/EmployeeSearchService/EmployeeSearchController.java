package com.friday.techsession.EmployeeSearchService;

import java.util.Collection;

import com.friday.techsession.EmployeeSearchService.model.Employee;
import com.friday.techsession.EmployeeSearchService.service.EmployeeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class EmployeeSearchController {
    @Autowired
    EmployeeSearchService employeeSearchService;
    @RequestMapping("/employee/find/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeSearchService.findById(id);
    }
    @RequestMapping("/employee/findall")
    public Collection < Employee > findAll() {
        return employeeSearchService.findAll();
    }
}
