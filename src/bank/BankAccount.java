package bank;

import java.util.Scanner;
import java.text.NumberFormat;

/**

 @author Peter
 */
public class BankAccount{

    private String username;
    private int pin;
    private double balance;

    public BankAccount(String u, int p){
        username = u;
        pin = p;
        balance = 0;
    }

    public String getUsername(){
        return username;
    }

    // GREAT SECURITY MATE
    public int getPin(){
        return pin;
    }

    public String getBalance(){
        NumberFormat f = NumberFormat.getCurrencyInstance();
        return f.format(balance);
    }

    public void setUserName(String s){
        username = s;
    }

    public void setPin(){
        System.out.println("Please enter your old PIN to continue.");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input != pin){
            System.out.println("I'm sorry. The PIN you entered is incorrect.\nAction failed.");
        }
        else{
            System.out.println("Enter in your new PIN.");
            input = sc.nextInt();
            int tempPin = input;
            System.out.println("Reenter your new PIN to confirm");
            input = sc.nextInt();
            if (tempPin == input){
                System.out.println("Your PIN has been successfully set!");
            }
            else{
                System.out.println("I'm sorry. The two values do not match.\nAction failed.");
            }
        }
    }

    public boolean withdraw(double amount){
        if (amount <= 0){
            return false;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(username + ", please enter your PIN.");
        int input = sc.nextInt();
        if (input != pin){
            System.out.println("That PIN is not correct.\nAction failed.");
            return false;
        }
        int hundredDollar, twentyDollar, fiveDollar, oneDollar;
        int quarter, nickel, penny;
        hundredDollar = twentyDollar = fiveDollar = oneDollar = 0;
        quarter = nickel = penny = 0;
        if (amount > balance){
            System.out.println("You do not have sufficient funds in your account.");
            return false;
        }
        //  Removes the parameter amount from the actual object's balance
        balance -= amount;

        //  Dishes out denominations, removing from the parameter value until all the money has been handed out
        while (amount > 100){
            hundredDollar++;
            amount -= 100;
        }
        while (amount > 20){
            twentyDollar++;
            amount -= 20;
        }
        while (amount > 5){
            fiveDollar++;
            amount -= 5;
        }
        while (amount > 1){
            oneDollar++;
            amount -= 1;
        }
        while (amount > .25){
            quarter++;
            amount -= .25;
        }
        while (amount > .05){
            nickel++;
            amount -= .05;
        }
        while (amount > 0){
            penny++;
            amount -= .01;
        }

        System.out.println("You have been handed: ");
        if (hundredDollar != 0)
            System.out.println(hundredDollar + " hundred dollar bill(s)");
        if (twentyDollar != 0)
            System.out.println(twentyDollar + " twenty dollar bill(s)");
        if (fiveDollar != 0)
            System.out.println(fiveDollar + " five dollar bill(s)");
        if (oneDollar != 0)
            System.out.println(oneDollar + " one dollar bill(s)");
        if (quarter != 0)
            System.out.println(quarter + " quarter(s)");
        if (nickel != 0)
            System.out.println(nickel + " nickel(s)");
        if (penny != 0)
            System.out.println(penny + " one cent thing(s)");
        System.out.println("Your new balance is: " + getBalance() + ".");
        return true;
    }

    public boolean deposit(double amount){
        if (amount <= 0){
            System.out.println("Please enter in a value greater than 0.\nAction failed.");
            return false;
        }
        else{
            balance += amount;
            System.out.println("Transaction successful! The balance for " + username + " is "
                    + getBalance() + ".");
            return true;
        }
    }
}
