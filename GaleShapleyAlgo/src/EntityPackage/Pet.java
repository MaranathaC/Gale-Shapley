package EntityPackage;

import EntityPackage.Entity;
import EntityPackage.Human;

import java.util.Scanner;
import java.util.Stack;

public class Pet extends Entity {
    public Pet(Scanner sc, int index) {
        super(sc, index);
    }

    public boolean acceptAdoption(Human human, Stack<Human> stackOfUnmatched) {
        if(matchedEntity == null) {
            matchedEntity = human;
            return true;
        } else {
            if(rankings[matchedEntity.getIndex()] > rankings[human.getIndex()]) {
                matchedEntity.unmatched();
                stackOfUnmatched.push((Human)matchedEntity);
                matchedEntity = human;
                return true;
            } else {
                return false;
            }
        }
    }
}
