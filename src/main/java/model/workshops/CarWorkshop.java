package model.workshops;

import java.util.List;
import java.util.ArrayList;
import model.vehicles.CarPrototype;

public class CarWorkshop<C extends CarPrototype> {
    private final List<C> cars;
    private final int maxCarsInWorkshop;

    public CarWorkshop(int maxCarsInWorkshop) {
        this.cars = new ArrayList<>();
        this.maxCarsInWorkshop = maxCarsInWorkshop;
    }

    public void addCarToWorkshop(C car) {
        if (cars.size() < maxCarsInWorkshop) {
            cars.add(car);
        } else {
            System.out.print(" addCarToWorkshop(): Workshop can't take more cars.");
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

    public int getCarAmountInWorkshop() {
        return cars.size();
    }

    public int getMaxCarsCapacity(){
        return maxCarsInWorkshop;
    }
}
