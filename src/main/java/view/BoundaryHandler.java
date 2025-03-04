package view;

import model.vehicles.MovementHandler;
import model.vehicles.VehiclePrototype;

public class BoundaryHandler {
    private final int windowWidth;
    private final int windowHeight;

    public BoundaryHandler(int width, int height) {
        this.windowWidth = width;
        this.windowHeight = height;
    }

    public void keepWithinBounds(VehiclePrototype vehicle) {
        double x = vehicle.getMovement().getPosX();
        double y = vehicle.getMovement().getPosY();
        
        if (x < 0) {
            vehicle.getMovement().setPos(0, y);
            vehicle.getMovement().setDir(MovementHandler.Direction.east);
        } else if (x > windowWidth - 100) { 
            vehicle.getMovement().setPos(windowWidth - 100, y);
            vehicle.getMovement().setDir(MovementHandler.Direction.west);
        }
    
        if (y < 0) {
            vehicle.getMovement().setPos(x, 0);
            vehicle.getMovement().setDir(MovementHandler.Direction.south);
        } else if (y > windowHeight - 100) { 
            vehicle.getMovement().setPos(x, windowHeight - 100);
            vehicle.getMovement().setDir(MovementHandler.Direction.north);
        }
    }
    
}
