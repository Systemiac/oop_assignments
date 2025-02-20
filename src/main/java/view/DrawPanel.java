package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.vehicles.VehiclePrototype;
import model.workshops.CarWorkshop;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image,
    private ArrayList<BufferedImage> carImages = new ArrayList<>();
    // To keep track of a single car's position
    private ArrayList<Point> carPoints = new ArrayList<>();
    private ArrayList<VehiclePrototype> vehicles = new ArrayList<>();
    private ArrayList<CarWorkshop> workshops = new ArrayList<>();

    BufferedImage carWorkshopImage;

    public void avoidWall(VehiclePrototype vehicle, int x, int y) {
        if (outOfMap(x, y)) {
            for (int index = 0; index < 2; index++) {
                vehicle.getMovement().turnLeft();
            }
        }
    }

    private boolean outOfMap(int x, int y) {
        return (x < 0 || y < 0 || x > 800 || y > 500);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<VehiclePrototype> vehicles, ArrayList<CarWorkshop> workshops) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;
        this.workshops = workshops;
        //System.out.println(vehicles);
        // Print an error message in case file is not found with a try/catch block

        loadCarImages();
    }

    private void loadCarImages() {
        try {
            if (!vehicles.isEmpty()) {

                for (VehiclePrototype vehicle : vehicles) {
                    carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(vehicle.getImagePath())));
                }
            }
            carWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < vehicles.size(); i++) {
            g.drawImage(carImages.get(i), (int) vehicles.get(i).getMovement().getPosX(),
                    (int) vehicles.get(i).getMovement().getPosY(), null);
        }
        for(CarWorkshop workshop:workshops){
        g.drawImage(carWorkshopImage, workshop.getPos().x,  workshop.getPos().y, null);
        }
    }
}