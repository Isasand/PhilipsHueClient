/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philipshue;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Isa
 */
public class Enviroment {
    List<Light> lights = new ArrayList(); 
    LightsHandler lightshandler = new LightsHandler(); 
    
    public Enviroment(){
        
    }
    
    public void setLamps() throws ProtocolException, JSONException, IOException{
        lights = lightshandler.getLights(); 
    }
    
    public void printEnviroment(){
        System.out.println("LIGHTS:");
        for (Light light : lights){
            light.printInfo(); 
        }
    }
    
    public static void main(String[] args){
        Enviroment env = new Enviroment(); 
        try { 
            env.setLamps();
        } catch (JSONException ex) {
            Logger.getLogger(Enviroment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Enviroment.class.getName()).log(Level.SEVERE, null, ex);
        }
        env.printEnviroment(); 
    }
}
