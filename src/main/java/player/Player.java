package palyer;

public class Player {
    private String name;
    private char symbol; //'X' Atau 'O'
    
    public Player (String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName (){
        return name;
    }
    public char getSymbol (){
        return symbol;
    }
}