package playground;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javashooter.controller.LimitedTimeController;
import javashooter.controller.ObjectController;
import javashooter.gameobjects.GameObject;
import javashooter.gameobjects.RectObject;
import javashooter.gameobjects.TextObject;
import javashooter.rendering.PulsatingCircleArtist;
import spaceinvadersProject.controller.SimpleShotController;
import spaceinvadersProject.controller.ZickZackController;
import spaceinvadersProject.gameobjects.EgoObject;
import spaceinvadersProject.playground.SpaceInvadersLevel;

public class W9Level extends SpaceInvadersLevel {
	double bonusActivationTime = -100;
    
    //Aufgabe 2
    @Override
    public String getName(){
        return "Level 9"; 
    }

    @Override
    //Aufgabe 3
    public GameObject createEgoObject(){
        // Instanz für PulsatingCircleJerk erstellen
        GameObject ego = super.createEgoObject();
        Color egoColor = Color.GREEN; 
        double reduction = 0.7; 
        double frequency = 0.5; 
        PulsatingCircleArtist artist = new PulsatingCircleArtist(ego, EGORAD, egoColor, reduction, frequency);
        //Object Ego die neue Instanz von PulsatingCircleArtist mitgeben
        ego.addArtist(artist);
        return ego ;
    } 
    //Aufgabe 4
    @Override
    public GameObject createEnemyShotObject(GameObject parentObject, String name, ObjectController ZickZackController){
    	double duration = 2;
    	GameObject shot = super.createEnemyShotObject(parentObject, name, new ZickZackController(getGameTime(), duration));
    	shot.setVX(30);
    	return shot;
        
    }
    

    //Aufgabe 5
    @Override
    public GameObject createEgoShot(String shotName, GameObject ego) {
    	GameObject bonus =  super.createEgoShot(shotName,ego);
    	
    	if(getGameTime() -bonusActivationTime < 5) {
    		bonus.setOmega(Math.PI);    		
    	}
    	return bonus;
    }
  
  
    @Override
    protected void actionIfEgoCollidesWithCollect(GameObject collect, GameObject ego) {
    	bonusActivationTime = getGameTime();
    	super.actionIfEgoCollidesWithCollect(collect, ego);
    }

}
       
