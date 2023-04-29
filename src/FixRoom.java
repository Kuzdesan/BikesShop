import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class FixRoom {
    String title;
    LinkedList<Client> clients = new LinkedList<>();
    LinkedList<Pair<Client, Bike>> fixed_bikes = new LinkedList<>();

    FixRoom(String name) {
        title = name;
        Storage.setAll_rooms(this);
    }



    public static void repair(ArrayList<Bike> random_bikes) throws IOException {
        for (int i = 0; i < random_bikes.size(); i++) {

            if (random_bikes.get(i).Num_of_wheels == 1) {
                random_bikes.get(i).fix_bike(Dialog.input_int("Введите новый диаметр колес: "));
            } else continue;
        }
    }


    //    public void fix_bike(int pass, int num, int diam) {
//        for (Client cl : Storage.getAll_byers()) {
//            if (cl.getPassport() == pass) {
//                for (Bike bk : cl.purchased) {
//                    if (bk.serial_number == num) {
//                        if (bk.Num_of_wheels == 1) {
//                            OneWheelBike fixed_bike = (OneWheelBike) bk.clone();
//                            fixed_bike.fix_bike(diam);
//                            cl.fixed.add(fixed_bike);
//                            Pair<Client, Bike> pr = new FixRoom.Pair<>(cl, fixed_bike);
//                            fixed_bikes.add(pr);
//                            Storage.getAll_bikes().remove(fixed_bike);
//                        }
//                    }
//                }
//            }
//        }
//    }
    public String toString() {
        return ("Название мастерской: " + title);
    }

    static class Pair<A, B> {
        public final A first;
        public B second;

        public Pair(final A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}
