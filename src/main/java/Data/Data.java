/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logica.Person;
import Logica.Server;
import java.util.Dictionary;
import java.util.Enumeration;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jef
 */
public class Data {
    
    public Data(){
        
    }
    
    public Dictionary<String, Server> ReadDiscordServer(){
        return null;
    }
    
    public void SaveDiscordServer(Server server){
        ServerToJSON(server);
    }
    
    private JSONObject ServerToJSON(Server server){
        JSONObject serverJSON = new JSONObject();
        serverJSON.put("ID",server.getGuildId());
        JSONArray members = new JSONArray();
        
        Dictionary<String, Person> membersList = server.getMembers();
        Enumeration keys = membersList.keys(); 
        
        while (keys.hasMoreElements()) { 
            System.out.println(keys.nextElement()); 
        } 
        
        return null;
    }
    
}
