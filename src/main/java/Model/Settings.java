package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Settings {
    @Id
    private int id;
    private char prefix;

    public Settings(){
        this.prefix = '!';
    }
    
    public Settings(char prefix){
        this.prefix = prefix;
    }
}
