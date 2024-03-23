package Week5.PatikaStore;

class SmartPhone extends Product {
    private int storage;
    private double screenSize;
    private int camera;
    private double batteryPower;
    private int ram;
    private String color;

    public SmartPhone(int id, double unitPrice, double discountRate, int stockAmount, String productName, Brand brand,
                      int storage, double screenSize, int camera, double batteryPower, int ram, String color) {
        super(id, unitPrice, discountRate, stockAmount, productName, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.camera = camera;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getCamera() {
        return camera;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }
}