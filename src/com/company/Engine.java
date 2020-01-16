package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Engine {
    private static Engine SINGLE_INSTANCE = null;
    private Scanner scanner;
    private String fileName = "primeNumbers.txt";

    private  Engine() {
        scanner = new Scanner(System.in);
    }

    public void Run() {
        System.out.println("Please type:");
        System.out.print('>');
        String in = scanner.nextLine();
        try (OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream(fileName, true), StandardCharsets.UTF_8)){
            while (!(in.equals("exit"))) {

                if ( Number.tryParseInt(in)) {
                    int numberIn = Integer.parseInt(in);
                    if ( Number.isSimple(numberIn)) {
                        System.out.println("Number:" + numberIn + " is prime.");
                        wr.write(in);
                        wr.write(" ");
                        System.out.println("Prime number were written to the file.");
                    }
                    else {
                        System.out.println("Number:" + numberIn + " is not prime.");
                    }
                }
                else {
                    System.out.println("Please provide correct number or exit command.");
                }
                in = scanner.nextLine();
            }
            System.out.println("Program ended.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Engine getInstance() {
        synchronized (Engine.class) {
            if(SINGLE_INSTANCE == null) {
                SINGLE_INSTANCE = new Engine();
            }
        }
        return SINGLE_INSTANCE;
    }
}
