package atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class atmSimulation {
    private static int currentId;
    private static ArrayList<SavingsAccount> savingsAccounts;
    private static ArrayList<CheckingAccount> checkingAccounts;

    public static void main(String[] args) {
        Random initBalanceGenerator = new Random();

        savingsAccounts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            savingsAccounts.add(new SavingsAccount(100000 + i, initBalanceGenerator.nextInt(10000)));
        }

        //For testing purposes
        for (SavingsAccount s : savingsAccounts) {
            s.setAnnualInterestRate(0.02);
        }

        checkingAccounts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            checkingAccounts.add(new CheckingAccount(200000 + i, initBalanceGenerator.nextInt(10000)));
        }

        //For testing purposes
        for(CheckingAccount c : checkingAccounts) {
            c.setOverDraft(1000);
        }

        idMenu();
    }

    private static void idMenu() {
        Scanner idInput = new Scanner(System.in);

        System.out.println("Please enter your account ID: ");
        int userIdInput = idInput.nextInt();

        if (idIsValid(userIdInput)) {
            currentId = userIdInput;
            mainMenu();
        } else {
            System.out.println("Invalid ID. Please try again. \n");
            idMenu();
        }
    }

    private static boolean idIsValid(int idInput) {
        boolean containsId = false;
        for (CheckingAccount c : checkingAccounts) {
            if (c.getId() == idInput) containsId = true;
        }

        for (SavingsAccount s : savingsAccounts) {
            if (s.getId() == idInput) containsId = true;
        }

        return containsId;
    }

    private static void mainMenu() {
        Scanner mmenuReader = new Scanner(System.in);
        System.out.println(
          "Main Menu \n" +
          "1. Check the balance \n" +
          "2. Withdraw \n" +
          "3. Deposit \n" +
          "4. Exit \n" +
          "Please select an option: \n"
        );

        switch(mmenuReader.nextInt()) {
            case 1: checkBalanceMenu();
                    break;
            case 2: withdrawalMenu();
                    break;
            case 3: depositMenu();
                    break;
            case 4: exitMenu(1);
                    break;
            case 0: exitMenu(0);
            default:    System.out.println("Error on input. Please try again.");
                        idMenu();
                        break;
        }
    }

    private static void checkBalanceMenu() {
        String currentIdString = Integer.toString(currentId);
        char accType = currentIdString.charAt(0);
        int accTypeInt = Character.getNumericValue(accType);

        if (accTypeInt == 1) {
            SavingsAccount currentSavingsAccount = null;
            for (SavingsAccount s : savingsAccounts) {
                if (currentId == s.getId()) {
                    currentSavingsAccount = s;
                }
            }
            checkBalanceSubMenu(currentSavingsAccount);
        } else if (accTypeInt == 2) {
            CheckingAccount currentCheckingAccount = null;
            for (CheckingAccount c : checkingAccounts) {
                if (currentId == c.getId()) {
                    currentCheckingAccount = c;
                }
            }
            checkBalanceSubMenu(currentCheckingAccount);
        } else {
            System.out.println("Internal System Error on AccType");
        }
    }

    private static void checkBalanceSubMenu(Account accountInput) {
        Scanner menuReader = new Scanner(System.in);

        System.out.println(
                "Your account balance is: R" + accountInput.getBalance() +
                        "\n" +
                        "1. Main Menu \n" +
                        "2. Exit \n" +
                        "Please select an option: \n"
        );
        switch(menuReader.nextInt()) {
            case 1: mainMenu();
                    break;
            case 2: exitMenu(1);
                    break;
            default: System.out.println("Error on input");
                     idMenu();
                     break;
        }
    }

    private static void withdrawalMenu() {
        String currentIdString = Integer.toString(currentId);
        char accType = currentIdString.charAt(0);
        int accTypeInt = Character.getNumericValue(accType);

        if (accTypeInt == 1) {
            SavingsAccount currentSavingsAccount = null;
            for (SavingsAccount s : savingsAccounts) {
                if (currentId == s.getId()) {
                    currentSavingsAccount = s;
                }
            }
            withdrawalSubMenu(currentSavingsAccount);
        } else if (accTypeInt == 2) {
            CheckingAccount currentCheckingAccount = null;
            for (CheckingAccount c : checkingAccounts) {
                if (currentId == c.getId()) {
                    currentCheckingAccount = c;
                }
            }
            withdrawalSubMenu(currentCheckingAccount);
        } else {
            System.out.println("Internal System Error on AccType");
        }
    }

    private static void withdrawalSubMenu(Account currentAccountInput) {
        Scanner withdrawalInput = new Scanner(System.in);
        System.out.println(
            "Your current account balance is: R" + currentAccountInput.getBalance() + "\n" +
            "\n" +
            "Please enter amount to withdraw (in Rands): "
        );

        currentAccountInput.withdraw(withdrawalInput.nextDouble());

        if (currentAccountInput.getWithdrawalSuccessful()) {
            System.out.println(
                    "Withdrawal successful. \n" +
                    "\n" +
                    "1. View New Balance \n" +
                    "2. Main Menu \n" +
                    "3. Exit \n" +
                    "Please select an option: "
            );

            switch(withdrawalInput.nextInt()) {
                case 1: checkBalanceMenu();
                        break;
                case 2: mainMenu();
                        break;
                case 3: exitMenu(1);
                        break;
                default:
                    System.out.println("Error on input. Please try again \n");
                    idMenu();
                    break;
            }
        } else if (!currentAccountInput.getWithdrawalSuccessful()) {
            System.out.println(
                    "Withdrawal Unsuccessful: " + currentAccountInput.withdrawalUnsuccessfulMessage() +
                    "\n" +
                    "1. Withdraw a different amount \n" +
                    "2. Main Menu \n" +
                    "3. Exit \n" +
                    "Please select an option: "
            );

            switch(withdrawalInput.nextInt()) {
                case 1: withdrawalMenu();
                    break;
                case 2: mainMenu();
                    break;
                case 3: exitMenu(1);
                    break;
                default:
                    System.out.println("Error on input. Please try again \n");
                    idMenu();
                    break;
            }
        }
    }

    private static void depositMenu() {
        String currentIdString = Integer.toString(currentId);
        char accType = currentIdString.charAt(0);
        int accTypeInt = Character.getNumericValue(accType);

        if (accTypeInt == 1) {
            SavingsAccount currentSavingsAccount = null;
            for (SavingsAccount s : savingsAccounts) {
                if (currentId == s.getId()) {
                    currentSavingsAccount = s;
                }
            }
            depositSubMenu(currentSavingsAccount);
        } else if (accTypeInt == 2) {
            CheckingAccount currentCheckingAccount = null;
            for (CheckingAccount c : checkingAccounts) {
                if (currentId == c.getId()) {
                    currentCheckingAccount = c;
                }
            }
            depositSubMenu(currentCheckingAccount);
        } else {
            System.out.println("Internal System Error on AccType");
            exitMenu(1);
        }
    }

    private static void depositSubMenu(Account currentAccountInput) {
        System.out.println("Please enter amount to deposit: ");
        Scanner menuInput = new Scanner(System.in);
        currentAccountInput.deposit(menuInput.nextDouble());

        System.out.println(
                "1. View new balance \n" +
                "2. Main Menu \n" +
                "3. Exit \n" +
                "Please select an option: "
        );

        switch(menuInput.nextInt()) {
            case 1: checkBalanceMenu();
                    break;
            case 2: mainMenu();
                    break;
            case 3: exitMenu(1);
                    break;
            default:
                System.out.println("Error on input. Please try again.");
                idMenu();
                break;
        }
    }

    private static void exitMenu(int pathway) {
        switch(pathway) {
            case 0:
                System.out.println("System shutdown.");
                System.exit(0);
            case 1:
                System.out.println("Thank you for using our service. \n ");
                idMenu();
                break;
        }
    }
}
