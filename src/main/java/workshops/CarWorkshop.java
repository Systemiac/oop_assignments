package workshops;

import java.util.List;
import java.util.ArrayList;
import vehicles.Car;

public class CarWorkshop<C extends Car> {
    private final List<C> cars;
    private final int maxCars;

    public CarWorkshop(int maxCars) {
        this.cars = new ArrayList<>();
        this.maxCars = maxCars;
    }

    public void loadCar(C car) {
        if (cars.size() < maxCars) {
            cars.add(car);
        } else {
            System.out.print("Workshop can't take more cars.");
        }
    }

    public C unloadCar(C car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return car;
        } else {
            System.out.print("Car is not in the workshop.");
            return null;
        }
    }

    public int getCarAmount() {
        return cars.size();
    }

    public int getMaxCarsCapacity(){
        return maxCars;
    }
}
