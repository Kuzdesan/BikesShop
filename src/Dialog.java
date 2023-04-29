import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dialog {
    public static InputStream inputStream = System.in;
    public static Reader inputStreamReader = new InputStreamReader(inputStream);
    public static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    public static int input_int(String str) throws IOException {
        System.out.println(str);
        String paramOne = bufferedReader.readLine();
        return (Integer.parseInt(paramOne));
    }

    public static String input_str(String str) throws IOException {
        System.out.println(str);
        return (bufferedReader.readLine());
    }

    public static int[] input_Arrays(String str ) throws IOException {
        System.out.println(str);
        String Ar = bufferedReader.readLine();
        String[] ArSplit = Ar.split(" ", 0);
        int[] Array = new int[ArSplit.length];
        for (int i = 0; i < ArSplit.length; i++) {
            Array[i] = Integer.parseInt(ArSplit[i]);
        }
        return Array;
    }

    public static String input_str() throws IOException {
        return (bufferedReader.readLine());
    }

    public static void out() {
        System.out.println("\n\n\n");
//        посмотреть текущие данные:
//        for (Bike bk: Storage.getAll_bikes()){
//            System.out.println(bk.toString());
//        }
//        for (Client cl : Storage.getAll_byers()){
//            System.out.println(cl.toString());
//        }
//        for (Shop sh : Storage.getAll_shops()){
//            System.out.println(sh.toString());
//        }
//        for (FixRoom fx : Storage.getAll_rooms()){
//            System.out.println(fx.toString());
//        }
        System.out.println("Choose your func: ");
        System.out.println("0. exit");
        System.out.println("1. Информация о велосипеде");
        System.out.println("2. Добавить велосипед в магазин");
        System.out.println("3. Продать велосипед");
        System.out.println("4. Починить велосипед");
        System.out.println("5. Каталог магазина");
        System.out.println("6. Показать клиентов магазина");
        System.out.println("7. Показать покупки клиента");
        System.out.println("8. Показать починенные велосипеды клиента");
        System.out.println("9. Показать покупателей всех магазинов");
        System.out.println("10. Показать отремонтированные велосипеды");
    }


    public static void choose(int ch) throws IOException, MyException {
        switch (ch) {
            case 1 -> {
                int serial = input_int("Введите серийный номер");
                for (Bike bk : Storage.getAll_bikes()) {
                    if (bk.serial_number == serial) {
                        System.out.println(bk.toString());
                    }
                }
            }
            case 2 -> {
                int[] serials = input_Arrays("Введите серийные номера для добавления велосипедов: ");
//                int serial = input_int("Введите серийный номер");
                String shop = input_str("Введите название магазина");
                for (int i = 0; i < serials.length; i++) {
                    for (Bike bk : Storage.getAll_bikes()) {
                        if (bk.serial_number == serials[i]) {
                            for (Shop sh : Storage.getAll_shops()) {
                                if (sh.title.equals(shop)) {
                                    sh.add_bike(bk);
                                }
                            }
                        }
                    }
                }
            }

            case 3 -> {
                String title = input_str("Введите название магазина: ");
                int art = input_int("Введите артикул: ");
                int pass = input_int("Введите паспорт клиента: ");

                for (Shop sh : Storage.getAll_shops()) {
                    if (sh.title.equals(title)) {
                        if (sh.find_client(pass) != null) {
                            sh.sell_bike(art, sh.find_client(pass));
                        } else {
                            Client person = new Client(input_str("Имя клиента: "), pass);
                            sh.sell_bike(art, person);
                        }
                        break;
                    }
                }
            }

            case 4 -> {
                String room = input_str("Введите название мастерской: ");
                for (FixRoom fixRoom : Storage.getAll_rooms()) {
                    if (fixRoom.title.equals(room)) {
                        int pass = input_int("Введите паспорт клиента: ");
                        int seria = input_int("Введите серийный номер велосипеда: ");
                        int d = input_int("Введите требуемый диаметр колес: ");
//                        fixRoom.fix_bike(pass, seria, d);
                    }
                }
            }
            case 5 -> {
                String title = input_str("Введите название магазина: ");
                for (Shop sh : Storage.getAll_shops()) {
                    if (sh.title.equals(title)) {
                        System.out.println(sh.title);
                        System.out.println("Каталог: ");
                        for (Bike bk : sh.bikes) {
                            System.out.println(bk.toString());
                        }
                    }
                    break;
                }
            }

            case 6 -> {
                String title = input_str("Введите название магазина: ");
                for (Shop sh : Storage.getAll_shops()) {
                    if (sh.title.equals(title)) {
                        System.out.println(sh.title);
                        System.out.println("Покупатели: ");
                        for (Client cl : sh.all_clients) {
                            System.out.println(cl.toString());
                            System.out.println("Покупки: ");
                            for (Bike bk : cl.purchased) {
                                System.out.println("-> " + bk.toString());
                            }
                        }
                    }
                    break;
                }
            }

            case 7 -> {
                int cl_pass = input_int("Введите паспорт клиента: ");
                for (Client client : Storage.getAll_byers()) {
                    if (client.getPassport() == cl_pass) {
                        System.out.println("Купленные велосипеды: ");
                        for (Bike bk : client.purchased) {
                            System.out.println(bk.toString());
                        }
                    }
                }
            }

            case 8 -> {
                int cl_pass = input_int("Введите паспорт клиента: ");
                for (Client client : Storage.getAll_byers()) {
                    if (client.getPassport() == cl_pass) {
                        System.out.println("Отремонтированные велосипеды: ");
                        for (Bike bk : client.fixed) {
                            System.out.println(bk.toString());
                        }
                    }
                }
            }

            case 9 -> {
                System.out.println("Все покупатели: ");
                for (Client cl : Storage.getAll_byers()) {
                    System.out.println(cl.toString());
                }
            }

            case 10 -> {
                String room = input_str("Введите название мастерской: ");
                for (FixRoom fixRoom : Storage.getAll_rooms()) {
                    if (fixRoom.title.equals(room)) {
                        System.out.println("Отремонтированные велосипеды: ");
                        for (FixRoom.Pair pr : fixRoom.fixed_bikes){
                            System.out.println(pr.first.toString() + pr.second.toString());
                        } break;
                    }
                }
            }
        }
    }

}