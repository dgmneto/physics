/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics;

import java.util.ArrayList;
import java.util.Iterator;

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
    private ArrayList<Coordinates> previousSteps;
    
    public Body(){
        actualPosition = new Coordinates();
        previousSteps =  new ArrayList<>();
    }
    
    public int getSquareDistance(int i, int j){
        return actualPosition.getSquareDistance(i, j);
    }
    
    public void walk(int direction){
        previousSteps.add(actualPosition.clone());
        
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
    
    public ArrayList<Integer> validSteps(){
        ArrayList<Integer> resposta = new ArrayList<>();
        
        Coordinates up = new Coordinates(actualPosition.getI() + 1, actualPosition.getJ());
        if(!previousSteps.contains(up)){
            resposta.add(UP);
        }
        
        Coordinates right = new Coordinates(actualPosition.getI(), actualPosition.getJ() + 1);
        if(!previousSteps.contains(right)){
            resposta.add(RIGHT);
        }
        
        Coordinates down = new Coordinates(actualPosition.getI() - 1, actualPosition.getJ());
        if(!previousSteps.contains(down)){
            resposta.add(DOWN);
        }
        
        Coordinates left = new Coordinates(actualPosition.getI(), actualPosition.getJ() - 1);
        if(!previousSteps.contains(left)){
            resposta.add(LEFT);
        }
        
        return resposta;
    }
    
    public boolean ExistValidStep(){
        return !validSteps().isEmpty();
    }
    
    public int steps(){
        return previousSteps.size();
    }

    public Coordinates getActualPosition() {
        return actualPosition;
    }
    
    private boolean validStep(Coordinates coordinates){
        for(Iterator<Coordinates> it = previousSteps.iterator(); it.hasNext();){
            Coordinates actual = it.next();
            
            if(actual.getI() == coordinates.getI() & actual.getJ() == actual.getJ()){
                return false;
            }
        }
        
        return true;
    }

    public ArrayList<Coordinates> getPreviousSteps() {
        return previousSteps;
    }
}