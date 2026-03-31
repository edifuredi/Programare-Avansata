/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author user
 */
public class MovieDAO {

    public void create(String title, int genreId) throws Exception {
        Connection con = Database.getConnection();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO movies(title, genre_id) VALUES (?, ?)");

        stmt.setString(1, title);
        stmt.setInt(2, genreId);

        stmt.executeUpdate();
    }

    public void addActor(int movieId, int actorId) throws Exception {
        Connection con = Database.getConnection();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO movie_actors(movie_id, actor_id) VALUES (?, ?)");

        stmt.setInt(1, movieId);
        stmt.setInt(2, actorId);

        stmt.executeUpdate();
    }
}
