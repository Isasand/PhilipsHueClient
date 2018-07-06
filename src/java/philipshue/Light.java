/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philipshue;

/**
 *
 * @author Isa
 */
public class Light {
    Boolean state;// = true; 
    String colormode;// = "xy"; 
    Boolean reachable; //  = true; 
    String lastupdate; // = "2017-12-21T22:10:02"; 
    String type; // = "Extended color light" ;
    String name; // = "sovrummet"; 
    String modelid; //  = "LCT010"; 
    
    public Light(Boolean state, String colormode, Boolean reachable, String lastupdate, String type, String name, String modelid){
        this.state = state; 
        this.colormode = colormode; 
        this.reachable = reachable; 
        this.lastupdate = lastupdate; 
        this.type = type; 
        this.name = name; 
        this.modelid = modelid;
    }
    
    public void printInfo(){
        System.out.println("Name: " + this.name); 
        System.out.println("Type: " + this.type); 
        System.out.println("State: " + this.state);
        System.out.println("Reachable: " + this.reachable); 
        System.out.println("Colormode: " + this.colormode); 
        System.out.println("Last update install: " + this.lastupdate); 
        System.out.println("Model id: " + this.modelid);
    }
    
}
