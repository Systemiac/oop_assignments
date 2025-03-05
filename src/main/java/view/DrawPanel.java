package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.gamelogic.GameHandler;
import model.managers.CarManager;
import model.managers.ImageHandler;
import model.managers.TruckManager;
import model.managers.WorkshopManager;
import model.vehicles.CarPrototype;
import model.vehicles.TruckPrototype;
import model.workshops.CarWorkshop;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, to keep track of a single car's position

    private ImageHandler imageHandler;
    private GameHandler gameHandler;
    private TruckManager truckManager;
    private CarManager carManager;
    private WorkshopManager workshopManager;

    public DrawPanel(int x, int y, TruckManager truckManager, CarManager carManager, WorkshopManager workshopManager) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.truckManager = truckManager;
        this.carManager = carManager;
        this.workshopManager = workshopManager;
        this.imageHandler = new ImageHandler(carManager.getVehicles(), truckManager.getVehicles());
        this.gameHandler = new GameHandler();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CarPrototype car : carManager.getVehicles()) {
            g.drawImage(imageHandler.getCarImages().get(carManager.getVehicles().indexOf(car)),
                    (int) car.getMovement().getPosX(),
                    (int) car.getMovement().getPosY(), null);
        }
        for (TruckPrototype truck : truckManager.getVehicles()) {
            g.drawImage(imageHandler.getTruckImages().get(truckManager.getVehicles().indexOf(truck)),
                    (int) truck.getMovement().getPosX(),
                    (int) truck.getMovement().getPosY(), null);
        }

        for (CarWorkshop workshop : workshopManager.getWorkshops()) {
            g.drawImage(imageHandler.getWorkshopImage(), workshop.getPos().x, workshop.getPos().y, null);
        }
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }
}