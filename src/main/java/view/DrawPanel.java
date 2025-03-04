package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.vehicles.VehiclePrototype;
import model.workshops.CarWorkshop;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, to keep track of a single car's position
    private List<VehiclePrototype> vehicles = new ArrayList<>();
    private List<CarWorkshop> workshops = new ArrayList<>();

    private ImageHandler imageHandler;
    private GameHandler gameHandler;

    public DrawPanel(int x, int y, List<VehiclePrototype> vehicles, List<CarWorkshop> workshops) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;
        this.workshops = workshops;
        this.imageHandler = new ImageHandler(vehicles);
        this.gameHandler = new GameHandler();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VehiclePrototype vehicle : vehicles) {
            g.drawImage(imageHandler.getVehicleImages().get(vehicles.indexOf(vehicle)),
                    (int) vehicle.getMovement().getPosX(),
                    (int) vehicle.getMovement().getPosY(), null);
        }

        for (CarWorkshop workshop : workshops) {
            g.drawImage(imageHandler.getWorkshopImage(), workshop.getPos().x, workshop.getPos().y, null);
        }
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }
}