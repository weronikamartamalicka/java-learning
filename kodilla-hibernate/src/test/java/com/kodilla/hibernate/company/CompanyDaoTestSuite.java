package com.kodilla.hibernate.company;

import com.kodilla.hibernate.company.dao.CompanyDao;
import com.kodilla.hibernate.company.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Transactional
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

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

        List<Company> companiesList = companyDao.getCompanyNamesStartingWith("Sof");
        List<Employee> employeeList = employeeDao.getEmployeesWithSurname("Smith");

        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);
        assertEquals(1, companiesList.size());
        System.out.println(companiesList);
        assertEquals(1,employeeList.size());

        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
        }
    }
}
