import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Storage {
    private static LinkedList<Bike> all_bikes = new LinkedList<>();
    private static LinkedList<Shop> all_shops = new LinkedList<>();
    private static LinkedList<Client> all_byers = new LinkedList<>();
    private static LinkedList<FixRoom> all_rooms = new LinkedList<>();

    public static LinkedList<FixRoom> getAll_rooms() {
        return all_rooms;
    }

    public static void setAll_rooms(FixRoom room) {
        all_rooms.add(room);
    }

    public static LinkedList<Bike> getAll_bikes() {
        return all_bikes;
    }

    public static void setAll_bikes(Bike bike) {
        all_bikes.add(bike);
    }

    public static LinkedList<Shop> getAll_shops() {
        return all_shops;
    }

    public static void setAll_shops(Shop shop) {
        all_shops.add(shop);
    }

    public static void setAll_byers(Client client) {
        all_byers.add(client);
    }

    public static LinkedList<Client> getAll_byers() {
        return all_byers;
    }

    public static ArrayList<Bike> Added_bikes = new ArrayList<>();

    public static void change_article(Bike bike) {
        for (Bike bk : all_bikes) {
            if (bk.serial_number == bike.serial_number) {
                bk.article = bike.article;
            }
        }
    }

    public static ArrayList<Bike> add_bike() throws IOException {

        int x = Dialog.input_int("Введите количество велосипедов: ");
        int i = 0;
        while (i < x) {
            int a = (int) (1 + Math.random() * 2);
            int b = (int) (15 + Math.random() * 30);
            if (a == 1) {
                new OneWheelBike("yamaha", b);
            } else {
                Added_bikes.add(new Bike("yamaha", a, b));
            }
            i++;
        }
        return Added_bikes;
    }
}
