package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = "avi.txt";
        Game game = new Game(fileName);

        System.out.println("welcome to 'find the parasha' !");
        System.out.println("the computer will choose a parasha, and you should guess each letter of the parasha one by one.");
        System.out.println("you can have only " + (game.getLives()-1) + " mistakes");
        System.out.println("one mistakes more then that and you will lose the game");
        System.out.println("the game start now good luck!");

        while (!game.gameEnded()){
            System.out.println("you have guessed " + game.getWrongGuesses().length() + " wrong guesses");
            if (!game.getWrongGuesses().equals(""))
                System.out.println("these are the letters you chose wrong: " + game.getWrongGuesses());
            System.out.println("please guess a new char");
            System.out.println(game.getUnderscoreHint());
            game.guessChar();
        }

        if(game.hasWon) {
            System.out.println(game.getParasha());
            System.out.println("congratulations you won!!");
        }
        else {
            System.out.println("I'm sorry you lost! \n better luck next time..");
            System.out.println("the right answer is: " + game.getParasha());
        }
    }
}
