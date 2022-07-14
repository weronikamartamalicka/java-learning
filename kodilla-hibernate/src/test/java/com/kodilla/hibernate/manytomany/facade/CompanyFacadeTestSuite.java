package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.company.Company;
import com.kodilla.hibernate.company.Employee;
import com.kodilla.hibernate.company.dao.CompanyDao;
import com.kodilla.hibernate.company.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.exception.FacadeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testCompanyFacade() throws FacadeException {

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

        List<Company> companiesList = companyFacade.findCompanyNameIsContaining("a");
        List<Employee> employeeList = companyFacade.findEmployeeNameIsContaining("la");

        assertEquals(3, companiesList.size());
        assertEquals(1, employeeList.size());

        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
        }
    }
}
