import java.util.Scanner;

public class Entity {
    protected String name;
    protected int[] preferences;
    protected boolean matched;
    protected Entity matchedEntity;

    public Entity() {
        name = "NAME";
        matched = false;
    }

    public Entity(Scanner sc) {
        this.name = sc.nextLine();
        matched = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPreferences() {
        return preferences;
    }

    public void setPreferences(Scanner sc) {
        preferences = new int[GS.size];
        for (int i = 0; i < GS.size; i++) {
            preferences[i] = sc.nextInt();
        }
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public String getNameOfMatch() {
        return matchedEntity.getName();
    }

}
