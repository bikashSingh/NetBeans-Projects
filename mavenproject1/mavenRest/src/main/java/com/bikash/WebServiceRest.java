/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikash;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/database")
public class WebServiceRest {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "hekkkllklklklak";
    }

    
    @GET
    @Path("/records")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DatabasePOJO> getRecords() {

        DatabaseDaoImpl databaseDaoImpl = new DatabaseDaoImpl();
        return databaseDaoImpl.listDatabase();

    }
    @POST
    @Path("/insert")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public boolean insertRecord(DatabasePOJO databasePOJO)
    {
        DatabaseDaoImpl databaseDaoImpl = new DatabaseDaoImpl();
        return databaseDaoImpl.insertIntoDatabase(databasePOJO);
    }
    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateRecord(DatabasePOJO databasePOJO)
    {
        DatabaseDaoImpl databaseDaoImpl = new DatabaseDaoImpl();
        
        return databaseDaoImpl.updateDatabase(databasePOJO);
    }
    @DELETE
    @Path("/delete/{name}")    
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateRecord(@PathParam("name")String name)
    {
        DatabaseDaoImpl databaseDaoImpl = new DatabaseDaoImpl();
        return databaseDaoImpl.deleteDatabase(name);
    }
    @GET
    @Path("/record/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DatabasePOJO getRecord(@PathParam("name")String name)
    {
        DatabaseDaoImpl databaseDaoImpl = new DatabaseDaoImpl();
        return databaseDaoImpl.getDatabase(name);
    }
    
//    public List<Map<String, Object>> getMsg() throws Exception {
//        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
//        Connection con = connectToDatabase.getConnection();
//        String query = "select * from salesjan";
//        DatabaseReader db = new DatabaseReader();
//        ResultSet resultSet = db.fetchRecordsFromDB((new ConnectToDatabase()).getConnection());
//        resultSet.next();
//        List<Map<String, Object>> listOfMaps = null;
//        try {
//            QueryRunner queryRunner = new QueryRunner();
//            listOfMaps = queryRunner.query(con, query, new MapListHandler());
//        } catch (SQLException se) {
//            throw new RuntimeException("Couldn't query the database.", se);
//        }
//        return listOfMaps;
//}
}
