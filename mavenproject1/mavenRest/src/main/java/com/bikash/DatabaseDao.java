package com.bikash;

import java.util.List;

public interface DatabaseDao {

    boolean insertIntoDatabase(DatabasePOJO databasePOJO);

    boolean updateDatabase(DatabasePOJO databasePOJO);

    boolean deleteDatabase(String name);

    List<DatabasePOJO> listDatabase();

    DatabasePOJO getDatabase(String name);

    //DatabasePOJO[] findDatabase(String name);
}
