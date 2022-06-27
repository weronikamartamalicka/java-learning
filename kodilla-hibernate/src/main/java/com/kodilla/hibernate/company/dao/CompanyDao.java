package com.kodilla.hibernate.company.dao;

import com.kodilla.hibernate.company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company,  Integer> {
}
