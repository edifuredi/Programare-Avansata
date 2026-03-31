/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab6;

/**
 *
 * @author user
 */
public class Lab6 {
    public static void main(String[] args) {
        try {
            GenreDAO g = new GenreDAO();
            ActorDAO a = new ActorDAO();
            MovieDAO m = new MovieDAO();

            g.create("Action");
            int genreId = g.findByName("Action");

            a.create("Chuck Norris");
            int actorId = a.findByName("Chuck Norris");

            m.create("Walker Texas Ranger", genreId);

            System.out.println("DONE");
            Report.generate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
