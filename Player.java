
import java.util.Scanner;

public class Player
{
    String playerName; //name of the player or computer AI
	Score playerScore; //score (win , lose or tie)
    Scanner _keyboard;

	public Player(Scanner keyboard){  //constructor will get the name and initialize the score to 0
        _keyboard=keyboard;
        playerName = getName(); // recives input from the keyboard and stores the player's name
        playerScore= new Score(); // initalises the score when the player is created
    }
    public Player(String _pName){  //constructor will get the name and initialize the score to 0
       
        playerName = _pName; //  player's name
        playerScore= new Score(); // initalises the score when the player is created
    }
    
    public Player(){
        playerName  = "Computer"; // sets up the computer
        playerScore = new Score(); // initialises the score of the computer
    }
    private String getName()
    // Gets the name of the player between the constraints of  5 to 20 characters
    {
   
	// create a scanner object for keybord input
        
        System.out.print("Enter your Name please, 5-20 characters:  :  ");
        playerName = _keyboard.next();
        while (playerName.length() < 5 && playerName.length() > 20)
        {
            System.out.println("Player Name must be between [5 - 20] Characters. ");
            System.out.print("Enter your Name please, 5-20 characters :  ");
            playerName = _keyboard.next();
        }
       
        return playerName; 
    }
    public String Name(){
        return playerName;

    }
    public String PlayerName(String _pName)
    {
	//saves the player name
        playerName = _pName;
        return playerName;
    }


    public Player CompareNames(Player _playerName1, Player _playerName2)
    // this funtion take two name and compare them for uniqueness
    {
       
        while (_playerName1.playerName.equalsIgnoreCase(_playerName2.playerName))
        {
            System.out.print("Player Name has to be unique.");
            _playerName2.playerName = getName();
        }
        return _playerName2;
    }
	
}
