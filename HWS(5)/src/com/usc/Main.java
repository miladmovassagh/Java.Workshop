package com.usc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Store<String, String, String, String> store = new Store<>();
        System.out.println("1:show product information");
        System.out.println("2:show inventory in store");
        System.out.print("enter your choice: ");
        int choice = Integer.parseInt(input.nextLine());
        switch(choice) {
            case 1:
                System.out.print("enter the name of product: ");
                String productName = input.nextLine();
                try {
                    store.showProductInformation(productName);
                } catch(ExceptionManager e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                store.showProductInventory();
                break;
            default:
                System.out.println("invalid choice");
        }
    }
}
