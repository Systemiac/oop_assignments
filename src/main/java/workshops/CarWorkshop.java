package workshops;

import java.util.List;
import java.util.ArrayList;
import vehicles.CarPrototype;

public class CarWorkshop<C extends CarPrototype> {
    private final List<C> cars;
    private final int maxCars;

    public CarWorkshop(int maxCars) {
        this.cars = new ArrayList<>();
        this.maxCars = maxCars;
    }

    public void addCarToWorkshop(C car) {
        if (cars.size() < maxCars) {
            cars.add(car);
        } else {
            System.out.print("Workshop can't take more cars.");
        }
    }

    public C removeCarFromWorkshop(C car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return car;
        } else {
            System.out.print("Car is not in the workshop.");
            return null;
        }
    }

    public int getCarAmountInWorkshop() {
        return cars.size();
    }

    public int getMaxCarsCapacity(){
        return maxCars;
    }
}
