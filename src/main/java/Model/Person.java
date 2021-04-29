package model;

import model.Enums.Gender;
import model.Enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Person {

    @Id
    private int  id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private int points = 0;
    private final String discordId;
    private String nickName;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Person(String id, String guildId, String name){
        this.discordId = id;
        this.nickName = name;
        this.role = Role.member;
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

    @Override
    public String toString(){
        return "id: " + discordId + " Name: " + nickName;
    }
}


