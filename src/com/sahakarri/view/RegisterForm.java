package com.sahakarri.view;

import com.model.Emp;
import com.sahakariDatabase.connection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by Saurav on 26/03/2017.
 */
public class RegisterForm  extends JPanel{
    public static void main (String[] args) {


        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        JButton button = new JButton("Select");
        JPanel panel = new JPanel(new GridLayout(0, 1));

//        panel.add(combo);
        panel.add(new JLabel("Id :"));
        panel.add(field1);
        panel.add(new JLabel("Name :"));
        panel.add(field2);
        panel.add(new JLabel("Age :"));
        panel.add(field3);
        panel.add(new JLabel("Address :"));
        panel.add(field4);
        panel.add(new JLabel("Contact No:"));
        panel.add(field5);


        Emp employee = new Emp();

        for(int i = 0; i<2 ; i++){

            int result = JOptionPane.showConfirmDialog(null, panel, "Employee Management System",

                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            employee.setId(Integer.parseInt(field1.getText()));

            employee.setName(field2.getText());

            employee.setAge(Integer.parseInt(field3.getText()));

            employee.setAddress(field4.getText());

            employee.setContactno(field5.getText());


            if (result == JOptionPane.OK_OPTION) {

                field1.getText();

                DBConnection dbConnection = new DBConnection();



                //database opeartions

                try {

                    Connection conn = dbConnection.getConnection();

                    Statement stmt = conn.createStatement();

                    String query = " INSERT INTO emp (id,name,age,address,contactno) VALUES (" + employee.getId() + ",'" + employee.getName() + "'," + employee.getAge() + ",'" + employee.getAddress() +"'," + employee.getContactno() +") ";

                    stmt.executeUpdate(query);

                    dbConnection.closeConnection(conn);

                    System.out.println("Successful Insertion");

                }catch(Exception e){

                    System.out.println("Failed Insertion");

                }



                //ask for more insertion

                int dialogButton = JOptionPane.YES_NO_OPTION;

                int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save More?","Warning",dialogButton);

                if(dialogResult == JOptionPane.YES_OPTION){

                    field1.setText("");

                    field2.setText("");

                    field3.setText("");

                    field4.setText("");

                    field5.setText("");

                } else{

                    break;

                }

                //ask for more insertion

                //database opeartions

            } else {

                System.out.println("Cancelled");
            }
        }
    }


}