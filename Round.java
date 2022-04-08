import java.util.List;

public class Round{
     int id; //Round indentification - a certain number of rounds constitute a game
     Player player;
     Weapon.weapon weapon;

    public Round(){

    }
    public Round(int _id,Player _player, Weapon.weapon _weapon){
        // creates a round of player and weapon
        id =_id;
        player = _player;
        weapon = _weapon;

    }


    public List<Round> addPlayer(List<Round> _round, int _roundId, Player _player, Weapon.weapon _weapon){
        // adds a player and weapon to the current round
        Round thisRound = new Round(_roundId,_player,_weapon); 
        _round.add(thisRound);
        return  _round;
    }

}