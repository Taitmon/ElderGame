package com.company;

import java.util.*;

public class BingoNumbers
{

    HashSet <Integer> numbersList = new HashSet<>();
    Scanner input = new Scanner(System.in);
    boolean gameOver = true;


    public static void main(String[] args)
    {
        BingoNumbers numbers = new BingoNumbers();
        numbers.run();
    }


    public void run()
    {
        System.out.println("Please enter one of the following commands.     |");
        System.out.println("================================================|");
        System.out.println("\"Call\"  to call a number for the elders.        |");
        System.out.println("\"Called\"  to call a number for the elders.      |");
        System.out.println("\"Verify\"  to check if a number has been called. |");
        System.out.println("\"Challenge\"  to call a number for the elders.   |");
        System.out.println("\"Bingo\"  to call a number for the elders.       |");
        System.out.println("================================================|");


        while(gameOver)
        {
            System.out.println("------------------------------------------------|");
            System.out.println("Please enter a command.                         |");
            System.out.println("------------------------------------------------|");
            String command = input.next();
            switch (command)
            {
                case "call":
                    addCall();
                    break;
                case "called":
                    printCalled();
                    break;
                case "verify":
                    verify();
                    break;
                case "challenge":
                    removeNumber();
                    break;
                case "bingo":
                    resetNumbers();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    System.out.println("Invalid command.");

            }
        }
    }

    private void addCall()
    {
        int callNumber = input.nextInt();

        boolean outOfRange = 1 > callNumber || 75 < callNumber;

        if (outOfRange)
        {
            System.out.println("Invalid Number, please try again.");
        }
        else if (numbersList.contains(callNumber))
        {
            System.out.println(callNumber + " already called!");
        }
        else
        {
            numbersList.add(callNumber);
            System.out.println("Added " + callNumber);
        }
        return;
    }

    public void printCalled()
    {
            System.out.println(numbersList);
    }

    public void verify()
    {
        int verifyNumber = input.nextInt();
        boolean outOfRange = 1 > verifyNumber || 75 < verifyNumber;

        if (outOfRange)
        {
            System.out.println("Invalid Number, please try again.");
        }
        else if (numbersList.contains(verifyNumber))
        {
            System.out.println(verifyNumber + " already called!");
        }
        else
        {
            System.out.println(verifyNumber + " not called!");
        }
    }

    public void removeNumber()
    {
        int removeNum = input.nextInt();
        boolean outOfRange = 1 > removeNum || 75 < removeNum;
        if (outOfRange)
        {
            System.out.println("Invalid Number, please try again.");
        }
        else if (numbersList.contains(removeNum))
        {
            numbersList.remove(removeNum);
            System.out.println(removeNum + " was removed.");
        }
        else
        {
            System.out.println(removeNum + " has not been called.");
        }
    }


    public void resetNumbers()
    {
        if (numbersList.size() >= 4)
        {
            System.out.println("Congratulations, you won a fruit cake!!!");
            numbersList.clear();
            System.out.println("Game was reset.");
        }
        else
        {
            System.out.println("Cheater!");
        }
    }

    public void exit()
    {
        gameOver = false;
        System.out.println("Terminating program.");
        System.out.println("Program terminated.");
        System.out.println("Thank you for playing the Elder Game.");
    }
}
