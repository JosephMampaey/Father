package Logica;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MessageParserTest {

    MessageParser mp;

    @BeforeEach
    public void innit(){
        mp = new MessageParser();
    }

    @Test
    public void testMessageCommand(){
        assertTrue(mp.isCommand("!addCommand 12512"));
        assertFalse(mp.isCommand("addCommand"));
    }

    @Test
    public void testMessageGetCommand(){
        assertEquals(mp.getCommandFromString("!Addpoints 125"),"AddPoints");
        assertEquals(mp.getCommandFromString("!AddPoints"),Commands.addGoodPoints);
        assertThrows(IllegalArgumentException.class, () -> mp.getCommandFromString("!azefa"));
    }

    @Test
    public void testMessageGetNumber(){
        assertEquals(mp.getNumberFromCommand("!Addpoints 125"),125);
        assertThrows(IllegalArgumentException.class, () -> mp.getNumberFromCommand("!Addpoints"));
    }

}