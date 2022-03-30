import java.util.Scanner;

public class Pet extends Entity {
    private int currHumanRanking;
    private Human[] humanPreferences;

    public Pet(Scanner sc) {
        super(sc);
    }

    public int getCurrHumanRanking() {
        return this.currHumanRanking;
    }

    public void setCurrHumanRanking(int rank) {
        this.currHumanRanking = rank;
    }

    public void setHumanPreferences(Human[] humans) {
        for(int i = 0; i < GS.size; i++) {
            humanPreferences = new Human[GS.size];
            int indexOfHuman = preferences[i];
            humanPreferences[i] = humans[--indexOfHuman];
        }
    }
}
