package com.sapo.edu.demo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
@Component
@ConfigurationProperties(prefix = "file")
public class PrinterFile implements Printer {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    @Override
    public void printCustomer(Customer customer) {
        try {
            FileWriter fw = new FileWriter(path);
            fw.write("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
            fw.close();
            System.out.println("Write successfully to " + path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void printMessage(String message) {
    }
}
