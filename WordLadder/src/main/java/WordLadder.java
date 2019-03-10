import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;

public class WordLadder {

        static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        public static void main(String[] args) throws FileNotFoundException
        {
            System.out.println("Welcome to my Word Ladder!");
            System.out.println();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // input words
                System.out.print("Input word 1: ");
                String first = scanner.nextLine();
                System.out.print("Input word 2: ");
                String last = scanner.nextLine();
                if (first.length() != last.length()) {
                    continue;
                }

                // load words with equal length
                Scanner sc = new Scanner(new File("dictionary.txt")); // get dictionary
                HashSet<String> set = new HashSet<String>();
                loadDictionary(first.length(), sc, set);
                if (!(set.contains(first) && set.contains(last))) { //check whether first/last is in the dictionary
                    continue;
                }

                // find ladder
                Stack<Stack<String>> ladders = prepareLadderStacks(first);
                Stack<String> result = wordLadder(set, ladders, last);//core logical part
                // output
                System.out.println("Ladder from " + first + " to " + last + ":");
                printLadder(result);
                // continue
                System.out.println("Press enter to continue");
            }
        }

        public static Stack<Stack<String>> prepareLadderStacks(String first)
        {
            Stack<String> ladder = new Stack<String>();
            ladder.push(first);
            Stack<Stack<String>> ladders = new Stack<Stack<String>> ();
            ladders.push(ladder);
            return ladders;
        }

        private static void loadDictionary(int len, Scanner sc, HashSet<String> set)
        {
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                if (word.length() == len) {
                    set.add(word);
                }
            }
        }

        // Implement algorithm to get wordladder using Breath-First-Search
        private static Stack<String> wordLadder(HashSet <String> set, Stack<Stack<String>> ladders, String last)
        {
            if (ladders.size() == 0) {
                Stack<String> stk = new Stack<String>();
                stk.push("No ladder found!");
                return stk;
            }

            Stack<Stack<String>> longerLadder = new Stack<Stack<String>> ();
            int laddersSize = ladders.size();

            for (int k = 0; k < laddersSize; k++) {
                Stack<String> lad = ladders.pop();
                String top = lad.lastElement();
                for (int i = 0; i < top.length(); i++) {
                    // replace the letter on position i
                    StringBuilder newWord = new StringBuilder(top);
                    for (int j = 0; j < 26; j++) {
                        newWord.setCharAt(i, alphabet[j]);
                        if (newWord.toString().equals(last)) {
                            lad.push(newWord.toString());
                            lad.push(newWord.toString());
                        } else if (!newWord.toString().equals(top) && set.contains(newWord.toString())) {
                            set.remove(newWord.toString());
                            longerLadder.push((Stack<String>)lad.clone());
                            lad.pop();
                        }
                    }
                }
            }

            return wordLadder(set, longerLadder, last);
        }

        // Only required for testing
        private static String testing(String word1, String word2)
        {
            String result = "cat->cot->dot->dog";
            return result;
        }

        private static void printLadder(Stack<String> stk)
        {
            int len = stk.size()-1;
            for (int i = 0; i < len; i++) {
                System.out.print(stk.elementAt(i) + "->");
            }
            System.out.print(stk.elementAt(len));
            System.out.println();
        }


}
