package com.usc;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1:show product categories");
        System.out.println("2:show product information of category");
        System.out.println("3:insert products");
        System.out.print("enter your choice: ");
        int choice = Integer.parseInt(input.nextLine());
        switch(choice) {
            case 1:
                System.out.println("Category of products:");
                System.out.println("1:" + CategoriesName.VEGETABLES.toString());
                System.out.println("2:" + CategoriesName.FRUITS.toString());
                System.out.println("3:" + CategoriesName.SUMMERS.toString());
                break;
            case 2:
                System.out.print("enter the product category name: ");
                String categoryName = input.nextLine();
                try {
                    Categories categories = CategoriesFactory.getCategories(categoryName.toUpperCase());
                    categories.showProducts();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.print("enter the product category name: ");
                String categoryName1 = input.nextLine();
                System.out.print("enter the product name: ");
                String productName = input.nextLine();
                System.out.print("enter the product price (per kilo): ");
                long price = Long.parseLong(input.nextLine());
                try {
                    Categories categories = CategoriesFactory.getCategories(categoryName1.toUpperCase());
                    categories.insert(productName, price);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("invalid choice number");
        }
    }
}
