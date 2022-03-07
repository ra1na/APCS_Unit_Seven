import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDriver {

    public static void main (String[] args) throws FileNotFoundException {
        ScrabbleHelper myScrab = new ScrabbleHelper();
        System.out.println(myScrab.getWordList().get(66349));
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Boolean testisWord = myScrab.foundWord(scan.nextLine());

        System.out.print("Enter a word to test: ");
        if(testisWord) {
            System.out.println(input +" is a word!");

        } else {
            System.out.println(input +" is not a word! ");
        }
        System.out.println("Goodbye!");

//        ArrayList<String> matches = myScrab.findMatches("pre");
//        System.out.println(matches);
//        myScrab.sortWords(matches);
//        System.out.println(matches);
//        System.out.println(myScrab.getScores("bird"));
//        System.out.println(myScrab.getScores("quiz"));
//        ArrayList<String> sorted = myScrab.cheat("zequyl");
//        myScrab.sortByScores(sorted);
//        System.out.println(sorted);
    }


}
