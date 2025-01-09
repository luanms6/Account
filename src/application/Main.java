package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import exceptions.DomainException;

public class Main{
    public static void main(String[] args){
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine(); //Consumir quebra de linha pendente
            String holder = sc.nextLine();
            System.out.print("Balance: ");
            double balance = sc.nextDouble();
            System.out.print("WithdrawLimit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter the amount withdraw: ");
            double amount = sc.nextDouble();

            account.withdrawLimit(amount);
            System.out.printf("New balance %.2f%n", account.getBalance());
        }

        catch(DomainException e){
            System.out.print("Withdram error: " + e.getMessage());
        }

        catch(RuntimeException e){
            System.out.print("Unexpected error: ");
        }
        
        sc.close();
    }
}