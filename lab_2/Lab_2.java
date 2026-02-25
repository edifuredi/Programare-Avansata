package com.mycompany.lab_2;


/**
 *
 * @author user
 */
public class Lab_2 {

    public static void main(String[] args) {
       Location l1=new Location("EDI","bloc",0,1);
       Location l2=new Location("ALEX","casa",5,4);
       Road R=new Road("R1","autostrada",50,l1,l2);
       System.out.println(R);
       System.out.println(l1);
    }

}
