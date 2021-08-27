package atm;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private Date dateCreated;
    private boolean isChecking;
    private double overdraft;
    private boolean withdrawalSuccessful;
    private int withdrawalUnsuccessfulMessage;

    public Account(int inputId, int initBalance) {
        setId(inputId);
        setBalance(initBalance);
        this.dateCreated = new Date();
    }

    public int getId() {return id;}
    public void setId(int inputId) {this.id = inputId;}

    public double getBalance() {return balance;}
    public void setBalance(double inputBalance) {this.balance = inputBalance;}

    public Date getDateCreated() {return dateCreated;}

    public void withdraw(double withdrawalAmount) {
        if (isChecking) {
            if (withdrawalAmount <= getBalance()) {
                setBalance(getBalance() - withdrawalAmount);
                setWithdrawalSuccessful(true);
            } else if (withdrawalAmount > getBalance()) {
                if(!((getBalance() - withdrawalAmount) < (getOverdraft() * -1))) {
                    setBalance(getBalance() - withdrawalAmount);
                    setWithdrawalSuccessful(true);
                } else {
                    setWithdrawalSuccessful(false);
                    setWithdrawalUnsuccessfulMessage(1);
                }
            }
        } else {
            if (withdrawalAmount <= getBalance()) {
                setBalance(getBalance() - withdrawalAmount);
                setWithdrawalSuccessful(true);
            } else if (withdrawalAmount > getBalance()) {
                setWithdrawalSuccessful(false);
                setWithdrawalUnsuccessfulMessage(1);
            }
        }
    }

    public void setWithdrawalSuccessful(boolean withdrawalSuccessfulInput) {
        this.withdrawalSuccessful = withdrawalSuccessfulInput;
    }

    public boolean getWithdrawalSuccessful() {
        return withdrawalSuccessful;
    }

    public String withdrawalUnsuccessfulMessage() {
        switch(withdrawalUnsuccessfulMessage) {
            case 1: return "Insufficient funds";
            default: return "Internal System Error";
        }
    }

    private void setWithdrawalUnsuccessfulMessage(int setWithdrawalUnsuccessfulMessageInput) {
        this.withdrawalUnsuccessfulMessage = setWithdrawalUnsuccessfulMessageInput;
    }

    public void setOverDraft(double overdraftInput) {
        this.overdraft = overdraftInput;
    }

    private double getOverdraft() {
        return overdraft;
    }

    public void deposit(double depositAmount) { setBalance(getBalance() + depositAmount); }

    public void setIsChecking(boolean isCheckingInput) {
        this.isChecking = isCheckingInput;
    }
}

class SavingsAccount extends Account{
    private double annualInterestRate;

    public SavingsAccount(int inputId, int initBalance) {
        super(inputId, initBalance);
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 12);
    }

    public double getMonthlyInterest(double balanceInput) {
        return (balanceInput * getMonthlyInterestRate());
    }

    public void setAnnualInterestRate(double setAnnualInterestRateInput) {this.annualInterestRate = setAnnualInterestRateInput;}

    public double getAnnualInterestRate() {return annualInterestRate;}

    //for testing purposes
    public String toString() {
        return "Account ID: " + getId() + " | " + "Account Balance: " + getBalance() + " | " +
               "Annual Interest Rate: " + getAnnualInterestRate() + " | " + "Monthly Interest Rate:" + getMonthlyInterestRate() +
                " | " + "Date Created: " + getDateCreated();
    }
}

class CheckingAccount extends Account {
    private double overdraft;

    public CheckingAccount(int inputId, int initBalance) {
        super(inputId, initBalance);
        super.setIsChecking(true);
        super.setOverDraft(this.overdraft);
    }

    public double getOverdraft() {
        return this.overdraft;
    }

    //for testing purposes
    public String toString() {
        return "Account ID: " + getId() + " | " + "Account Balance: " + getBalance() + " | " + "Overdraft Limit: " + getOverdraft() +
                " | " + "Date Created: " + getDateCreated();
    }
}