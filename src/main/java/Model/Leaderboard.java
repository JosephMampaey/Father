package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Leaderboard {
    private Map<Integer,Person> leaderboard;
    private String serverId;

}
