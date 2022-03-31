import java.util.Scanner;
import java.util.Stack;

public class Human extends Entity{
    private int nextAdoption; // preference index pointer

    public Human(Scanner sc, int index) {
        super(sc, index);
        nextAdoption = 1;
    }

    public void adopt(Pet[] pets, Stack<Human> stackOfUnmatched) {
        boolean matched = false;
        while (!matched) {
            int index = preferences[nextAdoption++];
            if(pets[index].acceptAdoption(this, stackOfUnmatched)) {
                matchedEntity = pets[index];
                matched = true;
            }
        }
    }
}
