import EntityPackage.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Class to preform Gale-Shapley Algorithm
 * Stores size (number of humans and pets), and array of humans and pets
 * Stack stores all humans who doesn't have a match
 * Functionality includes matching humans to pets
 * @author Natha Chiu
 */

public class GS {
    protected static int size; // num of people and pets
    private Human[] humans; // arr of names of people
    private Pet[] pets; // arr of names of pets
    private Stack<Human> stackOfUnmatched;

    /**
     * constructor
     * pre: program1data.txt in the right directory and format is correct
     * post: humans and pets are stored in arrays. Humans are also in stack awaiting for matching.
     *       size initializes to number of humans and pets
     */
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

            // initialize arr of names of people
            for(int i = 1; i <= size; i++) {
                humans[i] = new Human(sc, i);
                stackOfUnmatched.push(humans[i]);
            }

            // initialize 2d arr of ranking of pets
            for(int i = 1; i <= size; i++) {
                humans[i].setPreferences(sc, size);
                sc.nextLine();
            }

            // initialize arr of name of pets
            for(int i = 1; i <= size; i++) {
                pets[i] = new Pet(sc, i);
            }

            // initializes ranking of humans
            for(int i = 1; i <= size; i++) {
                pets[i].setPreferences(sc, size);
            }

            sc.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * match
     * pre: arrays, stack, and size are properly initialized
     * post: all humans and pets form some matches
     */
    public void match() {
        while (!stackOfUnmatched.isEmpty()) { // runs until every human has a pet
            Human nextMatch = stackOfUnmatched.pop(); // next human
            nextMatch.adopt(pets, stackOfUnmatched); // adopts from an array of pets
        }
        for (int i = 1; i <= size; i++) {
            // print all matches
            System.out.println(humans[i].getName() + " / " + humans[i].getNameOfMatch());
        }
    }
}
