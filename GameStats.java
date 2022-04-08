import java.util.List;

public class GameStats{
    
List<Player> playerList;


public void ShowGameStats(List<Player> playerList, List<Player> _gameScore){

     for (Player _player: playerList) {
         System.out.print("\n");
         System.out.println("******     Player Stats        ********");
         System.out.println(_player.playerName +" win "+_player.playerScore.win+" lose "+_player.playerScore.lose+ " tie  "+_player.playerScore.tie);  
           }   
      for (Player _player: _gameScore) {
         System.out.print("\n");
         System.out.println("******     Game Stats        ********");
         System.out.println(_player.playerName +" win "+_player.playerScore.win+" lose "+_player.playerScore.lose+ " tie  "+_player.playerScore.tie);  
               }   
         System.out.print("\n");
         if(_gameScore.get(0).playerScore.win > _gameScore.get(1).playerScore.win)
             System.out.println(" Human Winner is "+_gameScore.get(0).playerName);
         else  System.out.println(" Human Winner is "+_gameScore.get(1).playerName);
 

}
 }
    
