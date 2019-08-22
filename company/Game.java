package com.company;

import java.util.Scanner;

public class Game {

    private String parasha;
    private String wrongGuesses;
    private String rightGuesses;
    private char userChar;
    private int lives;
    boolean hasWon;

    public Game (String fileName) {
        FileHolder fileHolder = new FileHolder(fileName);
        this.parasha = fileHolder.getRandomParasha().trim();
        this.lives = 6;
        this.wrongGuesses = "";
        this.rightGuesses = "";
        this.hasWon = false;

    }

    // Game getters
    public String getParasha () { return parasha; }

    public String getWrongGuesses () {
        return wrongGuesses;
    }

    public String getWrightGuesses () {
        return rightGuesses;
    }

    public boolean getHasWon () {
        return hasWon;
    }

    public int getLives () {
        return lives;
    }

    // Game methods

    public String getUnderscoreHint () {
        if (rightGuesses.equals(""))
            return parasha.replaceAll("[a-zA-z]", "_");

        return parasha.replaceAll("[a-zA-Z&&[^" + rightGuesses +"]&&[^" + rightGuesses.toUpperCase() +"]]", "_");
    }


    public void guessChar () {
        Scanner scanner = new Scanner(System.in);
        this.userChar = scanner.next().toLowerCase().charAt(0);

        if (this.wrongGuesses.indexOf(userChar) != -1 ||
                this.rightGuesses.indexOf(userChar) != -1 ||
                !Character.isLetter(userChar)) {
            System.out.println("you have already chose this letter or it's invalid char...\n\t please try again!");
            this.guessChar();
            return;
        }

        if (this.parasha.toLowerCase().indexOf(userChar) != -1 ) {
            rightGuesses = rightGuesses.concat(userChar + " ");
        }
        else {
            lives --;
            wrongGuesses = wrongGuesses.concat(userChar + "");
        }

    }

    public boolean gameEnded () {
        if (this.getUnderscoreHint().equalsIgnoreCase(parasha)) {
            hasWon = true;
            return true;
        }
        else if (lives <= 0)   // Check == 0 ?
            return true;

        return false;
    }
}

