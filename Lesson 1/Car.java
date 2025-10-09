
public class Car {

    private String brand; // (марка автомобиля)
    private String model; //  (модель автомобиля)
    private String year; // (год выпуска)

    Car(String brand, String model, String year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String sBrand){
        brand = sBrand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String sModel){
        model = sModel;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String sYear){
        year = sYear;
    }

    public void displayInfo(){
        System.out.println();
        System.out.println("Информация об автомобиле");
        System.out.println("======================================");
        System.out.println("Brand: " + "'" + getBrand() + "' " +
                "Model: " + "'" + getModel() + "' " +
                "Year: " + "'" + getYear() + "'");
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        Car c = new Car("BMW", "C2", "2024");
        c.displayInfo();
    }
}