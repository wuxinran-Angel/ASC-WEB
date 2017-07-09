/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyanlou.photo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tang
 */
public class DBUtils {

    private Connection connection;
    private Statement statement;

    public DBUtils() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://nicdev.cuc.edu.cn:3306/ShiyanlouPhoto?useUnicode=true&characterEncoding=UTF-8&user=ShiyanlouPhoto&password=4f29a73d420fd84d23", "ShiyanlouPhoto", "4f29a73d420fd84d23");
            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList getDetails() {
        ArrayList details = new ArrayList();
        try {
            ResultSet rs = statement.executeQuery("select * from ASC_image");
            while (rs.next()) {
                String item[] = new String[2];
                item[0] = rs.getString(2).trim();
                item[1] = rs.getString(3).trim();
                details.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return details;
    }
    
    public ArrayList getPhotos() {
        ArrayList list = new ArrayList();
        try {
            ResultSet rs = statement.executeQuery("select * from ASC_photo");
            while (rs.next()) {
                String item = new String();
                item = rs.getString(2).trim();
                list.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
