package CashMachine;

import java.util.Scanner;

public class CreditCard {
    private Scanner scan = new Scanner(System.in);
    private int pin;
    private int cardNumber;
    private int accountBalance;
    private boolean isActive;


    public CreditCard(int pin, int cardNumber, int accountBalance, boolean isActive) {
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.isActive = isActive;
    }

    public int getPin() {
        return pin;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public int cashWithdrawal() {
        System.out.println("Enter the sum of money you wish to withdraw");
        int newAccountBalance;
        int withdraw = scan.nextInt();
        if (accountBalance >= withdraw) {
            newAccountBalance = accountBalance - withdraw;
            System.out.println("You have successfully withdraw your funds");
        } else {
            System.out.println("we are sorry but you don't have enough funds");
            newAccountBalance = accountBalance;
        }
        return newAccountBalance;
    }

    public int addFunds() {
        System.out.println("Enter the sum of money you wish to add to your account");
        int newAccountBalance;
        int newFunds = scan.nextInt();
        newAccountBalance = accountBalance + newFunds;
        return newAccountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int topupYourPhone() {
        System.out.println("Please choose your cell phone carrier");
        System.out.println("Press 1 for giffgaff");
        System.out.println("Press 2 for O2");
        System.out.println("Press 3 for EE");
        int carrier = scan.nextInt();
        System.out.println("Please enter a phone number you wish to top-up");
        int phoneNumber = scan.nextInt();
        System.out.println("Please enter the sum you would like to top-up your phone with");
        int sum = scan.nextInt();
        if (accountBalance >= sum) {
            System.out.println("You have successfully topped-up your account");
            setAccountBalance(accountBalance - sum);
        } else {
            System.out.println("we are sorry but you don't have enough funds to top up your phone");
            setAccountBalance(accountBalance);
        }
        return getAccountBalance();
    }
}
