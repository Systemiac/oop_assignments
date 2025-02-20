package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.vehicles.VehiclePrototype;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // TODO: link cars, images and points somehow.
    // Just a single image, TODO: Generalize
    private ArrayList<BufferedImage> carImages = new ArrayList<>();
    // To keep track of a single car's position
    private ArrayList<Point> carPoints = new ArrayList<>();
    private ArrayList<VehiclePrototype> vehicles = new ArrayList<>();

    BufferedImage carWorkshopImage;
    Point carWorkshopPoint = new Point(300, 300);

    // TODO: Make this general for all cars
    public void moveit(int x, int y) {

    }

    // TODO add the cars to the arraylists
    public void addCar() {

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<VehiclePrototype> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles;
        System.out.println(vehicles);
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
            //carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg")));
            //carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Saab95.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < vehicles.size(); i++) {
            g.drawImage(carImages.get(i),(int)vehicles.get(i).getMovement().getPosX(), (int)vehicles.get(i).getMovement().getPosY(), null);
        }
        g.drawImage(carWorkshopImage, carWorkshopPoint.x, carWorkshopPoint.y, null);
    }
}