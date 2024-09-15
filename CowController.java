package mvc2;

import java.util.List;

public class CowController {
    private List<Object> cowsAndGoats;
    private int totalMilk;
    private CowView view;

    public CowController() {
        this.cowsAndGoats = AnimalData.createSampleData();
        this.totalMilk = 0;
        this.view = new CowView(this);
    }

    public void processCow(String cowId) {
        try {
            int id = Integer.parseInt(cowId);
            if (id < 10000000 || id > 99999999) {
                view.showError("Cow ID must be 8 digits and not start with 0.");
                return;
            }

            Object animal = findAnimal(cowId);
            if (animal == null) {
                view.showError("Animal not found.");
                return;
            }

            if (animal instanceof Cow) {
                processCowMilking((Cow) animal);
            } else { // Goat
                view.showGoatResult();
            }
        } catch (NumberFormatException e) {
            view.showError("Invalid cow ID. Please enter a number.");
        }
    }

    private void processCowMilking(Cow cow) {
        if (cow.getTeats() != 4) {
            view.showError("Cow be suitable for milking.");
            cow.regenerateTeat();
            return;
        }

        int milkProduced = cow.milk();
        totalMilk += milkProduced;
        view.showCowResult(milkProduced, totalMilk);
    }

    public void chaseGoatAway() {
        view.displayReport("The goats were kicked out of the milking machine"); 
    }

    private Object findAnimal(String cowId) {
        for (Object animal : cowsAndGoats) {
            if ((animal instanceof Cow && ((Cow) animal).getId().equals(cowId)) ||
                (animal instanceof Goat && ((Goat) animal).getId().equals(cowId))) {
                return animal;
            }
        }
        return null;
    }
}