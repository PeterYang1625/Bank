package bank;

/**

 @author Peter
 */
import java.util.Scanner;

public class Bank{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount dank = new BankAccount("MDang", 1234);
        BankAccount potato = new BankAccount("PotatoHead", 1352);
        BankAccount food = new BankAccount("RAM", 5973);
        dank.deposit(200);
        potato.deposit(243);
        food.deposit(134);
        dank.withdraw(201);
        potato.withdraw(163.24);
        food.withdraw(10);
    }
}