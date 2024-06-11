package spaceinvadersProject.controller;

import javashooter.controller.KinematicsController;

public class BounceController2 extends KinematicsController {

    public void updateObject() {
        double ts = this.getPlayground().getTimestep();
        if(this.getX()>670 || this.getX()<30){
            this.setX((this.getX() + this.getVX() * ts)*-1);
        }
        if(this.getY()>670 || this.getY()<30){
            this.setY((this.getY() + this.getVY() * ts)*-1);
        }
    super.updateObject();
  }
}
