package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.gamelogic.GameHandler;
import model.interfaces.IObserver;
import model.managers.CarManager;
import model.managers.ImageHandler;
import model.managers.TruckManager;
import model.managers.WorkshopManager;
import model.timer.SimulationManager;
import model.vehicles.CarPrototype;
import model.vehicles.TruckPrototype;
import model.workshops.CarWorkshop;

public class DrawPanel extends JPanel implements IObserver {

    private ImageHandler imageHandler;
    private GameHandler gameHandler;
    private TruckManager truckManager;
    private CarManager carManager;
    private WorkshopManager workshopManager;
    private SimulationManager simulationManager;

    public DrawPanel(int x, int y, TruckManager truckManager, CarManager carManager, WorkshopManager workshopManager,
            SimulationManager simulationManager) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.truckManager = truckManager;
        this.carManager = carManager;
        this.workshopManager = workshopManager;
        this.imageHandler = new ImageHandler(carManager.getVehicles(), truckManager.getVehicles());
        this.gameHandler = new GameHandler();
        this.simulationManager = simulationManager;
        this.simulationManager.addObserver(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<CarPrototype> cars = carManager.getVehicles();
        for (int i = 0; i < cars.size(); i++) {
            if (i < imageHandler.getCarImages().size()) {
                g.drawImage(imageHandler.getCarImages().get(i),
                        (int) cars.get(i).getMovement().getPosX(),
                        (int) cars.get(i).getMovement().getPosY(), null);
            }
        }

        List<TruckPrototype> trucks = truckManager.getVehicles();
        for (int i = 0; i < trucks.size(); i++) {
            if (i < imageHandler.getTruckImages().size()) { 
                g.drawImage(imageHandler.getTruckImages().get(i),
                        (int) trucks.get(i).getMovement().getPosX(),
                        (int) trucks.get(i).getMovement().getPosY(), null);
            }
        }

        for (CarWorkshop workshop : workshopManager.getWorkshops()) {
            g.drawImage(imageHandler.getWorkshopImage(), workshop.getPos().x, workshop.getPos().y, null);
        }
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }

    @Override
    public void update() {
        repaint();
    }

}