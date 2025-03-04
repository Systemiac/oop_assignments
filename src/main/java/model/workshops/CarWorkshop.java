package model.workshops;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.vehicles.CarPrototype;

public class CarWorkshop<C extends CarPrototype> {
    private final List<C> cars;
    private final int maxCarsInWorkshop;
    private Point location;
    private final Class<C> carType;

    public CarWorkshop(int maxCarsInWorkshop, Point location, Class<C> carType) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        this.cars = new ArrayList<>();
        this.maxCarsInWorkshop = maxCarsInWorkshop;
        this.location = location;
        this.carType=carType;
    }

    public void addCarToWorkshop(C car) {
    
        if (cars.size() >= maxCarsInWorkshop) {
            //System.out.println("Workshop is FULL");
        } else if (calculateDistance(location.x, location.y, car.getMovement().getPosX(),
                car.getMovement().getPosY()) > 50) {
            //System.out.println("Car is too far away to be added to the workshop :> 8=====D");

        } else {
            cars.add(car);
        }
    }

    public C removeCarFromWorkshop(C car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return car;
        } else {
            System.out.print(" removeCarFromWorkshop() Car is not in the workshop.");
            return null;
        }
    }

    public int getCurrentCarsInWorkshop() {
        return cars.size();
    }

    public int getMaxCarsInWorkshop() {
        return maxCarsInWorkshop;
    }

    public Point getPos() {
        return location;
    }

    public List<C> getCars(){
        return cars;
    }

    public Class<C> getType() {
        return carType;
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }


}
