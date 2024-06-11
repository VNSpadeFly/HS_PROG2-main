package spaceinvadersProject.controller;

import javashooter.controller.LimitedTimeController;
import javashooter.gameobjects.GameObject;

public class ZickZackController extends LimitedTimeController {
    private double lastSwitchTime = 0;
    private double switchInterval = 0.5; 
    private double xSpeed1 = -30;
    private double xSpeed2 = 30; 
    private boolean useFirstSpeed = true; 

    public ZickZackController(double g0, double duration) {
        super(g0, duration);
    }

    @Override
    public void updateObject() {
        double currentTime = getPlayground().getGameTime() / 1000.0; // Umrechnen in Sekunden

        if (currentTime - lastSwitchTime >= switchInterval) {
            lastSwitchTime = currentTime;
            useFirstSpeed = !useFirstSpeed; // Geschwindigkeiten wechseln
        }

        // Setze die X-Geschwindigkeit des kontrollierten Objekts
        if (useFirstSpeed) {
            gameObject.setVX(xSpeed1);
        } else {
            gameObject.setVX(xSpeed2);
        }

        // Rufe die updateObject-Methode der Superklasse auf
        super.updateObject();
    }
}

