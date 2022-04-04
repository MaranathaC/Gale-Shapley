package EntityPackage;

import java.util.Scanner;
import java.util.Stack;

/**
 * Class to represent Pet
 * subclass of Entity
 * Doesn't store extra variables
 * Extra functionality includes accepting adoption
 * @author Natha Chiu
 */

public class Pet extends Entity {
    /**
     * constructor, params: Scanner, int
     * pre: Scanner has a properly formatted txt file
     * post: call constructor in Entity
     */
    public Pet(Scanner sc, int index) {
        super(sc, index);
    }

    /**
     * acceptAdoption
     * pre: human and stack are initialized
     * post: rejects adoption or replaces current match with human,
     *       current match is pushed to stack
     */
    public boolean acceptAdoption(Human human, Stack<Human> stackOfUnmatched) {
        if(matchedEntity == null) { // hasn't match; accepts adoption
            matchedEntity = human;
            return true;
        } else {
            if(rankings[matchedEntity.getIndex()] > rankings[human.getIndex()]) { // adoption offer is better
                matchedEntity.unmatched(); // current match unmatched
                stackOfUnmatched.push((Human)matchedEntity); // current match is added to stack
                matchedEntity = human; // replaces current match with new human
                return true;
            } else {
                return false; // adoption offer is worse than current
            }
        }
    }
}
