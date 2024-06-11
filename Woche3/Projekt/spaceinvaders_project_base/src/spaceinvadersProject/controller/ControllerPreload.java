package spaceinvadersProject.controller;

import javashooter.controller.KinematicsController;

public class ControllerPreload extends KinematicsController {
    public void updateTrajectory(){
        if(this.getX()>670 || this.getX()<30){
            this.setVX(this.getVX() -1.5);
        }
    super.updateObject();
    }
    
}