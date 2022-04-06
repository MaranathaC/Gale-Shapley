package EntityPackage;

import java.util.Scanner;
import java.util.Stack;

/**
 * Class to represent Human
 * Subclass of Entity
 * Stores a pointer of next adoption
 * Extra functionality includes adopting a pet
 * @author Natha Chiu
 */

public class Human extends Entity {
    private int nextAdoption; // preference index pointer

    /**
     * constructor, params: Scanner, int
     * pre: Scanner has a properly formatted txt file
     * post: call constructor in Entity, and pointer initialized to 1
     */
    public Human(Scanner sc, int index) {
        super(sc, index);
        nextAdoption = 1; // starting from 1st in preference list
    }

    /**
     * adopt
     * pre: pets[] and stack are initialized
     * post: adopts a pet (match with another entity)
     */
    public void adopt(Pet[] pets, Stack<Human> stackOfUnmatched) {
        boolean matched = false;
        while (!matched) {
            int index = preferences[nextAdoption++]; // get index of next pet
            if(pets[index].acceptAdoption(this, stackOfUnmatched)) { // proposes to pet
                matchedEntity = pets[index]; // match if pet accepts adoption
                matched = true;
            }
        }
    }
}
