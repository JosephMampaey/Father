package Logica;

public class Person {
    //TODO add rights
    //TODO problem same person in multiple discord servers? -> keep record of the serverId store the persons per guild in a file (Dictionary of guilds -> Dictionary of members)
    private int points = 0;
    private final String discordId;
    private final String guildId;
    private String nickName;
    private Gender gender;

    public Person(String id, String guildId, String name){
        this.discordId = id;
        this.nickName = name;
        this.guildId = guildId;
    }

    public void RemovePoint(){
        points--;
    }

    public  void RemovePoint(int ammountOfPoints){
        points -= ammountOfPoints;
    }

    public  void AddPoint(){
        points++;
    }

    public  void AddPoint(int ammountOfPoints){
        points += ammountOfPoints;
    }

    public int getPoints(){
        return points;
    }
    
    public void setPoints(int ammountOfPoints){
        points = ammountOfPoints;
    }
    
    public String getNickname(){
        return nickName;
    }

    public Gender getGender(){
        return gender;
    }

    public String getDiscordId(){ return discordId;}

    public void setGender(Gender gender){
        this.gender = gender;
    }
}


