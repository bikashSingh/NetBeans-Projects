package dao;

import model.CompanyMast;

public interface CompanyMastDao {

    boolean insertIntoCompanyMast(CompanyMast companyMast);

    boolean updateCompanyMast(CompanyMast companyMast);

    boolean deleteCompanyMast(CompanyMast companyMast);

    CompanyMast[] listCompanyMast();

    CompanyMast getCompanyMast(int comId);

    CompanyMast[] findCompanyMast(String comName);
}