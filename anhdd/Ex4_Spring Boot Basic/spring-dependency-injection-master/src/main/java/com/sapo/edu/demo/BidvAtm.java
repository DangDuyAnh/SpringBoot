package com.sapo.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BidvAtm implements Atm {
    @Value("${atm.initMoney}")
    private BigDecimal moneyAtm;

    @Autowired PrinterFile printerFile;
    private Printer printer;

    public BidvAtm(){
        this.moneyAtm = null;
        this.printer = new PrinterConsole();
    }
    public BidvAtm(BigDecimal moneyAtm, Printer printer) {
        this.moneyAtm = moneyAtm;
        this.printer = printer;
    }

    @Override
    public void withDraw(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) < 0) {
            printer.printMessage("Amount is invalid");
            return;
        }
        if (customer.getBalance().compareTo(amount) < 0) {
            printer.printMessage("Insufficient Balance");
            return;
        }
        if (amount.compareTo(moneyAtm) >= 0) {
            printer.printMessage("ATM is out of money");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.subtract(amount));
        moneyAtm = moneyAtm.subtract(amount);
    }

    @Override
    public void printCurrentMoney() {
        printer.printMessage("Current ATM money is " + moneyAtm.toString());
    }

    @Override
    public void deposit(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) <= 0) {
            printer.printMessage("Amount is invalid");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.add(amount));
        moneyAtm = moneyAtm.add(amount);
    }

    public void writeToFile(Customer customer) {
        printerFile.printCustomer(customer);
    }
    @Override
    public void displayCustomerInfo(Customer customer) {
        printer.printCustomer(customer);
    }
}
