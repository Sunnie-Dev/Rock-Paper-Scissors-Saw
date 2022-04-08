import java.util.*;



public class Game{

   //Scanner _keyboard;
public Game(){
    // Constructor
}

public int GameMenu(Scanner _keyboard){
    // Print the Game Menu accepts the user choice
    int gameMenuChoice = 0;
    
    do {
        System.out.println("\n");
        System.out.println("***** GAME MENU ****");
        System.out.println("*  1. PLAY GAME    *");
        System.out.println("*  2. SHOW STATS   *");
        System.out.println("*  3. SHOW RULES   *");
        System.out.println("*  4. QUIT GAME    *");
        System.out.println("*------------------*");
        System.out.print("  Your Choice : ");
        try { 
            gameMenuChoice = _keyboard.nextInt();
        } catch (Exception e) {
          System.out.println("Error!! You must choice a valid Menu option [1..4]");
        }    
       
    } while (gameMenuChoice <1 && gameMenuChoice > 4);
    return gameMenuChoice;
} 
public void DisplayRules()
        {
            System.out.println("\n");
            System.out.println("********            GAME     RULES       *********");
            System.out.println("Three Rounds are played by each player vs computer");
            System.out.println("The winner of the rounds wins the game.           ");
            System.out.println("Games are limitless...............................");
            System.out.println("**********    WINNING PLAYS     ***********");
            System.out.println("* ROCK Smashes Scissors :      ROCK WINS  *");
            System.out.println("* ROCK Smashes Saw      :      ROCK WINS  *");
            System.out.println("* PAPER Covers Rock     :     PAPER WINS  *");
            System.out.println("* SCISSORS Cuts Paper   :  SCISSORS WINS  *");
            System.out.println("* SAW  Cuts Paper       :       SAW WINS  *");
            System.out.println("* SAW  Cuts SCISSORS    :       SAW WINS  *");
            System.out.println("* Weapons drawn that are the same counts as a tie or draw *");
        
        } 

public List<Player> PlayGame(int _games, List<Player> playerList, Scanner _keyboard, int[][] _winTable, List<Player> _scoreCard ){
    int rounds = 1; // keeps a count of the number of rounds played. Will rest after 3 rounds
    List<Round> currentRound = new ArrayList<Round>(); // keeps a list of players  and weapons chosen in the current round
    List<Round> allRounds = new ArrayList<Round>();
    //List<Rounds> gameRounds = new ArrayList<Rounds>();
    Weapon _weapon = new Weapon();
    Round _round ;
    Weapon.weapon _chosenWeapon; //weapon chosen by the player


    do {
        System.out.println("********  ROUND"+rounds + "   *******");
        for (Player player : playerList) { 
        // get the weapon choice for every player
         System.out.print("\n");
         System.out.println(player.playerName+" turn.");
         
            if (player.playerName != "Computer"){  // player chooses the weapon
                _chosenWeapon = _weapon.Menu(_keyboard);      
             } else {
             // get a random weapon for the computer's turn
             _chosenWeapon = _weapon.computerTurn();
             }
            // Add the player choices to the round
            _round = new Round(rounds, player, _chosenWeapon);
            currentRound.add(_round);
            allRounds.add(_round);
            // currentRound=_round.addPlayer(currentRound, rounds, player,_chosenWeapon ); // adds the player to round
        }  
        // round is finished
         // validate and update the winner for the round
        currentRound = validateRoundWinner(currentRound,_winTable);
        
        //save the Total player round scores in the player list
        for (Round round : currentRound) {
            for (Player _player: playerList) {
                if (_player.playerName == round.player.playerName){
                    _player.playerScore.win =+ round.player.playerScore.win;
                    _player.playerScore.lose =+ round.player.playerScore.lose;  
                    _player.playerScore.tie =+ round.player.playerScore.tie; 

                 }   
            }
        }
        //increment the round : 3 rounds constitute a game
        rounds++;
    currentRound.clear();
         
    }while (rounds <= 3);
    //display player
    for (Player _player: playerList) {
       System.out.println(_player.playerName +" win "+_player.playerScore.win+" lose "+_player.playerScore.lose+ " tie  "+_player.playerScore.tie);  
         }   

        Player gameWinner=validateGameWinner(playerList);
         System.out.println();
         System.out.println("*     ** GAME "+ _games+" Winner:  "+ gameWinner.playerName +"   **    *");

         //update the game with the winner
        _scoreCard = updateWinner(_scoreCard,gameWinner);
         return _scoreCard;
         

   // System.out.println(allRounds.toString());
}

public  List<Player> initalizeScoring(List<Player> player){
    //initialise the game score card for wach player
   List<Player> _scoreCard = new ArrayList<Player>();
   for(Player _player:player)
        _scoreCard.add(_player);
   return _scoreCard;
}

private List<Player> updateWinner(List<Player> _scoreCard, Player winner){
    // update the score card with the winner of the game
      //initialise the game score card for wach player
      for (Player _player : _scoreCard) {
        
        System.out.println("Update Game score");
        System.out.println(_player.playerName +" win "+_player.playerScore.win+" lose "+_player.playerScore.lose+ " tie  "+_player.playerScore.tie);  }
   
     for(Player _score : _scoreCard){
        if(_score.playerName == winner.playerName){ // find the player name ans update the gamw score
           _score.playerScore.win++;
           System.out.println(_score.playerName +" win "+_score.playerScore.win+" lose "+_score.playerScore.lose+ " tie  "+_score.playerScore.tie);  }
   
        }
  return _scoreCard; 
}

private Player validateGameWinner(List<Player> _playerList){
   //look for the most wins - winner
   int largest=0; // initalise the largest number in the list
   Player winner=null;
  //look for the winner 
   for(Player player:_playerList){  // look at each player
       if (player.playerScore.win > largest){  // if the player wins is more than the present win score
          winner=player;   // then  this is the winner
          largest=player.playerScore.win; // set his wins as the highest
       } else if (player.playerScore.win == largest &&  largest != 0){ // if there is no winner that means its a tie
           // there us a tie no winner
           if(winner.playerScore.lose > player.playerScore.lose){ // if the player lost lest than the present winner
             winner=player; //then the player is declared the winner
           }
       } 

   }
   return winner;
        
}
    

private List<Round> validateRoundWinner(List<Round> _currentRound, int[][] _winTable ){ 
    // uses the current round containing a list of players updates the player's score
    // The computer is the last entry in the list so get the weapon
    // get the computer so that it can be used to validate against all players
    System.out.print("\n");
       Round _computer = (Round)(_currentRound.get(_currentRound.size()-1)); 
       for (Round round : _currentRound) 
       {
           if(round.player.playerName != "Computer")
           {  // as long as its a player  not the computer

            //get the (x,y) position of the winnerTable 
                switch (_winTable[round.weapon.ordinal()][_computer.weapon.ordinal()]) 
                {
                    case 0: // Player and Computer Tie
                         round.player.playerScore.tie++; //increment the tie score for the player
                        _computer.player.playerScore.tie++; // increment score for the computer
                         System.out.println("Weapons are the same. Player and Computer Tie!"); 
                    break;
                    case 1: // Player wins and computer loses
                        round.player.playerScore.win++; //increment win score for the player
                        _computer.player.playerScore.lose++; // increment  lose score for the computer
                        System.out.println(round.player.playerName+" WINS!! , "+round.weapon.name()+" Beats " + _computer.weapon.name()); 
                    break;
                    case -1:  //Player loses and computer wins
                        round.player.playerScore.lose++; //increment the lose score for the player
                        _computer.player.playerScore.win++; // increment win scre for the computer
                        System.out.println(_computer.player.playerName+" WINS!! , "+_computer.weapon.name()+" Beats " +  round.weapon.name());
                    break;
                
                    default:
            
                    break;
                }  //case         
            } //if
                
        } // for  
        //update the computer score in the current round
        _currentRound.set(_currentRound.size()-1,_computer);

        return _currentRound;
    }        
    
public int [][] FillWinnerTable(){
                  
// Fills the table with the winning player (0 = tie/ draw  , -1 = lose, , 1 = win )
 int[][] winTable = {  // R, P,  S,  S
                        { 0,-1,  1,  1 }, //Rock
                        { 1, 0, -1, -1 }, //Paper
                        {-1, 1,  0, -1},  //Scissors
                        {-1, 1,  1,  0}   //Saw
                 };
    return winTable;
}
           
public void ShowGameStats(List<Player> playerList, List<Player> _gameScore){

    
        System.out.print("\n");
        System.out.println("******     Player Stats        ********");
        for (Player _player: playerList) {
        System.out.println(_player.playerName +" win "+_player.playerScore.win+" lose "+_player.playerScore.lose+ " tie  "+_player.playerScore.tie);  
          }   
     
        System.out.print("\n");
        System.out.println("******     Game Stats        ********");
        for (Player _player: _gameScore) {
        System.out.println(_player.playerName +" win "+_player.playerScore.win+" lose "+_player.playerScore.lose+ " tie  "+_player.playerScore.tie);  
              }   
        System.out.print("\n");
        if(_gameScore.get(0).playerScore.win > _gameScore.get(1).playerScore.win){
            System.out.println(" Human Winner is "+_gameScore.get(0).playerName);
        }
        else  System.out.println(" Human Winner is "+_gameScore.get(1).playerName);

     
 
}

public void QuitGame(){
    System.out.println("****  GOODBYE!   ***");
}
}