package com.company;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Created by noelaniekan on 11/16/16.
 */
public class ATM {
    public static Scanner scanner = new Scanner(System.in);
    public static Transaction transaction = new Transaction();
    public static HashMap<String, Double> person = new HashMap();


    public static void main (String[] args) throws Exception{
        System.out.println("Welcome, customer");

        transaction.chooseName();




            while (true) {
                boolean keepRunning = transaction.chooseWhatWouldYouLikeToDo();
                if (!keepRunning) {
                    transaction.chooseName();
                }
            }






    }


}
