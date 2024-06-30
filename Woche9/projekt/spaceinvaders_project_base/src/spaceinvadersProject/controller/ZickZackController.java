package spaceinvadersProject.controller;
import javashooter.controller.LimitedTimeController;
import javashooter.gameobjects.GameObject;

public class ZickZackController extends LimitedTimeController {

    public ZickZackController(double g0, double duration) {
        super(g0, duration);
    }

    @Override
    public void updateObject() {
        if ((int)(getGameTime()*10)%5==0) {
        	setVX(-getVX());
        }
        super.updateObject();
    }
}

