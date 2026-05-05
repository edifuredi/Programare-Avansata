/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

/**
 *
 * @author user
 */
import java.util.Scanner;

public class CommandListener extends Thread {
    private Bunny bunny;
    private Robot[] robots;

    public CommandListener(Bunny bunny, Robot[] robots) {
        this.bunny = bunny;
        this.robots = robots;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String cmd = sc.nextLine();

            if (cmd.equals("slow")) {
                bunny.setDelay(1000);
                for (Robot r : robots) r.setDelay(1000);
            }

            if (cmd.equals("fast")) {
                bunny.setDelay(200);
                for (Robot r : robots) r.setDelay(200);
            }
        }
    }
}
