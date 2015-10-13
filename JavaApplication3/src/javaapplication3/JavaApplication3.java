/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Scanner;

/**
 *
 * @author dgmneto
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double a, b, sum_x = 0, sum_y = 0, sum_xy = 0, sum_x2 = 0;
        
        long n = 1;
        
       
        a = scan.nextDouble();
        b = scan.nextDouble();
        
        while(a != -1 || b != -1){
            sum_x += a;
            sum_y += b;
            sum_xy += a*b;
            sum_x2 += a*a;
            
            a = scan.nextDouble();
            b = scan.nextDouble();
            n += 1;
        }
        
        System.out.println(sum_x + " " + sum_y + " " + sum_xy + " " + sum_x2 + " " + n);
    }
    
}
