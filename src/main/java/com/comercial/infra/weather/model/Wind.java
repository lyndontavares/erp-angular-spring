package com.comercial.infra.weather.model;

public class Wind {
   
    private Speed speed;
    
    private Direction direction;

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Wind{" + "speed=" + speed + ", direction=" + direction + '}';
    }
    
    public Wind(){
    	
    }
    
    
}
