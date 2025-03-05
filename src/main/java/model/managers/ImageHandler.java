package model.managers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import model.vehicles.CarPrototype;
import model.vehicles.TruckPrototype;
import model.vehicles.VehiclePrototype;
import view.DrawPanel;

public class ImageHandler {
    private List<CarPrototype> cars;
    private List<TruckPrototype> trucks;
    private List<BufferedImage> carImages = new ArrayList<>();
    private List<BufferedImage> truckImages = new ArrayList<>();
    private BufferedImage workshopImage;

    public ImageHandler(List<CarPrototype> cars, List<TruckPrototype> trucks){
        this.cars=cars;
        this.trucks=trucks;
        loadCarImages();
        loadTruckImages();
        loadWorkshopImage();
    }


    private void loadCarImages() {
        try {
            if (!cars.isEmpty()) {

                for (VehiclePrototype vehicle : cars) {
                    carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(vehicle.getImagePath())));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadTruckImages() {
        try {
            if (!trucks.isEmpty()) {

                for (VehiclePrototype vehicle : trucks) {
                    truckImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(vehicle.getImagePath())));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadWorkshopImage(){
        try {
            workshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<BufferedImage> getCarImages(){
        return carImages;
    }

    public List<BufferedImage> getTruckImages(){
        return truckImages;
    }

    public BufferedImage getWorkshopImage(){
        return workshopImage;
    }
}
