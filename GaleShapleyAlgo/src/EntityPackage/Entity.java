package EntityPackage;

import java.util.Scanner;

/**
 * Class to represent an Entity
 * Entity is represented by name and index
 * Stores preferences and its inverse rankings of another Entity class
 * Functionality includes get name, index, and name of match, and unmatched
 * @author Natha Chiu
 */

public class Entity {
    protected String name;
    protected int index;
    protected int[] preferences; // preference list of some Entities
    protected int[] rankings; // inverse of preferences
    protected Entity matchedEntity; // match

    /**
     * constructor
     * pre: none
     * post: none
     */
    private Entity() {
        // default constructor cannot be accessed
    }

    /**
     * constructor, params: Scanner, int
     * pre: Scanner has a properly formatted txt file
     * post: name and index are initialized
     */
    public Entity(Scanner sc, int index) {
        this.name = sc.nextLine();
        this.index = index;
    }

    /**
     * getter for name
     * pre: none
     * post: returns entity name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for index
     * pre: none
     * post: returns entity index
     */
    public int getIndex() {
        return index;
    }

    /**
     * setter for preferences and rankings
     * pre: Scanner has a properly formatted txt file, and size is correct
     * post: initializes preferences and its inverse rankings for look up
     */
    public void setPreferences(Scanner sc, int size) {
        preferences = new int[size + 1]; // initializes arrays
        rankings = new int[size + 1];

        for (int i = 1; i <= size; i++) { // index 0 is omitted
            preferences[i] = sc.nextInt();  // key: ranking, value: index
        }

        for(int i = 1; i <= size; i++) {
            int index = preferences[i];
            rankings[index] = i; // key: index, value: ranking
        }
    }

    /**
     * getter for name of matched
     * pre: none
     * post: return name of match or error
     */
    public String getNameOfMatch() {
        if(matchedEntity == null)
            return "ERROR: Has not matched";
        return matchedEntity.getName();
    }

    /**
     * unmatched with matchedEntity
     * pre: none
     * post: set matchedEntity to null
     */
    public void unmatched() {
        matchedEntity = null;
    }
}
