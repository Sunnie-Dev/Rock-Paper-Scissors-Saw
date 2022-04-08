import java.util.*;
import java.util.Random;




public class Weapon{
    
    enum weapon {
        ROCK(1), PAPER(2), SCISSORS(3), SAW(4);
       //constructor
        private int wp;
        //set the weapon
        private  weapon (int wp) {
         //set the weapon
           this.wp = wp;}
       
        public int wp(){
         //get the weapon   
            return wp;
          }
    
    };
    Scanner _keyboard;

    public Weapon(){
        
    }
 
   public weapon Menu(Scanner _keyboard){
       // Menu of weapons  for the game players
        
        int weaponMenuChoice = 0; 
       
     
        do{
        System.out.println("********  WEAPONS ********");
        System.out.println("* 1 : ROCK               *");
        System.out.println("* 2 : PAPER              *");
        System.out.println("* 3 : SCISSORS           *");
        System.out.println("* 4 : SAW                *");
        System.out.println("*------------------------*");
        System.out.print("* Choose a Weapon [1..4] : ");
        
            try { 
             weaponMenuChoice =_keyboard.nextInt();
             System.out.println("Player chooses "+ weapon.values()[weaponMenuChoice -1]);
           
             
            } catch (Exception e) {
                System.out.println("Error!! You must choice a valid Menu option [1..4]");
           }   
        }    
  
       while  (weaponMenuChoice < 0 && weaponMenuChoice > weapon.values().length + 1);
    return  weapon.values()[weaponMenuChoice -1];

    }

    public weapon computerTurn(){
        // Module generates a random weapon for the computer
        int weaponLength = weapon.values().length; // gets the number of elements in the weapons enumerated list
        Random randomNumber = new Random(); // prep for random number
        int computerChoice = randomNumber.nextInt(weaponLength-1); // generate a random number for the computer weapon choice
        System.out.println("Player chooses "+ weapon.values()[computerChoice]);
        return weapon.values()[computerChoice]; // get weapon name
    }
    
}