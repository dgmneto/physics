/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics;

import java.util.ArrayList;

/**
 *
 * @author dgmneto
 */
public class Walk {
    private Body body;
    
    public Walk(){
        body = new Body();
    }
    
    public boolean toBeContinued(){
        return body.validSteps().size() > 0;
    }
    
    public ArrayList<Integer> validSteps(){
        return body.validSteps();
    }
    
    public void walk(int direction){
        if(direction <= 3 && direction >= 0 && body.validSteps().contains(direction)){
            body.walk(direction);
        }
    }
    
    @Override
    public Walk clone(){
        Walk copy = new Walk();
        
        copy.getBody().getActualPosition().setI(body.getActualPosition().getI());
        copy.getBody().getActualPosition().setJ(body.getActualPosition().getJ());
        
        for(int i = 0; i < body.getPreviousSteps().size(); i++){
            copy.getBody().getPreviousSteps().add(new Coordinates(body.getPreviousSteps().get(i).getI(), body.getPreviousSteps().get(i).getJ()));
        }
        
        return copy;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
