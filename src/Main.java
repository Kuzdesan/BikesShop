import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, MyException {

        Shop SuperWheel = new Shop("sup");
        Shop HotWheel = new Shop("hot");
        FixRoom fixed = new FixRoom("fix");

//        автоматическое создание велосипедов
//        ArrayList<Bike> random_bikes = new ArrayList<>();
//        random_bikes.addAll(Storage.add_bike());
        int ch = 1;
        do {
            Dialog.out();
            Dialog.choose(ch = Dialog.input_int(""));
        }
        while (ch != 0);

    }

}
