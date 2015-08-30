/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics;

import dgmn.physics.util.List;

/**
 *
 * @author dgmneto
 */
public class Body {
    
    public final int UP = 0;
    public final int RIGHT = 1;
    public final int DOWN = 2;
    public final int LEFT = 3;
    
    private Coordinates actualPosition;
    private List<Coordinates> previousSteps;
    
    public Body(){
        actualPosition = new Coordinates();
        previousSteps =  new List<>(actualPosition);
    }
    
    public void walk(int direction){
        switch(direction){
            case UP:
                actualPosition.setI(actualPosition.getI() + 1);
                break;
            case RIGHT:
                actualPosition.setJ(actualPosition.getJ() + 1);
                break;
            case DOWN:
                actualPosition.setI(actualPosition.getI() - 1);
                break;
            case LEFT:
                actualPosition.setJ(actualPosition.getJ() - 1);
                break;
        }
    }
    
    public boolean[] validSteps(){
        boolean[] resposta = new boolean[4];
        
        Coordinates up = new Coordinates(actualPosition.getI() + 1
                , actualPosition.getJ());
        resposta[0] = !previousSteps.contains(up);
        
        Coordinates right = new Coordinates(actualPosition.getI()
                , actualPosition.getJ() + 1);
        resposta[1] = !previousSteps.contains(right);
        
        Coordinates down = new Coordinates(actualPosition.getI() - 1
                , actualPosition.getJ());
        resposta[2] = !previousSteps.contains(down);
        
        Coordinates left = new Coordinates(actualPosition.getI()
                , actualPosition.getJ() - 1);
        resposta[3] = !previousSteps.contains(left);
        
        return resposta;
    }
    
    public int steps(){
        return previousSteps.lenght();
    }
    
    public String toString(){
        return 
            "Actual Position:\n" 
                + "\ti: " + actualPosition.getI() 
                + "\n\tj: " + actualPosition.getJ()
            + "\n\nTotal Steps: " + previousSteps.lenght()
            + "\n\nPrevious Steps:\n"
            + previousSteps.toString();
    }
}
