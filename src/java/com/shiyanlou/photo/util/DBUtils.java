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
        int random = (int) (Math.random() * 10);
        String id3 = "00" + Integer.toString(random);
        String id6 = "00" + Integer.toString(9 - random);
        String id2 = "10" + Integer.toString(random);
        String id5 = "10" + Integer.toString(9 - random);
        String id1 = "20" + Integer.toString(random);
        String id4 = "20" + Integer.toString(9 - random);
        try {
            ResultSet rs1 = statement.executeQuery("select * from ASC_image where id = '" + id1 + "'");
            while (rs1.next()) {
                String item1[] = new String[2];
                item1[0] = rs1.getString(2).trim();
                item1[1] = rs1.getString(3).trim();
                details.add(item1);
            }
            ResultSet rs2 = statement.executeQuery("select * from ASC_image where id = '" + id2 + "'");
            while (rs2.next()) {
                String item2[] = new String[2];
                item2[0] = rs2.getString(2).trim();
                item2[1] = rs2.getString(3).trim();
                details.add(item2);
            }
            ResultSet rs3 = statement.executeQuery("select * from ASC_image where id = '" + id3 + "'");
            while (rs3.next()) {
                String item3[] = new String[2];
                item3[0] = rs3.getString(2).trim();
                item3[1] = rs3.getString(3).trim();
                details.add(item3);
            }
            ResultSet rs4 = statement.executeQuery("select * from ASC_image where id = '" + id4 + "'");
            while (rs4.next()) {
                String item4[] = new String[2];
                item4[0] = rs4.getString(2).trim();
                item4[1] = rs4.getString(3).trim();
                details.add(item4);
            }
            ResultSet rs5 = statement.executeQuery("select * from ASC_image where id = '" + id5 + "'");
            while (rs5.next()) {
                String item5[] = new String[2];
                item5[0] = rs5.getString(2).trim();
                item5[1] = rs5.getString(3).trim();
                details.add(item5);
            }
            ResultSet rs6 = statement.executeQuery("select * from ASC_image where id = '" + id6 + "'");
            while (rs6.next()) {
                String item6[] = new String[2];
                item6[0] = rs6.getString(2).trim();
                item6[1] = rs6.getString(3).trim();
                details.add(item6);
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
