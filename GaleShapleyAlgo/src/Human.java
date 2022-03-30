import java.util.Scanner;

public class Human extends Entity{
    private int nextAdoption; // preference index pointer
    private Pet[] petPreferences;

    public Human(Scanner sc) {
        super(sc);
        nextAdoption = 0;
    }

    public void adopt() {
        matchedEntity = petPreferences[nextAdoption++];
        matchedEntity.matchedEntity = this;
        matched = true;
        matchedEntity.matched = true;
    }

    public void setPetPreferences(Pet[] pets) {
        petPreferences = new Pet[GS.size];
        for(int i = 0; i < GS.size; i++) {
            int indexOfPet = preferences[i];
            petPreferences[i] = pets[--indexOfPet];
        }
    }
}
