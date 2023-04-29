import java.util.ArrayList;
import java.util.LinkedList;

public class Shop {
    String title;
    LinkedList<Bike> bikes = new LinkedList<>();
    LinkedList<Client> all_clients = new LinkedList<>();

    Shop(String name) {
        title = name;
        Storage.setAll_shops(this);
    }

    public void add_bike(Bike... bike) {
        for (int i = 0; i < bike.length; i++) {
            int ptr = 1;
            int temp = 1;
            if (bikes.size() != 0) {
                for (int j = 0; j < bikes.size(); j++) {
                    if (bikes.get(j).the_same(bike[i])) {
                        ptr = 0;
                        System.out.println("Велосипед с серийным номером " + bike[i].serial_number + " уже добавлен в магазин");
                        break;
                    }
                }
                if (ptr != 0) {
                    for (int k = 0; k < bikes.size(); k++) {
                        if (bikes.get(k).equals(bike[i])) {
                            bike[i].article = bikes.get(k).article;
                            bikes.addLast(bike[i]);
                            Storage.change_article(bike[i]);
                            temp = 0;
                            break;
                        }
                    }
                    if (temp != 0) {
                        bike[i].article = bikes.getLast().article + 1;
                        bikes.addLast(bike[i]);
                        Storage.change_article(bike[i]);
                    }
                } else break;
            }
            if (bikes.size() == 0) {
                bike[i].article = 1;
                bikes.add(bike[i]);
                Storage.change_article(bike[i]);
            }
        }
    }


    public void sell_bike(int art, Client person) {
        int temp = 1;
        for (Shop sh : Storage.getAll_shops()) {
            if (sh.title.equals(this.title)) {
                for (int i = 0; i < sh.bikes.size(); i++) {
                    if (bikes.get(i).article == art) {
                        person.purchased.add(bikes.get(i));
                        bikes.remove(i);

                        if (!this.all_clients.contains(person)) {
                            this.all_clients.addLast(person);
                            for (Client cl: Storage.getAll_byers()){
                                if (cl.equals(person)){
                                    temp = 0;
                                    break;
                                }
                            }
                            if (temp!=0){
                                Storage.setAll_byers(person);
                            }
                        }
                        break;
                    }
                }
            }
            break;
        }
    }

    public Client find_client(int passport) {
        for (Client cl : this.all_clients) {
            if (cl.getPassport() == passport) {
                return cl;
            }
        }
        return null;
    }

    public boolean contains(Client cl) {
        for (Client clients : this.all_clients) {
            if (clients.equals(cl)) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return ("Название магазина: " + title);
    }

}
