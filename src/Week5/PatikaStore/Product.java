package Week5.PatikaStore;

class Product {
    private int id;
    private double unitPrice;
    private double discountRate;
    private int stockAmount;
    private String productName;
    private Brand brand;

    public Product(int id, double unitPrice, double discountRate, int stockAmount, String productName, Brand brand) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.productName = productName;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getProductName() {
        return productName;
    }

    public Brand getBrand() {
        return brand;
    }
}