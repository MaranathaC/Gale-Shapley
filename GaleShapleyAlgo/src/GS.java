import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GS {
    public static int size; // num of people and pets
    private Human[] humans; // arr of names of people
    private Pet[] pets; // arr of names of pets
    private int numOfMatch;

    public GS() {
        Scanner sc;
        try {
            sc = new Scanner(new File("GaleShapleyAlgo/src/program1data.txt"));

            // initializes array sizes
            size = sc.nextInt();
            sc.nextLine();
            humans = new Human[size];
            pets = new Pet[size];
            numOfMatch = 0;

            // initialize arr of names of people
            for(int i = 0; i < size; i++) {
                humans[i] = new Human(sc);
            }

            // initialize 2d arr of ranking of pets
            for(int i = 0; i < size; i++) {
                humans[i].setPreferences(sc);
                sc.nextLine();
            }

            // initialize arr of name of pets
            for(int i = 0; i < size; i++) {
                pets[i] = new Pet(sc);
            }

            // initializes ranking of humans
            for(int i = 0; i < size; i++) {
                pets[i].setPreferences(sc);
            }

            for(int i = 0; i < size; i++) {
                humans[i].setPetPreferences(pets);
                pets[i].setHumanPreferences(humans);
            }

            sc.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void match() {
        for(int i = 0; i < size; i++) {
            humans[i].adopt();
            System.out.println(humans[i].getNameOfMatch());
        }
    }

    public static void main(String[] args) {
        GS gs = new GS();
        gs.match();
    }
}
