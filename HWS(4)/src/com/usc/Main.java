package com.usc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EspinasHotel espinasHotel = new EspinasHotel();
        System.out.println("Espinas Hotel Reservation:");
        System.out.println("1:Show employees information");
        System.out.println("2:Show the number of rooms and the price of rooms");
        System.out.println("3:Show entertainment venues inside the hotel");
        System.out.println("4:Room Reservation");
        System.out.print("enter your choice: ");
        int choice = Integer.parseInt(input.nextLine());
        switch(choice) {
            case 1:
                espinasHotel.showEmployeesInfo();
                break;
            case 2:
                espinasHotel.showRooms();
                break;
            case 3:
                espinasHotel.showRecreationalPlaces();
                break;
            case 4:
                System.out.print("enter your name: ");
                String name = input.nextLine();
                System.out.print("enter your id: ");
                String id = input.nextLine();
                System.out.print("enter your age: ");
                int age = Integer.parseInt(input.nextLine());
                System.out.println("Empty rooms is: 97,25,12,78");
                System.out.print("enter the room number you want to book: ");
                int roomNumber = Integer.parseInt(input.nextLine());
                System.out.print("enter the number of people: ");
                int numberPeople = Integer.parseInt(input.nextLine());
                try {
                    espinasHotel.checkInformation(name, id, age, roomNumber, numberPeople);
                } catch(ExceptionManager e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("the entered option is incorrect.");
        }
    }
}
