package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import model.vehicles.VehiclePrototype;

public class ImageHandler {
    private List<VehiclePrototype> vehicles;
    private List<BufferedImage> vehicleImages = new ArrayList<>();
    private BufferedImage workshopImage;

    public ImageHandler(List<VehiclePrototype> vehicles){
        this.vehicles=vehicles;
        loadVehicleImages();
        loadWorkshopImage();
    }


    private void loadVehicleImages() {
        try {
            if (!vehicles.isEmpty()) {

                for (VehiclePrototype vehicle : vehicles) {
                    vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream(vehicle.getImagePath())));
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

    public List<BufferedImage> getVehicleImages(){
        return vehicleImages;
    }

    public BufferedImage getWorkshopImage(){
        return workshopImage;
    }
}
