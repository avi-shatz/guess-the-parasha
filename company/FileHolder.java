package com.company;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class FileHolder {
    private ArrayList <String> listOfParasha;


    public  FileHolder (String fileName){

        this.listOfParasha = new ArrayList();
        File file = new File(fileName);

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                this.listOfParasha.add(fileScanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(" no such file");
        }

    }

    public String getRandomParasha () {
            return this.listOfParasha.get((int) (Math.random() * this.listOfParasha.size()));
    }

    public void printList () {
        for (String i : this.listOfParasha) {
            System.out.println(i);
        }
    }

}
