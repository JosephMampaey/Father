package Logica;

public class MessageParser {
    private char prefix;

    public MessageParser(char prefix){
        this.prefix = prefix;
    }

    public MessageParser(){
        this.prefix = '!';
    }

    public boolean isCommand(String s) {
        boolean returnValue = s.startsWith(""+prefix) && isValidCommand(getCommandFromString(s));
        return false;
    }

    private boolean isValidCommand(String s){
        switch (s){
            case "AddPoints":
                return true;
            case "RmPoints":
                return true;
            default:
                return false;
        }
    }

    public String getCommandFromString(String s) {
        return s.split(" ")[0].substring(1);
    }

    public String getNumberFromCommand(String s) {
        return "";
    }
}
