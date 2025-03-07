package model.interfaces;

import java.util.List;
import model.vehicles.CarPrototype;

public interface ICarControllerListener {
    void onCarListUpdated(List<CarPrototype> cars);
}
