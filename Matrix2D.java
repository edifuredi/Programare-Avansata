/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrix2d;

/**
 *
 * @author user
 */
public class Matrix2D {
//FUREDI EDUARD-ANDREI
    public static void main(String[] args) {
        int n=Integer.parseInt(args[0]);
        String shape=args[1];
        if(n>1000)
        {
            long start=System.nanoTime();
            int tst=0;
            for(int ind=0;ind<=n*n;ind++)
            {
                tst++;//Face O(n^2) pasi
            }
            long end=System.nanoTime();
            long duration=start-end;
            System.out.println(duration+" ns");
        }
        else
        {
            if(shape.equals("rectangle"))
            {
                rectangle(n);
            }
            else
            {
                circle(n);
            }
        }
        
    }
    public static void my_print(int[][] img,int n)
    {
        for(int line=0;line<n;line++)
        {
            for(int col=0;col<n;col++)
            {
                System.out.print(img[line][col]);
            }
            System.out.print("\n");
        }
    }
    public static void rectangle(int n)
    {
        int[][] img;
        img=new int[n][n];
        for(int line=0;line<n;line++)
        {
            for(int col=0;col<n;col++)
            {
                img[line][col]=0;
            }
        }
        for(int i=n/4;i<3*n/4;i++)
        {
            for(int j=n/4;j<3*n/4;j++)
            {
                img[i][j]=1;
            }
        }
        my_print(img,n);
    }
    public static void circle(int n)
    {
        int[][] img;
        img=new int[n][n];
        for(int line=0;line<n;line++)
        {
            for(int col=0;col<n;col++)
            {
                img[line][col]=1;
            }
        }
        int mij=n/2;
        int raza=n/5;
        for(int line=0;line<n;line++)
        {
            for(int col=0;col<n;col++)
            {
                int dx=line-mij;
                int dy=col-mij;
                if(dx*dx+dy*dy<=raza*raza)
                {
                    img[line][col]=0;
                }
            }
        }
        my_print(img,n);
    }
}
