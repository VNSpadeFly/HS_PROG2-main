package spaceinvadersProject;
//package w6;
import javashooter.gameutils.GameLoop;
import javashooter.playground.Playground;
import spaceinvadersProject.playground.W6Level;


public class EigenesSpielW6 extends GameLoop {

  public Playground nextLevel(Playground currentLevel) {     
	
	  
	  if (currentLevel == null) {
		  return new W6Level(); 	  
	  } else { 
		  return null;
	  }
  }

  public static void main(String[] args) {
    SpaceInvadersGame game = new SpaceInvadersGame();
    game.runGame(args);
  }


}
