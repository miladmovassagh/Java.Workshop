package com.usc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the recipient first and last name: ");
        String name1 = input.nextLine();
        System.out.print("enter the recipient ID number: ");
        String id1 = input.nextLine();
        System.out.print("enter the recipient address: ");
        String address = input.nextLine();
        System.out.print("enter the recipient postal code: ");
        String code = input.nextLine();
        System.out.print("enter the sender first and last name: ");
        String name2 = input.nextLine();
        System.out.print("enter the sender ID number: ");
        String id2 = input.nextLine();

        PostOffice postOffice = new PostOffice(name1, id1, address, code, name2, id2);
        postOffice.showInformation();
    }
}
