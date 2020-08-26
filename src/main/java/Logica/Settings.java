package Logica;

public class Settings {
    //TODO probably save it into a json file with guild id, permission roles, Prefix
    
    private String guildId;
    private char prefix;
    
    public Settings(String guildId, char prefix){
        this.guildId = guildId;
        this.prefix = prefix;
    }
}
