/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.edi_1;

/**
 *
 * @author user
 */
public class Edi_1 {

    public static void main(String[] args) {
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n=(int) (Math.random() * 1000000);
        n*=3;
        n+=0b10101;
        n+=0xFF;
        n*=6;
        if(n%9==0)
        {
            n=9;
        }
        else
        {
            n=n%9;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
