package web.model;

public class Car  {

    private String brand;
    private String model;
    private int manufactureYear;

    public Car(String brand, String model, int manufactureYear) {
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear(){
        return manufactureYear;
    }
    public void setBrand(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

}
