package com.sapo.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean check = true;
		Scanner scanner = new Scanner(System.in);

		while(check) {
			try {
				System.out.println("----Choose one method----");
				System.out.println("containsAny: 1, containsIgnoreCase: 2, countMatches: 3, appendIfMissing: 4, prependIfMissing: 5, " +
						"uppercase: 6, lowercase: 7, EXIT: enter");
				String choice = scanner.nextLine();
				switch (choice) {
					case "1":
						int count ;
						System.out.print("Nhap xau: ");
						String baseString = scanner.nextLine();
						System.out.print("So luong xau con: ");
						count = scanner.nextInt();
						scanner.nextLine();
						String arrStr[] = new String[count];
						boolean rs;
						for (int i = 0; i < count; i++) {
							System.out.print("Xau con " + (i + 1) + ": ");
							arrStr[i] = scanner.nextLine();
							}
						rs = StringUtils.containsAny(baseString, arrStr);
						System.out.println("Ket qua: " + rs);
						break;
					case "2":
						String childString;
						System.out.print("Nhap xau: ");
						baseString = scanner.nextLine();
						System.out.print("Nhap xau con: ");
						childString = scanner.nextLine();
						rs = StringUtils.containsIgnoreCase(baseString, childString);
						System.out.println("Ket qua: " + rs);
						break;
					case "3":
						int pos;
						System.out.print("Nhap xau: ");
						baseString = scanner.nextLine();
						System.out.print("Nhap xau con: ");
						childString = scanner.nextLine();
						pos = StringUtils.countMatches(baseString, childString);
						System.out.println("Ket qua: " + pos);
						break;
					case "4":
						String target;
						System.out.print("Nhap xau: ");
						baseString = scanner.nextLine();
						System.out.print("Nhap xau con: ");
						childString = scanner.nextLine();
						target = StringUtils.appendIfMissing(baseString, childString);
						System.out.println("Ket qua: " + target);
						break;
					case "5":
						System.out.print("Nhap xau: ");
						baseString = scanner.nextLine();
						System.out.print("Nhap xau con: ");
						childString = scanner.nextLine();
						target = StringUtils.prependIfMissing(baseString, childString);
						System.out.println("Ket qua: " + target);
						break;
					case "6":
						System.out.print("Nhap xau: ");
						baseString = scanner.nextLine();
						System.out.println("Ket qua: " + baseString.toUpperCase());
						break;
					case "7":
						System.out.print("Nhap xau: ");
						baseString = scanner.nextLine();
						System.out.println("Ket qua: " + baseString.toLowerCase());
						break;
					default:
						check = false;
				}
			}
			catch (Exception e) {
				break;
			}
		}
	}

}
