package com.journaldev.spring.main;

import com.journaldev.spring.model.Employee;
import com.journaldev.spring.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

        Employee proxyEmployee = employeeService.getEmployee();
        System.out.println(proxyEmployee.getName());

        //employeeService.getEmployee().setName("Pankaj");

        //employeeService.getEmployee().throwException();

        ctx.close();
    }

}
