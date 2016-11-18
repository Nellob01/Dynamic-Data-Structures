package com.company;

/**
 * Created by noelaniekan on 11/16/16.
 */
public class Transaction {
    private String name;
    private int amount;
    private String WhatWouldYouLikeToDo;

    public void chooseName() throws Exception {
        boolean goBack = true;
        while (goBack == true) {
            System.out.println("Please enter name");
            name = ATM.scanner.nextLine();
            System.out.println("Welcome," + name);
            if (name.equalsIgnoreCase("")) {
                throw new Exception("Please enter valid name");
            }


            if (ATM.person.containsKey(name)) {
                goBack = false;
            }


            if (!ATM.person.containsKey(name)) {
                System.out.println("Would you like to open an account?" + "[y/n]");
                String answer = ATM.scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    ATM.person.put(name, 100.00);
                    System.out.println(ATM.person.get(name));
                    goBack = false;
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Have a nice day!..");
                    goBack = true;


                }
            }


        }
    }




    public boolean chooseWhatWouldYouLikeToDo() throws Exception {
        System.out.println("choose what would you like To do [Balance/withdraw funds/close account/cancel]");
        WhatWouldYouLikeToDo = ATM.scanner.nextLine();

        if (WhatWouldYouLikeToDo.equalsIgnoreCase("balance")) {
            System.out.println(ATM.person.get(name));

        } else if (WhatWouldYouLikeToDo.equalsIgnoreCase("withdraw funds")) {
            System.out.println("How much do you want to withdraw");
            amount = ATM.scanner.nextInt();
        }
            if (amount > ATM.person.get(name)) {
                throw new Exception("Insufficient Funds");
            } else if (amount <= ATM.person.get(name)) {
                System.out.println("Available Balance " + (ATM.person.get(name) - amount) + " Take cash below. ");
                Double balance = (ATM.person.get(name) - amount);
                ATM.person.put(name, balance);
            }
            System.out.println("$" + amount);


            {
                if (WhatWouldYouLikeToDo.equalsIgnoreCase("close account")) {
                    System.out.println("close account [y/n]");
                    String response = ATM.scanner.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        System.out.println("Your account has been close!");
                        ATM.person.remove(name);
                        return (false);


                    } else if (WhatWouldYouLikeToDo.equalsIgnoreCase("n")) {
                        System.out.println("Please enter name");
                    }


                }


            }
            if (WhatWouldYouLikeToDo.equalsIgnoreCase("cancel")) {
                System.out.println(" Thank you please come again...");
                return (false);


            }
            return (true);
        }
    }







