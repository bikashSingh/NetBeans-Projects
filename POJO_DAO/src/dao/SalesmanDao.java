package dao;

import model.Salesman;

public interface SalesmanDao {

    boolean insertIntoSalesman(Salesman salesman);

    boolean updateSalesman(Salesman salesman);

    boolean deleteSalesman(Salesman salesman);

    Salesman[] listSalesman();

    Salesman getSalesman(int salesmanId);

    Salesman[] findSalesman(String name);
}
