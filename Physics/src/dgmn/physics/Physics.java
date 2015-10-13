/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import dgmn.physics.util.Util;

/**
 *
 * @author dgmneto
 */

public class Physics {
    public static PrintWriter out;
    
    public static void print(String strg) throws IOException{
        if(out == null){
            out = new PrintWriter(new BufferedWriter(new FileWriter(Util.getValidName("result", ".txt"), true)));
        }
        
        out.println(strg);
    }
    
    public static void walkEverything(int steps, Walk begginWalk) throws IOException{
        if(steps == 0 || !begginWalk.toBeContinued()){
            print(begginWalk.getBody().steps() + " " + begginWalk.getBody().getSquareDistance(0, 0));
            
            System.out.println("concluido");
        } else {
            ArrayList<Integer> validSteps = begginWalk.getBody().validSteps();
            
            for(int i = 0; i < validSteps.size(); i++){
                Walk nextWalk = begginWalk.clone();
                nextWalk.walk(validSteps.get(i));
                
                walkEverything(steps - 1, nextWalk);
            }
        }
    }
    
    public static void main(String[] args) {
        
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Util.getValidName("result", ".txt"), true)));
            
            for(int i = 10; i <= 10000; i += 5){
                int iterations = 1000010 - i;
                
                System.out.println("[" + i + "]");
            
                for(int j = 0; j < iterations; j++){
                    Body object = new Body();
                    Random random = new Random();

                    for(int k = 0;k < i && object.ExistValidStep(); k++)
                    {
                        ArrayList<Integer> validDirections = object.validSteps();
                        
                        int direction = validDirections.get(random.nextInt(validDirections.size()));

                        object.walk(direction);
                    }
                    
                    String saida = object.steps() + "   " + object.getSquareDistance(0, 0);
                    
                    out.println(saida);
                    //System.out.println("[" + i + "]" + j + "/" + iterations + ":" + saida);
                }
            }
            /*
            walkEverything(14, new Walk());
            */
        } catch (Exception ex) {
            Logger.getLogger(Physics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
