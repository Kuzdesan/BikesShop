public class Bike implements Comparable<Bike> {
    static int max_serial_num = 0;

    int Num_of_wheels;
    String model;
    Wheel wheel;
    int serial_number;
    int article = 0;



    Bike(String mod,  int count, int Diametr){
        model = mod;
        Num_of_wheels = count;
        wheel = new Wheel(Diametr);
        serial_number = ++max_serial_num;
        Storage.setAll_bikes(this);
    }

    @Override
    public int compareTo(Bike o) {
        return Integer.compare(this.wheel.diametr*this.Num_of_wheels, o.wheel.diametr*o.Num_of_wheels);
//        return this.Num_of_wheels.compareTo(o.Num_of_wheels);
    }

    public Object clone() {
        Bike new_bike = null;
        new_bike = new Bike(this.model, this.Num_of_wheels, this.wheel.diametr) {
        };
        new_bike.wheel = new Wheel(this.wheel.diametr);
        return new_bike;
    }

    public void fix_bike(int diam) {
        this.wheel.diametr = diam;
        System.out.println("Велосипед " + " с N колесом был отремонтирован. Новый диаметр колес: " + diam);
    }

    public boolean equals(Bike to_compare){
        if (this.Num_of_wheels == to_compare.Num_of_wheels && this.wheel.diametr == to_compare.wheel.diametr){ return true;}
        else return false;
    }

    public boolean the_same(Bike to_compare){
        if (this.serial_number == to_compare.serial_number){
            return true;
        } else return false;
    }

    public int hashCode(){
        final int ptr = 31;
        int res = 1;
        res = ptr*res + wheel.diametr + Num_of_wheels;
        return res;
    }

    public boolean contains(Bike bike){
        for (Bike bk: Storage.getAll_bikes()){
            if (bk.serial_number == bike.serial_number){
                return true;
            }
        }
         return false;
    }

    public String toString(){
        return ("Модель: " + this.model+ " ; Количество колес: " + this.Num_of_wheels + " ; Диаметр колеса: " + this.wheel.diametr + "; Серийный номер: " + this.serial_number + " ; Артикул: " + this.article);
    }
}
