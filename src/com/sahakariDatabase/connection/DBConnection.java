package com.sahakariDatabase.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Saurav on 26/03/2017.
 */
public class DBConnection {


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sahakarisanstha", "root", "");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
            return null;
        }

    }

    public void closeConnection(Connection con){
        try{
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}