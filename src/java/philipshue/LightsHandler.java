/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philipshue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*; 

/**
 *
 * @author Isa
 */
public class LightsHandler {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException, JSONException {
        
    }
    
    public List<Light> getLights() throws MalformedURLException, ProtocolException, JSONException, IOException{
        URL url = new URL("http://192.168.0.109/api/TkF6jW5Ky6KiOKNHQ5HCcuN0FVns-Pvuyq9o3fnz");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        
        List<Light> lights = new ArrayList(); 
        JSONObject obj = new JSONObject(content.toString());
        System.out.println(obj.length());
        for(int i = 1; i<obj.length(); i++){
            String index = Integer.toString(i);
            String reachable =  obj.getJSONObject("lights").getJSONObject(index).getJSONObject("state").getString("reachable"); 
            String colormode = "no color mode"; 
            String type =  obj.getJSONObject("lights").getJSONObject(index).getString("type");
            if("Extended color light".equals(type) ){
                colormode = obj.getJSONObject("lights").getJSONObject(index).getJSONObject("state").getString("colormode"); 
            }
            String lastupdate = obj.getJSONObject("lights").getJSONObject(index).getJSONObject("swupdate").getString("lastinstall"); 
            
            String state = obj.getJSONObject("lights").getJSONObject(index).getJSONObject("state").getString("on"); 
            String name = obj.getJSONObject("lights").getJSONObject(index).getString("name");
            String modelid = obj.getJSONObject("lights").getJSONObject(index).getString("modelid");
            Light light = new Light((Boolean.valueOf(state)), colormode, (Boolean.valueOf(reachable)), lastupdate, type, name, modelid); 
            lights.add(light); 
        } 
        return lights; 
    }
    
}
