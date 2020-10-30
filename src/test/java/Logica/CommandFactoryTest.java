package Logica;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {
    CommandFactory commandFactory;
    @BeforeEach
    public void innit(){
        commandFactory = new CommandFactory();
    }

    @Test
    public void testAddPoints(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("1","1","TestPerson1"));
        personList.add(new Person("2","1","TestPerson2"));
        personList.add(new Person("3","1","TestPerson3"));

        personList = commandFactory.AddPoints(personList,1);

        for (Person person: personList) {
            assertTrue(person.getPoints() == 1);
        }
    }

    @Test
    public void testRmPoints(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("1","1","TestPerson1"));
        personList.add(new Person("2","1","TestPerson2"));
        personList.add(new Person("3","1","TestPerson3"));

        List<Person> personListCopy = commandFactory.removePoints(personList, 1);

        for(int i = 0; i < personList.size();i++){
            assertTrue(personList.get(i).getPoints() - 1 == personListCopy.get(i).getPoints());
        }
    }

}