package view;

import model.vehicles.VehiclePrototype;

public class GameHandler {
    

    public void avoidWall(VehiclePrototype vehicle, int x, int y) {
        if (outOfMap(x, y)) {
            vehicle.getEngine().stopEngine();
            vehicle.getMovement().turnLeft();
            vehicle.getMovement().turnLeft();
            vehicle.getEngine().startEngine();
        }
    }

    private boolean outOfMap(int x, int y) {
        return (x < 0 || y < 0 || x > 685 || y > 450);
    }
}
