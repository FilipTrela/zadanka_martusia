package com.model.day1.game;

import lombok.Data;

import java.util.Random;
@Data

public class Gracz {
    private char znakGracza = 'o';
    private final int maxWys;
    private final int minWys = 1;
    private final int minSzer = 1;
    private final int maxSzer;
    private int wysokoscGracza ;
    private int poprzedniaWysokosc;
    private int szerokoscGracza;
    private int poprzedniaSzerokosc;


    public void ruszGraczem(String ruch) {
        if (ruch.equalsIgnoreCase("Góra")) {
            if (wysokoscGracza == minWys) {
                System.err.println("Dalej sie nie da!");
            } else {
                poprzedniaWysokosc = wysokoscGracza--;
                poprzedniaSzerokosc = szerokoscGracza;
            }
        } else if (ruch.equalsIgnoreCase("Dół")) {
            if (wysokoscGracza == maxWys) {
                System.err.println("Dalej sie nie da!");
            } else {
                poprzedniaWysokosc = wysokoscGracza++;
                poprzedniaSzerokosc = szerokoscGracza;
            }
        } else if (ruch.equalsIgnoreCase("Prawo")) {
            if (szerokoscGracza == maxSzer) {
                System.err.println("Dalej sie nie da!");
            } else {
                poprzedniaSzerokosc = szerokoscGracza++;
                poprzedniaWysokosc = wysokoscGracza;

            }
        } else if (ruch.equalsIgnoreCase("Lewo")) {
            if (szerokoscGracza == minSzer) {
                System.err.println("Dalej sie nie da!");
            } else {
                poprzedniaSzerokosc = szerokoscGracza--;
                poprzedniaWysokosc = wysokoscGracza;

            }

        } else System.err.println("Zła komenda");
    }

    public void randomoweUstawienieGracza() {
        Random random = new Random();
        this.wysokoscGracza=random.nextInt(maxWys-1)+1;
        this.szerokoscGracza=random.nextInt(maxSzer-1)+1;
        this.poprzedniaWysokosc=wysokoscGracza;
        this.poprzedniaSzerokosc=szerokoscGracza;
    }

    public Gracz(int maxWys, int maxSzer) {
        this.maxWys = maxWys;
        this.maxSzer = maxSzer;
    }
}
