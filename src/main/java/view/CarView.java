package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.CarController;
import controller.TruckController;
import model.managers.WorkshopManager;
import model.timer.SimulationManager;
import model.vehicles.CarPrototype;
import model.vehicles.TruckPrototype;
import model.vehicles.VehiclePrototype;
import model.interfaces.ICarControllerListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements ICarControllerListener {
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarController carController;
    TruckController truckController;
    TruckPrototype truckPrototype;
    CarPrototype carPrototype;
    SimulationManager SimulationManager;
    //List<VehiclePrototype> vehicles;

    public DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("<html>Saab<br>Turbo on</html>");
    JButton turboOffButton = new JButton("<html>Saab<br>Turbo off</html>");
    JButton liftBedButton = new JButton("<html>Scania<br>Lift Bed</html>");
    JButton lowerBedButton = new JButton("<html>Lower<br>Lift Bed</html>");
    JButton addCarButton = new JButton("<html>Add<br>Car</html>");
    JButton removeCarButton = new JButton("<html>Remove<br>Car</html>");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    @Override
    public void onCarListUpdated(List<CarPrototype> cars) {
        drawPanel.repaint();
    }

    
    public CarView(String framename, CarController carController, TruckController truckController, WorkshopManager workshopManager, SimulationManager simulationManager) {
        this.carController = carController;
        this.truckController = truckController;
    
        List<VehiclePrototype> allVehicles = new ArrayList<>();
        allVehicles.addAll(carController.carManager.getVehicles());
        allVehicles.addAll(truckController.truckManager.getVehicles());
    
        drawPanel = new DrawPanel(X, Y - 240, truckController.truckManager, carController.carManager, workshopManager, simulationManager);
    
        initComponents(framename);
    }
    
    
  
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, 
                        0, 
                        100, 
                        1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,5));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);     
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/6-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/6-15,200));
        this.add(stopButton);

      
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gas = ((double) gasAmount);
        
           
                carController.gas((int)gas);
        
           
                truckController.gas((int)gas);
            }
        });
        

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.brake(gasAmount);
                truckController.brake(gasAmount);
            } 
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                truckController.liftTruckBed(70);
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                truckController.lowerTruckBed(70);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.startAllCars();
                truckController.startAllTrucks();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.stopAllCars();
                truckController.stopAllTrucks();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                carController.addCar();
                drawPanel.repaint();
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carController.removeCar();
                drawPanel.repaint();
            }        
        });

       
        this.pack();

       
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
     
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       
        this.setVisible(true);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}