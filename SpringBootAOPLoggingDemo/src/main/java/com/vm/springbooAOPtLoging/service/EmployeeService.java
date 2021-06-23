package com.vm.springbooAOPtLoging.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.springbooAOPtLoging.exception.ResourceNotFoundException;
import com.vm.springbooAOPtLoging.model.Employee;
import com.vm.springbooAOPtLoging.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    List<Employee> employeList = new ArrayList<Employee>();
    public List < Employee > getAllEmployees() {
//    	employeList.add(new Employee("Bhargawa", "Talluri", "abcd@gmail.com"));
//    	
//    	return employeList;
        return employeeRepository.findAll();
    	
    }

    public Optional < Employee > getEmployeeById(Long employeeId)
    throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId,
        Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository
        		.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    public Map < String, Boolean > deleteEmployee(Long employeeId)
    throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        		.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}