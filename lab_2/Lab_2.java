package com.mycompany.lab_2;


/**
 *
 * @author user
 */
public class Lab_2 {

    public static void main(String[] args) {
       
    Location a1 = new Airport(150, "JFK", "AIRPORT", 10, 15);
    Location a2 = new Airport(151, "Heathrow", "AIRPORT", 25, 40);
    Location a3 = new Airport(152, "Otopeni", "AIRPORT", 12, 18);
    Location a4 = new Airport(153, "Schiphol", "AIRPORT", 30, 22);

    Location c1 = new City(2000, "Iasi", "City", 8, 9);
    Location c2 = new City(2100, "Bucuresti", "City", 14, 16);
    Location c3 = new City(2200, "Cluj-Napoca", "City", 28, 35);
    Location c4 = new City(2300, "Timisoara", "City", 5, 30);
    Location c5 = new City(2400, "Brasov", "City", 20, 12);
    Location c6 = new City(2500, "Constanta", "City", 40, 10);


    Road r1 = new Road("A1", RoadType.HIGHWAY, 100, a1, c1);
    Road r2 = new Road("A2", RoadType.HIGHWAY, 220, c2, c6);
    Road r3 = new Road("DN1", RoadType.COUNTRY, 160, c2, c5);
    Road r4 = new Road("E60", RoadType.COUNTRY, 280, c3, c1);
    Road r5 = new Road("Link-OTP", RoadType.EXPRESS, 18, a3, c2);
       
    Problem prob= new Problem();

    prob.addLocation(a1);
    prob.addLocation(a2);
    prob.addLocation(a3);
    prob.addLocation(a4);
    prob.addLocation(c1);
    prob.addLocation(c2);
    prob.addLocation(c3);
    prob.addLocation(c4);
    prob.addLocation(c5);
    prob.addLocation(c6);
    prob.addRoad(r1);
    prob.addRoad(r2);
    prob.addRoad(r3);
    prob.addRoad(r4);
    prob.addRoad(r5);
    
    Solution sol=new Solution(prob,a3,c6);
    if(prob.isPossible(a3,c6))
    {
        sol.dijkstra();
        System.out.println(sol);
    }
    }
}
