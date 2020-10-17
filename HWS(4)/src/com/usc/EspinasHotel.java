package com.usc;

public class EspinasHotel extends Hotel {

    public EspinasHotel() {
        super(3, new String[] {"milad movassagh", "ali sharifi", "mehdi karimi"}, new String[] {"0024760012", "0035780012", "0052231063"},
                100, "3000000 rial", "1500000 rial");
    }

    @Override
    public void showRecreationalPlaces() {
        System.out.println("Leisure places inside the hotel are:");
        System.out.println("1:Restaurant and Fast food\n2:Tennis hall\n3:Massage salon\n4:Shopping center\n5:Pool");
    }
}
