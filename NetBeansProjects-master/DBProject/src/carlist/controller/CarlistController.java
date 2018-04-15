package carlist.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import carlist.db.ConnectionManager;
import carlist.model.Carlist;

public class CarlistController {

    private Connection con;

    public CarlistController(String username, String password) throws SQLException, ClassNotFoundException {
        String url = "jdbc:derby://localhost:1527/carlist";
        con = ConnectionManager.createConnection(url, username, password);
        System.out.println("Connection created Succesfully");
    }

    public void closeCarListConnection() throws SQLException {
        ConnectionManager.closeConnection(con);
        System.out.println("Close Connection Succesfully");
    }

    public void creatCarListTable() throws SQLException {
        String sql = "create table carlist"
                + "(carownername varchar(50),"
                + "carbrand varchar(50),"
                + "carcolour varchar(50),"
                + "cartype varchar(50),"
                + "carprice Double,"
                + "carproblem varchar(50),"
                + " primary key(carownername))";
        System.out.println(sql);
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        System.out.println("Create table carlist successfully");
    }
//    public void dropCarListTable() throws SQLException {
//        String sql = "drop table carlist";
//        System.out.println(sql);
//        Statement stmt = con.createStatement();
//        stmt.execute(sql);
//        System.out.println("Drop table carlist successfully");
//    }
    public int insertCarlist(Carlist carlist) throws SQLException {
        int insertedRec = 0;
//        String carownername = carlist.getCarownerName();
//        String carbrand = carlist.getCarBrand();
//        String carcolour = carlist.getCarColour();
//        String cartype = carlist.getCarType();
//        String carprice = carlist.getCarownerName();
//        String carproblem = carlist.getCarownerName();
        String sql = "insert into carlist (" +"carownername,carbrand,carcolour,cartype,carprice,carproblem) values('"
                + carlist.getCarownerName() + "','" + carlist.getCarBrand() + "','" + carlist.getCarColour() + "','" + carlist.getCarType() + "'," + carlist.getCarPrice() + ",'" + carlist.getCarproblem() + "')";
        Statement stmt = con.createStatement();
        insertedRec = stmt.executeUpdate(sql);
        System.out.println(insertedRec + " insert product successfully");
        return insertedRec;
    }

    public int updateCarlist(Carlist carlist) throws SQLException {
        //int updatedRec;
        String sql = "UPDATE carlist set carbrand='"+carlist.getCarBrand()+"',carcolour='"+carlist.getCarColour()+"',cartype='"+carlist.getCarType()+"',carprice="+carlist.getCarPrice()+",carproblem='"+carlist.getCarproblem()+"'"
                + " WHERE carownername='"+carlist.getCarownerName()+"'";
        Statement stmt = con.createStatement();
        int updatedRec = stmt.executeUpdate(sql);
        System.out.println(updatedRec + " update product successfully");
        return updatedRec;
    }

    public int deleteCarList() throws SQLException {
        int deletedRecs = 0;
        String sql = "delete from carlist";
        Statement stmt = con.createStatement();
        deletedRecs = stmt.executeUpdate(sql);
        return deletedRecs;
    }

    public int deleteCarlist(String name) throws SQLException {
        int deletedRecs = 0;
        String sql = "delete from carlist where carownername='" + name + "'";
        Statement stmt = con.createStatement();
        deletedRecs = stmt.executeUpdate(sql);
        return deletedRecs;
    }

    public void findCarlistKeyword(String keyword, String word) throws SQLException {
        ArrayList<Carlist> carlist = new ArrayList<Carlist>();
        String sql = "SELECT * FROM carlist WHERE " + keyword + " LIKE '" + word + "%'";
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            String carownerName = resultSet.getString("carownername");
            String carBrand = resultSet.getString("carbrand");
            String carColour = resultSet.getString("carcolour");
            String carType = resultSet.getString("cartype");
            double carPrice = resultSet.getDouble("carprice");
            String carProblem = resultSet.getString("carproblem");
            Carlist cl = new Carlist(carownerName, carBrand, carColour, carType, carPrice, carProblem);
            carlist.add(cl);
        }
        System.out.println("Result:");
        for (Carlist stu : carlist) {
            System.out.println(stu);
        }
    }

    public void findAllCarlist() throws SQLException {
        ArrayList <Carlist> carlist = new ArrayList <Carlist>();
        String sql = "SELECT * FROM carlist";
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            String carownerName = resultSet.getString("carownername");
            String carBrand = resultSet.getString("carbrand");
            String carColour = resultSet.getString("carcolour");
            String carType = resultSet.getString("cartype");
            double carPrice = resultSet.getDouble("carprice");
            String carProblem = resultSet.getString("carproblem");
            Carlist cl = new Carlist(carownerName, carBrand, carColour, carType, carPrice, carProblem);
            carlist.add(cl);
        }
        System.out.println("Result:");
        for (int i = 0; i < carlist.size(); i++) {
            System.out.println(carlist.get(i));
        }
    }

}
