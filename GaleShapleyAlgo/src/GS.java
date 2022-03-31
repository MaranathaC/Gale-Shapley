import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class GS {
    protected static int size; // num of people and pets
    private Human[] humans; // arr of names of people
    private Pet[] pets; // arr of names of pets
    private int numOfMatch;
    private Stack<Human> stackOfUnmatched;

    public GS() {
        Scanner sc;
        stackOfUnmatched = new Stack<>();
        try {
            sc = new Scanner(new File("GaleShapleyAlgo/src/program1data.txt"));

            // initializes array sizes
            size = sc.nextInt();
            sc.nextLine();
            humans = new Human[size + 1];
            pets = new Pet[size + 1];
            numOfMatch = 0;

            // initialize arr of names of people
            for(int i = 1; i <= size; i++) {
                humans[i] = new Human(sc, i);
                stackOfUnmatched.push(humans[i]);
            }

            // initialize 2d arr of ranking of pets
            for(int i = 1; i <= size; i++) {
                humans[i].setPreferences(sc);
                sc.nextLine();
            }

            // initialize arr of name of pets
            for(int i = 1; i <= size; i++) {
                pets[i] = new Pet(sc, i);
            }

            // initializes ranking of humans
            for(int i = 1; i <= size; i++) {
                pets[i].setPreferences(sc);
            }

            sc.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void match() {
        while (!stackOfUnmatched.isEmpty()) {
            Human nextMatch = stackOfUnmatched.pop();
            nextMatch.adopt(pets, stackOfUnmatched);
        }
        for (int i = 1; i <= size; i++) {
            System.out.println(humans[i].getName() + " / " + humans[i].matchedEntity.getName());
        }
    }
}
