/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab9;

/**
 *
 * @author user
 */
public class Lab9 {

    public static void main(String[] args) {
        Maze maze = new Maze(10);
        GameState state = new GameState();
        SharedMemory memory = new SharedMemory();

        Bunny bunny = new Bunny(new Position(0, 0), maze, state);

        Robot[] robots = new Robot[3];
        robots[0] = new Robot(new Position(5, 5), maze, bunny, state, memory);
        robots[1] = new Robot(new Position(2, 7), maze, bunny, state, memory);
        robots[2] = new Robot(new Position(8, 3), maze, bunny, state, memory);

        GameManager manager = new GameManager(maze, bunny, robots, state);
        CommandListener commands = new CommandListener(bunny, robots);
        new MazeGUI(maze, bunny, robots);

        bunny.start();
        for (Robot r : robots) r.start();
        manager.start();
        commands.start();
    }
}
