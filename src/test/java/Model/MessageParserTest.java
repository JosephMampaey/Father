package Model;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class MessageParserTest {

    MessageParser mp;
    MessageParser mp2;

    @BeforeEach
    public void innit(){
        mp = new MessageParser();
        mp2 = new MessageParser('?');
    }

    @Test
    public void testMessageCommand(){
        assertTrue(mp.isCommand("!addPoints 12"));
        assertTrue(mp.isCommand("!rmPoints 12"));
        assertTrue(mp2.isCommand("?addPoints 12"));
        assertTrue(mp2.isCommand("?rmPoints 12"));

        assertFalse(mp.isCommand("addCommand"));
        assertFalse(mp.isCommand("addCommand 2"));
        assertFalse(mp.isCommand("!test"));
        assertFalse(mp.isCommand("test!"));
        assertFalse(mp2.isCommand("!addPoints 12"));
        assertFalse(mp.isCommand("?addPoints 12"));
    }

    @Test
    public void testMessageGetCommand(){
        assertEquals(mp.getCommandFromString("!addPoints 125"),"AddPoints");
        assertEquals(mp.getCommandFromString("!addPoints"),Commands.addGoodPoints);
        assertThrows(IllegalArgumentException.class, () -> mp.getCommandFromString("!azefa"));
    }

    @Test
    public void testMessageGetNumber(){
        assertEquals(mp.getNumberFromCommand("!addPoints 125"),125);
        assertThrows(IllegalArgumentException.class, () -> mp.getNumberFromCommand("!addPoints"));
    }

}