package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Enter the data. (E.g. Иванов Иван Иванович 17.12.1980)");
        Scanner cin = new Scanner(System.in);
        String input = cin.nextLine();
        System.out.println("You entered: " + input);
        Person person = new Person(input);
        System.out.println("Output:" + person.getFormatted());
    }
}
