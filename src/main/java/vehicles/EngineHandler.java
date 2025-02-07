package vehicles;

class EngineHandler {
    private double enginePower;
    private double currentSpeed;

    public EngineHandler(double enginePower) {
        this.enginePower = enginePower;
        this.currentSpeed = 0;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    // S: ändrade speedFactor() till parameter
    public void incrementSpeed(double amount, double speedFactor) {
        currentSpeed = Math.min(currentSpeed + speedFactor * amount, enginePower);
    }

    public void decrementSpeed(double amount, double speedFactor) {
        currentSpeed = Math.max(currentSpeed - speedFactor * amount, 0);
    }
}
