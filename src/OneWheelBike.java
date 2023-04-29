

public class OneWheelBike extends Bike {

    OneWheelBike(String mod, int Diametr) {
        super(mod, 1, Diametr);
        Storage.Added_bikes.add(this);
    }

    @Override
    public void fix_bike(int diam) {
        this.wheel.diametr = diam;
        System.out.println("Велосипед " + " с 1 колесом был отремонтирован. Новый диаметр колес: " + diam);
    }

    @Override
    public Object clone() {
        Bike new_bike = null;
        new_bike = new OneWheelBike(this.model, this.wheel.diametr);
        new_bike.wheel = new Wheel(this.wheel.diametr);
        return new_bike;
    }
}
