package designpatterns;

public class BuilderPattern {

    public static void main(String[] args) {
        Car mustang = new Car.Builder(110).withYear(2001).withBrand("Mustang").builder();
        System.out.println(mustang.getBrand());

    }
}

class Car {
    int serial;
    int year;
    String model;
    String brand;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    static class Builder {
        int serial;
        int year;
        String model;
        String brand;
        public Builder(int serial) {
            this.serial = serial;
        }

        Builder withYear(int year) {
            this.year = year;
            return this;
        }

        Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Car builder() {
            Car car = new Car();
            car.setSerial(this.serial);
            car.setBrand(this.brand);
            return car;
        }
    }

    public Car() {
    }
}
