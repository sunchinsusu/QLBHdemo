/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Custom
 */
public class DAO {
    private static String dbURL="jdbc:mysql://localhost:3306/qlbhdemo?autoReconnect=true&useSSL=false";
    private static String username = "root";
    private static String password = "12345678";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dbURL, username, password);
    }
}
