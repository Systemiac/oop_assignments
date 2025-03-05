package model.gamelogic;

import model.vehicles.VehiclePrototype;

public class GameHandler {
    

    public void avoidWall(VehiclePrototype vehicle) {
        if (outOfMap(vehicle.getMovement().getPosX(), vehicle.getMovement().getPosY())) {
            vehicle.getEngine().stopEngine();
            vehicle.getMovement().turnLeft();
            vehicle.getMovement().turnLeft();
            vehicle.getEngine().startEngine();
        }
    }

    private boolean outOfMap(double x, double y) {
        return (x < 0 || y < 0 || x > 685 || y > 450);
    }
}
