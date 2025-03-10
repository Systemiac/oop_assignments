package model.managers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import model.vehicles.CarPrototype;
import model.vehicles.TruckPrototype;
import model.vehicles.VehiclePrototype;
import view.DrawPanel;

public class ImageHandler {
    private List<CarPrototype> cars;
    private List<TruckPrototype> trucks;
    private HashMap<CarPrototype,BufferedImage> carImages = new HashMap<>();
    private HashMap<TruckPrototype,BufferedImage> truckImages = new HashMap<>();
    private BufferedImage workshopImage;

    public ImageHandler(List<CarPrototype> cars, List<TruckPrototype> trucks){
        this.cars=cars;
        this.trucks=trucks;
    }

    public void loadAllImages(){
        loadCarImages();
        loadTruckImages();
        loadWorkshopImage();
    }


    public void loadCarImages() {
        try {
            if (!cars.isEmpty()) {

                for (CarPrototype car : cars) {
                    carImages.put(car,ImageIO.read(DrawPanel.class.getResourceAsStream(car.getImagePath())));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadTruckImages() {
        try {
            if (!trucks.isEmpty()) {

                for (TruckPrototype truck : trucks) {
                    truckImages.put(truck,ImageIO.read(DrawPanel.class.getResourceAsStream(truck.getImagePath())));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadWorkshopImage(){
        try {
            workshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<CarPrototype,BufferedImage> getCarImages(){
        return carImages;
    }

    public HashMap<TruckPrototype,BufferedImage> getTruckImages(){
        return truckImages;
    }

    public BufferedImage getWorkshopImage(){
        return workshopImage;
    }
}
