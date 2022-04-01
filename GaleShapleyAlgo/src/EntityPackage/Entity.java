package EntityPackage;

import java.util.Scanner;

public class Entity {
    protected String name;
    protected int index;
    protected int[] preferences;
    protected int[] rankings;
    protected Entity matchedEntity;


    public Entity() {
        name = "NAME";
    }

    public Entity(Scanner sc, int index) {
        this.name = sc.nextLine();
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public int[] getPreferences() {
        return preferences;
    }

    public void setPreferences(Scanner sc, int size) {
        preferences = new int[size + 1];
        rankings = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            preferences[i] = sc.nextInt();
        }

        for(int i = 1; i <= size; i++) {
            int index = preferences[i];
            rankings[index] = i; // key: index, value: ranking in preference list
        }
    }

    public void unmatched() {
        matchedEntity = null;
    }

    public String getNameOfMatch() {
        return matchedEntity.getName();
    }

}
