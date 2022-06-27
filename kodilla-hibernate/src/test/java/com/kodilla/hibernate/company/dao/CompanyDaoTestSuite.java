package com.kodilla.hibernate.company.dao;

import com.kodilla.hibernate.company.Company;
import com.kodilla.hibernate.company.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Test
    void testSaveManyToMany() {

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployeeList().add(johnSmith);
        dataMaesters.getEmployeeList().add(stephanieClarckson);
        dataMaesters.getEmployeeList().add(lindaKovalsky);
        greyMatter.getEmployeeList().add(johnSmith);
        greyMatter.getEmployeeList().add(lindaKovalsky);

        johnSmith.getListOfCompanies().add(softwareMachine);
        johnSmith.getListOfCompanies().add(greyMatter);
        stephanieClarckson.getListOfCompanies().add(dataMaesters);
        lindaKovalsky.getListOfCompanies().add(dataMaesters);
        lindaKovalsky.getListOfCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
        }
    }
}
