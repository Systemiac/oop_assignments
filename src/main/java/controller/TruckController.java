package controller;

import model.vehicles.*;
import view.BoundaryHandler;
import view.CarView;
import model.managers.TruckManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.List;

public class TruckController {
    private final int delay = 50;
    public final Timer timer = new Timer(delay, new TimerListener());
    public TruckManager truckManager;
    private BoundaryHandler boundaryHandler;
    public CarView frame;

    public TruckController(List<TruckPrototype> trucks) {
        this.truckManager = new TruckManager(trucks);
    }

    public void setView(CarView frame) {
        this.frame = frame;
        if (this.boundaryHandler == null) {
            this.boundaryHandler = new BoundaryHandler(frame.drawPanel.getWidth(), frame.drawPanel.getHeight());
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            truckManager.moveAllVehicles();
            
            for (TruckPrototype truck : truckManager.getVehicles()) {
                boundaryHandler.keepWithinBounds(truck);
            }
            frame.drawPanel.repaint();
        }
    }

    public void liftTruckBed(int amount) {
        truckManager.raiseAllCargoBeds(amount);
    }

    public void lowerTruckBed(int amount) {
        truckManager.lowerAllCargoBeds(amount);
    }

    public void startAllTrucks() {
        truckManager.startAllEngines();
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    public void stopAllTrucks() {
        truckManager.stopAllEngines();
        timer.stop();
    }
}
