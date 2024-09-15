package mvc2;

import java.util.Random;

public class Cow {
    private String id;
    private int ageYears;
    private int ageMonths;
    private int teats;

    public Cow(String id, int ageYears, int ageMonths, int teats) {
        this.id = id;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.teats = teats;
    }

    // Get and set
    public String getId() {
        return id;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public int getTeats() {
        return teats;
    }

    public void setTeats(int teats) {
        this.teats = teats;
    }

    public int milk() {
        if (teats == 4) {
            if (Math.random() < 0.05) { // 5% teat reduction
                teats--;
            }
        }
        return ageYears + ageMonths; // Milk product
    }

    public void regenerateTeat() {
        if (teats == 3) {
            if (Math.random() < 0.2) { // 20% teat regen
                teats++;
            }
        }
    }
}