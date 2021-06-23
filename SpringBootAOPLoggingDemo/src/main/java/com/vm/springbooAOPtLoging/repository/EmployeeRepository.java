package com.vm.springbooAOPtLoging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.springbooAOPtLoging.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository < Employee, Long > {

}