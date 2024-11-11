package com.sapo.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired BidvAtm bidvAtm;
    @Override
    public void run(String... args) throws Exception {
        String name;
        String pin;
        BigDecimal balance;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----Nhập thông tin Customer----");
        System.out.print("Tên: ");
        name = scanner.nextLine();
        System.out.print("Mã pin: ");
        pin = scanner.nextLine();
        System.out.print("Số dư: ");
        balance = scanner.nextBigDecimal();

        Customer customer = new Customer(name, pin, balance);
        customer.info();

        //Demo function
//        Atm bidvAtm = new BidvAtm();
        bidvAtm.printCurrentMoney();
        bidvAtm.displayCustomerInfo(customer);
        bidvAtm.withDraw(customer, new BigDecimal(200000));
        bidvAtm.printCurrentMoney();
        bidvAtm.withDraw(customer, new BigDecimal(10000000));
        bidvAtm.printCurrentMoney();
        bidvAtm.deposit(customer,new BigDecimal(1000000));
        bidvAtm.printCurrentMoney();
        bidvAtm.writeToFile(customer);

//        PrinterFile printerFile_2 = new PrinterFile();
//        System.out.println("path printerFile_2: " + printerFile_2.getPath());
//        BidvAtm bidvAtm_2 = new BidvAtm();
//        System.out.println("bidvAtm_2 init money: ");
//        bidvAtm_2.printCurrentMoney();
    }
}
