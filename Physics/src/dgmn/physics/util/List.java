/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgmn.physics.util;

/**
 *
 * @author dgmneto
 */
public class List<T> {
    private T object;
    private List<T> next;
    
    public List(T object){
        this.object = object;
        next = null;
    }
    
    public List(){
        this(null);
    }
    
    public void add(T object){
        if(this.object == null){
            this.object = object;
        } else if(next != null){
            this.next.add(object);
        } else {
            next = new List<>(object);
        }
    }
    
    public boolean contains(T object){
        if(this.object != null && object.equals(this.object)){
            return true;
        } else if(next != null){
            return next.contains(object);
        } else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return toString(0);
    }
    
    private String toString(int index){
        if(next == null){
            if(object == null){
                return "";
            } else {
                return index + " - [" + object.toString() + "]";
            }
        } else {
            if(object == null){
                return next.toString(index);
            } else {
                return index + " - [" + object.toString() + "]\n" 
                        + next.toString(index + 1);
            }
        }
    }
    
    public int lenght(){
        if(next == null){
            if(object == null){
                return 0;
            } else {
                return 1;
            }
        } else {
            if(object == null){
                return next.lenght();
            } else {
                return next.lenght() + 1;
            }
        }
    }
}
