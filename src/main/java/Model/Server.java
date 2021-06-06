package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.*;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Server {
    @Id
    private int id;
    private String guildId;
    @OneToMany
    private List<Person> members = new ArrayList<Person>();
    @OneToOne
    private Settings serverSetting;

    public Server(String guildId){
        this.guildId = guildId;
        this.serverSetting = new Settings();
    }

    public void addMember(Person person){
        members.add(person);
    }
}
