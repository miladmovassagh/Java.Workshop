package com.usc;

import java.util.Arrays;

public abstract class Hotel {
    private int employeesNumber;
    private String[] employeesName;
    private String[] employeesId;
    private int roomsNumber;
    private String priceOfMasterRoom;
    private String priceOfNormalRoom;

    public Hotel() {

    }

    public Hotel(int employeesNumber, String[] employeesName, String[] employeesId, int roomsNumber, String priceOfMasterRoom, String priceOfNormalRoom) {
        setEmployeesNumber(employeesNumber);
        setEmployeesName(employeesName);
        setEmployeesId(employeesId);
        setRoomsNumber(roomsNumber);
        setPriceOfMasterRoom(priceOfMasterRoom);
        setPriceOfNormalRoom(priceOfNormalRoom);
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String[] getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String[] employeesName) {
        this.employeesName = employeesName;
    }

    public String[] getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(String[] employeesId) {
        this.employeesId = employeesId;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public String getPriceOfMasterRoom() {
        return priceOfMasterRoom;
    }

    public void setPriceOfMasterRoom(String priceOfMasterRoom) {
        this.priceOfMasterRoom = priceOfMasterRoom;
    }

    public String getPriceOfNormalRoom() {
        return priceOfNormalRoom;
    }

    public void setPriceOfNormalRoom(String priceOfNormalRoom) {
        this.priceOfNormalRoom = priceOfNormalRoom;
    }

    public void showEmployeesInfo() {
        System.out.println("number of employees: " + getEmployeesNumber());
        System.out.println("name of employees:");
        System.out.println(Arrays.toString(getEmployeesName()));
        System.out.println("id of employees:");
        System.out.println(Arrays.toString(getEmployeesId()));
    }

    public void showRooms() {
        System.out.println("the number of rooms: " + getRoomsNumber());
        System.out.println("Master room prices is: " + getPriceOfMasterRoom());
        System.out.println("Normal room prices is: " + getPriceOfNormalRoom());
    }

    public abstract void showRecreationalPlaces();

    public void checkInformation(String name, String id, int age, int roomNumber, int numberPeople) throws ExceptionManager {
        int i;
        for(i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)))
                throw new ExceptionManager("invalid name!");
        }
        if(id.length() < 10)
            throw new ExceptionManager("invalid id!");
        else {
            for (i = 0; i < id.length(); i++)
                if (!Character.isDigit(id.charAt(i)))
                    throw new ExceptionManager("invalid id!");
        }
        if(age < 18)
            throw new ExceptionManager("invalid age!");
        else if(roomNumber != 97 && roomNumber != 25 && roomNumber != 12 && roomNumber != 78)
            throw new ExceptionManager("the room is reserved!");
        else if(numberPeople > 4)
            throw new ExceptionManager("the number of people is more than the capacity of the room!");
        else
            System.out.println("the room was booked.");
    }
}
