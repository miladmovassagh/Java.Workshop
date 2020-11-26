package com.usc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1:insert new file information");
        System.out.println("2:update file information");
        System.out.println("3:show file information");
        System.out.println("4:delete file");
        System.out.print("enter your choice: ");
        int choice = Integer.parseInt(input.nextLine());
        switch(choice) {
            case 1:
                System.out.print("enter the name of file: ");
                String name = input.nextLine();
                System.out.print("enter the size of file: ");
                String size = input.nextLine();
                System.out.print("enter the extension of file: ");
                String extension = input.nextLine();
                FileManagement fileManagement = new FileManagement().setName(name).setSize(size).setExtension(extension);
                try {
                    fileManagement.connection();
                    fileManagement.insert();
                    fileManagement.commit();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print("enter the name of file you want to update: ");
                String name1 = input.nextLine();
                System.out.print("enter the new size of file: ");
                String size1 = input.nextLine();
                System.out.print("enter the new extension of file: ");
                String extension1 = input.nextLine();
                FileManagement fileManagement1 = new FileManagement().setName(name1).setSize(size1).setExtension(extension1);
                try {
                    fileManagement1.connection();
                    fileManagement1.update();
                    fileManagement1.commit();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                FileManagement fileManagement2;
                System.out.println("1:show information of all files");
                System.out.println("2:show information of the desired file");
                System.out.print("enter your choice: ");
                int choice1 = Integer.parseInt(input.nextLine());
                switch(choice1) {
                    case 1:
                        fileManagement2 = new FileManagement();
                        try {
                            fileManagement2.connection();
                            fileManagement2.select();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.print("enter the name of file whose information you want to show: ");
                        String name2 = input.nextLine();
                        fileManagement2 = new FileManagement().setName(name2);
                        try {
                            fileManagement2.connection();
                            fileManagement2.select();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;
            case 4:
                System.out.print("enter the name of file you want to delete: ");
                String name3 = input.nextLine();
                FileManagement fileManagement3 = new FileManagement().setName(name3);
                try {
                    fileManagement3.connection();
                    fileManagement3.delete();
                    fileManagement3.commit();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("invalid choice number.");
        }
    }
}
