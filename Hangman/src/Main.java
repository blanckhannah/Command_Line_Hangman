import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Let's play Hangman!");

// Print _ _ _
        String word = chooseRandomWord();
        int wordLength = word.length();
        String[] letters = word.split("");
        String[] underScores = new String[wordLength];
        for (int i = 0; i < wordLength; i++) {
            underScores[i] = "_ ";
        }
        for (int i = 0; i < wordLength; i++) {
            System.out.print(underScores[i]);
        }
        System.out.println(" ");
        // Initial number of guesses you have:
        int startingGuesses = 18;
        int numberOfGuesses = startingGuesses;
        System.out.println("You have " + numberOfGuesses + " guesses");

// Guess a letter loop
        for (int j = 0; j < startingGuesses; j++) {
            System.out.println("Guess a letter: ");
            String letterGuess = input.nextLine();
            for (int i = 0; i < wordLength; i++) {
                if (letterGuess.equals(letters[i])) {
                    underScores[i] = letterGuess;
                }
            }
            for (int i = 0; i < wordLength; i++) {
                System.out.print(underScores[i]);
            }
            numberOfGuesses--;
            System.out.println(" ");
            System.out.println("You have " + numberOfGuesses + " guesses left");
            System.out.println(" ");
            if (Arrays.equals(underScores, letters)) {
                System.out.println("Congratulations!");
                break;
            }
        }
        System.out.println("The word is " + word);
    }
    // program chooses a random word
    public static String chooseRandomWord(){
        String[] wordOptions = new String[]{"beekeeper", "bandwagon", "elevator", "sketch", "launcher", "wonder", "master", "snowman", "snowballs", "television", "backpack", "picture", "carpet", "chicken", "candle", "bamboo", "reading", "science", "container", "control", "problem", "solution", "library", "window", "welcome", "options", "computer", "planet", "digital", "coding", "challenge", "numbers", "adventure", "table", "artificial", "counter", "integer", "school", "headphones", "sweater"};
        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(wordOptions.length);
        String word = wordOptions[randomIndex];
        return word;
    }
}