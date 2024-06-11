package spaceinvadersProject.playground;

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

public class W9Level extends SpaceInvadersLevel {
    
    //Aufgabe 2
    @Override
    public String getName(){
        return "Level 9"; 
    }

    @Override
    //Aufgabe 3
    public EgoObject createEgoObject(){
        // Instanz für PulsatingCircleJerk erstellen
        EgoObject ego = super.createEgoObject();
        Color egoColor = Color.GREEN; 
        double reduction = 0.3; 
        double frequency = 2.0; 
        PulsatingCircleArtist artist = new PulsatingCircleArtist(ego, EGORAD, egoColor, reduction, frequency);
        //Object Ego die neue Instanz von PulsatingCircleArtist mitgeben
        ego.addArtist(artist);
        return ego ;
    } 
    //Aufgabe 4
    @Override
    public GameObject createEnemyShotObject(ObjectController ZickZackController){
        double initialGameTime = this.getGameTime();
        double duration = 5;

        ZickZackController zickZackController = new ZickZackController(initialGameTime, duration);

        GameObject to = new TextObject(name, this, parentObject.getX(), parentObject.getY(), 0, ENEMYSHOTSPEED, "I", 20, Color.YELLOW)
            .generateColliders()
            .setController(zickZackController);
        return to;
    }
    @Override
    protected GameObject createEnemyShot(){
        double gameTime = this.getGameTime();
        double PROB = calcEnemyShotProb();
        double diceThrow = Math.random();
        Integer nrEnemyShots = this.enemyShotCounter.get() + 1 ;

        if(diceThrow < PROB){
            //Aufgabe 4
            ZickZackController zickzackController = new ZickZackController(gameTime, 5.);

            GameObject textObject = createEnemyShotObject(e, "enemyShot" + nrEnemyShots, zickzackController);
            addObject(textObject);
            this.enemyShotCounter.set( enemyShotCounter.get() + 1) ;
            return textObject ;
        }

        return null ;
    }

    //Aufgabe 5
    @Override
    public void actionIfEgoCollidesWithCollect(){ 
        // Startet Mezthode wenn Bonus gesammelt
        super.actionIfEgoCollidesWithCollect(collect, ego);
        // Bonus aktivieren und 5 Sekunden timer nehmen
        boolean bonusActive = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Bonus deaktivieren nach Ablauf der Zeit
                bonusActive = false;
            }
        }, 5000); // 5 Sekunden
    }

    @Override
    public GameObject createEgoShot() {
        
        // Überprüfen, ob der Bonus aktiv ist
        if (bonusActive) {
            //Omega mit PI
            /* 
            GameObject ss = new RectObject(shotName, this, ego.getX(), ego.getY(), 0,
            -1. * SpaceInvadersLevel.SHOTSPEED, 4, 12, Color.CYAN)
            .setOmega(Math.PI)// Setzen der Winkelgeschwindigkeit auf PI
            .generateColliders();*/
            ss.setOmega(Math.PI); //Möglicherweise einfach das
            return ss;
        } else {
            // back zu normales Schussobjekt , anosnten hat er keins
            GameObject ss = new RectObject(shotName, this, ego.getX(), ego.getY(), 0,
                -1. * SpaceInvadersLevel.SHOTSPEED, 4, 12, Color.CYAN)
                .generateColliders();
            return ss;
        }
    }

} 
