package com.kodilla.hibernate.company;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NamedNativeQuery(
        name = "Company.getCompanyNamesStartingWith",
        query = "SELECT * FROM COMPANIES WHERE SUBSTRING(COMPANY_NAME, 1, 3) = :LETTERS",
        resultClass = Company.class
)

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employeeList = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listOfCompanies")
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Company)) return false;
        Company company = (Company) o;
        return getId() == company.getId() && getName().equals(company.getName()) && getEmployeeList().equals(company.getEmployeeList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmployeeList());
    }
}
