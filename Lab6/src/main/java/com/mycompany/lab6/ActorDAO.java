/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author user
 */
public class ActorDAO {

    public void create(String name) throws Exception {
        Connection con = Database.getConnection();
        PreparedStatement stmt =
            con.prepareStatement("INSERT INTO actors(name) VALUES (?)");

        stmt.setString(1, name);
        stmt.executeUpdate();
    }

    public Integer findByName(String name) throws Exception {
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(
            "SELECT id FROM actors WHERE name='" + name + "'");

        return rs.next() ? rs.getInt(1) : null;
    }
}