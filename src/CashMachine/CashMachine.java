package CashMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class CashMachine {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        boolean logged = false;
        CashMachine machine = new CashMachine();

        CreditCard card = null;
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(new CreditCard(1234, 11112222, 100, true));
        creditCards.add(new CreditCard(5678, 33334444, 1000, false));
        creditCards.add(new CreditCard(9123, 55556666, 200, true));
        creditCards.add(new CreditCard(4567, 77778888, 5000, true));
        System.out.println("Please enter your PIN");

        int pin = scan.nextInt();
        for (int x = 0; x < creditCards.size(); x++) {
            if (pin == creditCards.get(x).getPin()) {
                System.out.println("You have entered a correct PIN number");
                card = creditCards.get(x);
                logged = true;
            }
        }
        if (logged) {
            while (running) {
                if (card.isActive()) {

                    machine.showMenu();
                    int menu = scan.nextInt();
                    switch (menu) {
                        case 1:
                            System.out.println("Cash withdrawal");
                            card.setAccountBalance(card.cashWithdrawal());
                            System.out.println("Your account balance is " + card.getAccountBalance());
                            break;
                        case 2:
                            System.out.println(card.getAccountBalance());
                            break;
                        case 3:
                            System.out.println("Add funds to your account");
                            card.setAccountBalance(card.addFunds());
                            System.out.println("Your new account balance is " + card.getAccountBalance());
                            break;
                        case 4:
                            System.out.println("PIN change");
                            System.out.println("Enter your current PIN");
                            int currentPin = scan.nextInt();
                            if (currentPin == card.getPin()) {
                                System.out.println("Please enter four digits for your new PIN");
                                int newPin = scan.nextInt();
                                card.setPin(newPin);
                            }
                            break;
                        case 5:
                            System.out.println("Top-Up your phone");
                            card.topupYourPhone();
                            break;
                        case 6:
                            System.out.println("Cancel");
                            running = false;
                            break;
                        default:
                            System.out.println("Please enter number from 1-6");
                            machine.showMenu();
                            break;
                    }

                } else {
                    System.out.println("Sorry your card is no longer active");
                    running = false;
                }
            }
        } else {
            System.out.println("zły pin");
        }
    }

    public void showMenu() {
        System.out.println("Welcome in you Cash Machine, please select a service");
        System.out.println("Press 1 for: Cash withdrawal");
        System.out.println("Press 2 for: Available funds");
        System.out.println("Press 3 for: Add funds to your account");
        System.out.println("Press 4 for: PIN change");
        System.out.println("Press 5 for: Top-Up your phone");
        System.out.println("Press 6 for: Cancel");

    }
}
