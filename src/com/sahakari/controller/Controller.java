package com.sahakari.controller;

import com.sahakariDatabase.connection.DBConnection;

import javax.swing.*;

/**
 * Created by Saurav on 28/05/2017.
 */
public class Controller {

    DBConnection dbConnection = new DBConnection();

    public static String getFullText(JTextField field1,JTextField field2, JTextField field3, JTextField field4, JTextField field5 ){
        return  field1.getText() + field2.getText() + field3.getText() + field4.getText() + field5.getText() ;
    }

}
