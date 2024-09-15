package mvc2;

import java.util.ArrayList;
import java.util.List;

public class AnimalData {
    public static List<Object> createSampleData() {
        List<Object> data = new ArrayList<>();

        // Cows
        data.add(new Cow("34587120", 3, 6, 4));
        data.add(new Cow("76290485", 5, 0, 3));
        data.add(new Cow("19384756", 8, 9, 4));
        data.add(new Cow("28465139", 1, 3, 3));
        data.add(new Cow("57103862", 6, 7, 4));
        data.add(new Cow("80923471", 2, 11, 3));
        data.add(new Cow("46371829", 4, 2, 4));
        data.add(new Cow("65190342", 7, 5, 4));
        data.add(new Cow("92837465", 0, 8, 3));
        data.add(new Cow("13579246", 9, 1, 4));
        data.add(new Cow("24680135", 10, 10, 3));
        data.add(new Cow("35791240", 3, 0, 4));
        data.add(new Cow("46802351", 5, 8, 3));
        data.add(new Cow("57913462", 1, 7, 4));
        data.add(new Cow("68024573", 4, 4, 4));

        // two Goat
        data.add(new Goat("79135684"));
        data.add(new Goat("81246793"));

        return data;
    }
}