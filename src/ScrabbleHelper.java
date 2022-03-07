import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleHelper {

private ArrayList<String> wordList = new ArrayList<>();

    public ScrabbleHelper() throws FileNotFoundException {
        Scanner input = new Scanner(new File("files/enable.txt"));

        while (input.hasNext()) {
            wordList.add(input.next());
        }
    }


    public ArrayList<String> getWordList() {
        return wordList;
    }


    public boolean foundWord(String word) {
        int min = 0;
        int max = wordList.size() - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (wordList.get(mid).equals(word))
                return true;
            else if (wordList.get(mid).compareToIgnoreCase(word) > 0)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return false;
    }


    public ArrayList<String> findMatches(String pattern){
        ArrayList<String> matches = new ArrayList<String>();

        for (String s : wordList) {
            if (s.indexOf(pattern) >= 0) {
                matches.add(s);
            }
        }
        return matches;
    }

    public ArrayList<String> cheat (String tiles) {
        ArrayList<String> goodWords = new ArrayList<String>();
        for (String s: wordList) {
            boolean makesWord = true;
            ArrayList<Character> letters = new ArrayList<Character>();
            for (int j = 0; j < tiles.length(); j++) {
                letters.add(tiles.charAt(j));
            }
            for (int k=0; k<s.length(); k++){
                if (letters.contains(s.charAt(k))){
                    letters.remove(letters.indexOf(s.charAt(k)));
                }
                else{
                    makesWord = false;
                    break;
                }
            }
            if(makesWord){
                goodWords.add(s);
            }
        }
        return goodWords;
    }

    public void sortWords(ArrayList<String> unsorted){
        for( int j=0; j<unsorted.size()-1;j++){
            int minIndex = j;
            for (int k = j+1; k<unsorted.size();k++){
                if(unsorted.get(k).length()< unsorted.get(minIndex).length()){
                    minIndex = k;
                }}
            String temp = unsorted.get(j);
            unsorted.set(j, unsorted.get(minIndex));
            unsorted.set(minIndex, temp);
        }
    }

    public int getScores(String word) {
        int score = 0;
        int[] scores = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            score += scores[index];
        }
        return score;
    }

    public void sortByScores(ArrayList<String> arrList){
        for( int x=1; x< arrList.size();x++){
            String temp = arrList.get(x);
            int possibleIndex = x;
            while (possibleIndex > 0 && getScores(temp) > getScores(arrList.get(possibleIndex - 1))) {
                arrList.set(possibleIndex, arrList.get(possibleIndex-1));
                possibleIndex--;
            }
            arrList.set(possibleIndex,temp);
        }
    }
}