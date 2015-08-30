/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics;

/**
 *
 * @author dgmneto
 */
public class Coordinates {
    private int i, j;
    
    public Coordinates(int i, int j){
        this.i = i;
        this.j = j;
    }
    
    public Coordinates(){
        this(0, 0);
    }
    
    @Override
    public boolean equals(Object object){
        boolean resposta = false;
        
        if(object instanceof Coordinates){
            Coordinates novo = (Coordinates)object;
            
            if(novo.i == i && novo.j == j){
                resposta = true;
            }
        }
        
        return resposta;
    }
    
    @Override
    public String toString(){
        return "i: " + i + " j: " + j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
