package Week5.PatikaStore;

class Notebook extends Product {
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(int id, double unitPrice, double discountRate, int stockAmount, String productName, Brand brand,
                    int ram, int storage, double screenSize) {
        super(id, unitPrice, discountRate, stockAmount, productName, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }
}