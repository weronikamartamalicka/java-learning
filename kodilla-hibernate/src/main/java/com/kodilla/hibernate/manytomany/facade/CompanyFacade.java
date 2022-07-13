package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.company.Company;
import com.kodilla.hibernate.company.Employee;
import com.kodilla.hibernate.company.dao.CompanyDao;
import com.kodilla.hibernate.company.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.exception.FacadeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CompanyFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    @Autowired
    public CompanyFacade(final CompanyDao companyDao, final EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompanyNameIsContaining(String name) throws FacadeException {
        LOGGER.info("Process of searching company name is starting");
        try {
            return companyDao.getCompanyNamesIsContaining(name);
        } catch (FacadeException e) {
            LOGGER.error("There was no company name containing provided letters");
            if(companyDao.count() == 0) {
                LOGGER.error("Company entity is empty");
            }
            return Collections.emptyList();
        } finally {
            LOGGER.info("Process is finished");
        }
    }

    public List<Employee> findEmployeeNameIsContaining(String name) throws FacadeException{
        LOGGER.info("Process of searching employee name is starting");
        try {
            return employeeDao.getEmployeeNamesIsContaining(name);
        } catch (FacadeException e) {
            LOGGER.error("There was no employee name containing provided letters");
            if(employeeDao.count() == 0) {
                LOGGER.error("Employee entity is empty");
            }
            return Collections.emptyList();
        } finally {
            LOGGER.info("Process is finished");
        }
    }
}
