/* This program will allow two persons to play rock, paper, scissors saw against the computer */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class RPSS{
  public static void main(String[] args) {

    Scanner keyboard = new Scanner (System.in); // Activate the input system...Keyboard in this case
    
    //create the first player
    Player player1 = new Player(keyboard);
    System.out.println("Player 1 is "+player1.Name());
    System.out.println("Player 1 win = "+player1.playerScore.win);
    
    //Create the second player
	Player player2 = new Player(keyboard); 
	player2 = player2.CompareNames(player1,player2); //compare the names and  ensure that they are unique. Saves the unique player2 name.
    System.out.println("Player 2 is "+player2.Name());
    
    // Create AI - Computer Player
    Player computerAI = new Player();
    //Add the players to the list
    List<Player>  playerList = new ArrayList<Player>();
    List<Player>  gameScoreCard = new ArrayList<Player>();
    playerList.add(player1);
    playerList.add(player2);
    playerList.add(computerAI);

    Player thisPlayer= new Player(player1.playerName);
    gameScoreCard.add(thisPlayer);
    thisPlayer= new Player(player2.playerName);
    gameScoreCard.add(player2);
    thisPlayer= new Player("Computer");
    gameScoreCard.add(computerAI);
    
//******* Game mechanics */
    //Start the game
    Game currentGame = new Game();
    GameStats gamestats = new GameStats();
    int gameCounter=0;
    //intialise the  score car used for the show stats
    // List<Player> gameScoreCard= currentGame.initalizeScoring(playerList); 
    //Fill the winner table
    int[][] winTable = currentGame.FillWinnerTable();
    boolean keeplooping=true;
    // get the player's choice for the game
    do{
     int gameChoice = currentGame.GameMenu(keyboard); 

       switch (gameChoice) {
        case 1: // PlayGame
             gameCounter++;

             gameScoreCard=  currentGame.PlayGame(gameCounter,playerList, keyboard,winTable,gameScoreCard);         
            break;
        case 2: // Show Game Statistics
           currentGame.ShowGameStats(playerList, gameScoreCard);
            break;
        case 3:  // Display the rules of the Game
            currentGame.DisplayRules();
            break;
        case 4: // Close the keyboard and quit the game
            currentGame.QuitGame();
            keyboard.close();
            System.exit(0);
            break;
        default:
        System.out.println("Error!! You must choice a valid Menu option [1..4]");
            break;
        } 
    } while (keeplooping);
  }

}




        
